package org.humingk.movie.server.user.controller;

import com.alibaba.fastjson.JSONObject;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.api.auth.Oauth2Api;
import org.humingk.movie.api.user.UserApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.service.user.service.RegisterService;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/** @author humingk */
@Slf4j
@RefreshScope
@RestController
public class UserController implements UserApi {

  @Value("${spring.security.oauth2.client.registration.auth.client-id}")
  private String authClientId;

  @Value("${spring.security.oauth2.client.registration.auth.client-secret}")
  private String authClientSecret;

  @Value("${spring.security.oauth2.client.registration.auth.client-scopes}")
  private String authClientScopes;

  @Value("${spring.security.oauth2.client.registration.github.client-id}")
  private String githubClientId;

  @Value("${spring.security.oauth2.client.registration.github.client-secret}")
  private String githubClientSecret;

  @Value("${spring.security.oauth2.client.registration.github.authorize-uri}")
  private String githubAuthorizeUri;

  @Value("${spring.security.oauth2.client.registration.github.callback-uri}")
  private String githubCallbackUri;

  @Value("${spring.security.oauth2.client.registration.github.access-token-uri}")
  private String githubAccessTokenUri;

  @Value("${spring.security.oauth2.client.registration.github.user-uri}")
  private String githubUserUri;

  @Autowired private RegisterService registerService;

  //  @Qualifier("movie-server-auth")
  @Autowired private Oauth2Api oauth2Api;

  @Override
  public Result<Object> login(
      @RequestParam("email") @NotBlank String email,
      @RequestParam("password") @NotBlank String password) {
    Map<String, String> params =
        new HashMap() {
          {
            put("username", email);
            put("password", password);
            put("grant_type", "password");
            put("scope", authClientScopes);
            put("client_id", authClientId);
            put("client_secret", authClientSecret);
          }
        };
    try {
      return Result.success(oauth2Api.postAccessToken(params).getBody());
    } catch (FeignException e) {
      if (e.status() == 400) {
        return Result.error(CodeAndMsg.UNAUTHORIZED, "密码错误");
      } else if (e.status() == 401) {
        return Result.error(CodeAndMsg.NOUSER);
      }
      return Result.error(CodeAndMsg.FORBIDDEN);
    }
  }

  @Override
  public void githubLogin(HttpServletResponse response) throws IOException {
    response.sendRedirect(
        githubAuthorizeUri
            + "?response_type=code"
            + "&client_id="
            + githubClientId
            + "&state=state"
            + "&redirect_uri="
            + githubCallbackUri);
  }

  @Override
  public Result<Object> githubCallback(@NotBlank String code, @NotBlank String state) {
    // github申请token的请求参数
    Map<String, String> params =
        new HashMap() {
          {
            put("grant_type", "authorization_code");
            put("redirect_uri", githubCallbackUri);
            put("client_id", githubClientId);
            put("client_secret", githubClientSecret);
            put("code", code);
          }
        };
    Map<String, Object> result = new HashMap<>();
    try {
      // 申请github-token
      // eg: access_token=...&scope=&token_type=bearer
      String body =
          Jsoup.connect(githubAccessTokenUri)
              .ignoreContentType(true)
              .data(params)
              .post()
              .body()
              .text();
      for (String b : body.trim().split("&")) {
        String[] keyValue = b.split("=", -1);
        result.put(keyValue[0], keyValue[1]);
      }
      result.put(
          "user_info",
          JSONObject.parseObject(
              // 通过token获取github个人信息
              Jsoup.connect(githubUserUri)
                  .ignoreContentType(true)
                  .data("access_token", (String) result.get("access_token"))
                  .data("token_type", (String) result.get("token_type"))
                  .get()
                  .body()
                  .text()));
    } catch (IOException e) {
      log.error("Github申请token失败", e);
    }
    return Result.success(result);
  }

  @Override
  public Result<Object> register(
      @RequestParam(value = "id", required = false, defaultValue = "") String id,
      @RequestParam("email") @NotBlank String email,
      @RequestParam("password") @NotBlank String password) {
    String userId = registerService.register(new User(id, email, password));
    return userId.isEmpty() ? Result.error(CodeAndMsg.BADREQUEST) : login(email, password);
  }

  @Override
  public Result<Object> userInfo(@NotNull Principal principal) {
    return Result.success(ResponseEntity.ok(principal));
  }

  @Override
  public Result<Object> updateId(@NotBlank String id) {
    return null;
  }
}
