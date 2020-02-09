package org.humingk.movie.api.movie;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DoubanApiTest {

    @Test
    public void searchTips() {
        ApiConfig apiConfig = new ApiConfig();
        apiConfig.setStrict(true);
        apiConfig.setAllInOne(true);
        apiConfig.setOutPath("/home/humingk/gits/douban_movie_plus/doc/api");
//        apiConfig.setPackageFilters("org.humingk.movie.api.movie.DoubanApi,org.humingk.movie.api.movie.ImdbApi,org.humingk.movie.api.movie.RateApi");
        ApiDocBuilder.buildApiDoc(apiConfig);
    }
}