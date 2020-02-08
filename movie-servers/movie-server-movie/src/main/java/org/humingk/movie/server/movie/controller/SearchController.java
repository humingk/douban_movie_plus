package org.humingk.movie.server.movie.controller;

import io.jsonwebtoken.Jwts;
import org.humingk.movie.common.annotation.LogRecord;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author humingk
 */
@Validated
@LogRecord
@RefreshScope
@RestController
public class SearchController{

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
    @GetMapping("search_movie_tips")
    public Result searchMovieTips(@RequestParam("keyword") @NotBlank String keyword,
                                                     @RequestParam(value = "offset",
                                                             required = false,
                                                             defaultValue = "0") @PositiveOrZero int offset,
                                                     @RequestParam(value = "limit",
                                                             required = false,
                                                             defaultValue = "10") @PositiveOrZero int limit) {
        return Result.success(searchService.getMovieDoubanListByNameStart(keyword.trim(), offset, limit));
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

    @GetMapping("testx")
    public Result basesList(@RequestBody List<Long> idList){
        System.out.println();
        return Result.success("testx");
    }


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
