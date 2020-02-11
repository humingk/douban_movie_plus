package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.vo.MovieDoubanVo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanVoConverterTest {

    @Autowired
    private MovieDoubanVoConverter converter;

    @Test
    public void to() {
        MovieDouban movieDouban = new MovieDouban();
        movieDouban.setId(23464425L);
        movieDouban.setIdTypeVideo((byte) 12);
        movieDouban.setSummary("sssssssssssssssssssss");

        MovieDoubanVo movieDoubanVo = converter.to(movieDouban);
        converter.update(movieDouban, movieDoubanVo);
        System.out.println(movieDouban);
        System.out.println("--------------");
        System.out.println(movieDoubanVo);
    }
}