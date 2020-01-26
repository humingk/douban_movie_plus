package org.humingk.movie.server.movie;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.humingk.movie.api.douban.SearchApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author humingk
 */
@RestController
public class SearchController implements SearchApi {

    @Autowired
    private SearchService searchService;

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword
     * @return
     */
    @Override
    @PostMapping("/search_movie_tips")
    public Result searchMovieTips(@RequestParam("keyword") String keyword) {
        return Result.success(searchService.getMovieDoubanListByNameStart(keyword, 0, 10));
    }

    @GetMapping("/test1")
    public String test(){
        return "test resource movie,nothing need";
    }

    @GetMapping("/test2")
    public String test2(){
        return "test resource movie,need token";
    }

    @GetMapping("token")
    public Object getToken(Authentication authentication){
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }

    @Value("${security.oauth2.resource.jwt.key-value}")
    private String jwtKeyValue;

    @GetMapping(value = "jwt")
    public Object jwtParser(Authentication authentication){
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        return Jwts.parser()
                .setSigningKey(jwtKeyValue.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(details.getTokenValue())
                .getBody();
    }

}
