package org.humingk.movie.server.user.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.api.auth.OauthApi;
import org.humingk.movie.api.user.LoginApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.enumeration.StateAndMessage;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.common.util.AesUtil;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录
 *
 * @author humingk
 */
@Slf4j
@Validated
@RestController
public class LoginController implements LoginApi {

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

    @Autowired
    private OauthApi oauthApi;

    /**
     * auth 登录
     *
     * @param email    用户邮箱
     * @param password 密码
     * @return
     */
    @Override
    @PostMapping("login")
    public Result login(@RequestParam("username") @NotBlank String email,
                        @RequestParam("password") @NotBlank String password) {
        try {
            Map<String, String> params = new HashMap() {{
                put("username", AesUtil.decrypt(email));
                put("password", AesUtil.decrypt(password));
                put("grant_type", "password");
                put("scope", authClientScopes);
                put("client_id", authClientId);
                put("client_secret", authClientSecret);
            }};
            return Result.success(oauthApi.postAccessToken(params));
        } catch (Exception e) {
            log.error("登录出错", e);
            throw new MyException(StateAndMessage.ERROR, e.getMessage());
        }
    }

    /**
     * github 第三方登录
     *
     * @param response
     * @throws IOException
     */
    @Override
    @GetMapping("/github_login")
    public void githubLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(githubAuthorizeUri
                + "?response_type=code"
                + "&client_id=" + githubClientId
                + "&state=state"
                + "&redirect_uri=" + githubCallbackUri);
    }

    /**
     * github 第三方登录 回调方法
     *
     * @param code  授权码（授权码模式）
     * @param state github_login传入的state
     * @return
     * @throws IOException
     */
    @Override
    @GetMapping("/github_callback")
    public Result githubCallback(@RequestParam("code") String code,
                                 @RequestParam("state") String state) {
        // github申请token的请求参数
        Map<String, String> params = new HashMap() {{
            put("grant_type", "authorization_code");
            put("redirect_uri", githubCallbackUri);
            put("client_id", githubClientId);
            put("client_secret", githubClientSecret);
            put("code", code);
        }};
        Map<String, Object> result = new HashMap<>();
        try {
            // 申请github-token
            // eg: access_token=...&scope=&token_type=bearer
            String body = Jsoup.connect(githubAccessTokenUri)
                    .ignoreContentType(true).data(params)
                    .post().body().text();
            for (String b : body.trim().split("&")) {
                String[] keyValue = b.split("=", -1);
                result.put(keyValue[0], keyValue[1]);
            }
            result.put("user_info",
                    JSONObject.parseObject(
                            // 通过token获取github个人信息
                            Jsoup.connect(githubUserUri)
                                    .ignoreContentType(true)
                                    .data("access_token", (String) result.get("access_token"))
                                    .data("token_type", (String) result.get("token_type"))
                                    .get().body().text()
                    )
            );
        } catch (Exception e) {
            log.error("Github申请token失败", e);
        }
        return Result.success(result);
    }
}
