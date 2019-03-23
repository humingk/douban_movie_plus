package org.humingk.movie.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.humingk.movie.TestBase;
import org.humingk.movie.entity.Movie;

public class MovieMapperTest extends TestBase {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void testSelectByPrimaryKey() throws Exception{
       Integer movieId=1291546;
        Movie movie=movieMapper.selectByPrimaryKey(movieId);
        System.out.println("=============================================================================================");
        System.out.println(movie.getImdbId()+" "+movie.getName()+" "+movie.getRate()+" "+movie.getAlias());
        System.out.println("=============================================================================================");
    }

}