package org.humingk.movie.server.movie.controller;

import io.jsonwebtoken.Jwts;
import org.humingk.movie.common.annotation.AesDecrypt;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author humingk
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（可选，默认0）
     * @param limit   限制数（可选，默认10）
     * @return
     */
//    @Override
    @AesDecrypt
    @GetMapping("search_movie_tips")
    public Result<List<MovieDouban>> searchMovieTips(@RequestParam("keyword") String keyword,
                                                     @RequestParam(value = "offset",
                                                             required = false,
                                                             defaultValue = "0") int offset,
                                                     @RequestParam(value = "limit",
                                                             required = false,
                                                             defaultValue = "10") int limit) {
        return Result.success(searchService.getMovieDoubanListByNameStart(keyword, offset, limit));
    }

    @GetMapping("/test1")
    public String test() {
        return "test resource movie,nothing need";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test resource movie,need token";
    }

    @GetMapping("token")
    public Object getToken(Authentication authentication) {
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }

    @Value("${security.oauth2.resource.jwt.key-value}")
    private String jwtKeyValue;

    @GetMapping(value = "jwt")
    public Object jwtParser(Authentication authentication) {
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return Jwts.parser()
                .setSigningKey(jwtKeyValue.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(details.getTokenValue())
                .getBody();
    }
}
