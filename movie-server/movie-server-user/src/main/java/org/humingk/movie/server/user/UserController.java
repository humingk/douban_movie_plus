package org.humingk.movie.server.user;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.entity.Result;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author humingk
 */
@Slf4j
@RestController
public class UserController {

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

    @GetMapping("/info")
    public String userInfo() {
        return "movie-server-user";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


    /**
     * github 第三方登录
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("github_login")
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
     * @param code     授权码（授权码模式）
     * @param state
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/github_callback")
    public Result githubCallback(String code, String state, HttpServletResponse response) throws IOException {
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
