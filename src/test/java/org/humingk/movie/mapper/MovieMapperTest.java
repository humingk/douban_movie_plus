package org.humingk.movie.mapper;

import org.humingk.movie.TestBase;
import org.humingk.movie.entity.Movie;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieMapperTest extends TestBase {
    @Autowired
    private MovieMapper movieMapper;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void testSelectByPrimaryKey() throws Exception{
       Integer movieId=1291546;
        Movie movie=movieMapper.selectByPrimaryKey(movieId);
        logger.info("=============================================================================================");
        logger.info(movie.getImdbId()+" "+movie.getName()+" "+movie.getRate()+" "+movie.getAlias());
        logger.info("=============================================================================================");
    }

}