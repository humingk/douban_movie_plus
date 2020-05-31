package org.humingk.movie.dal.config;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.dal.mapper.auto.MovieDoubanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动时预热mysql
 *
 * @author humingk
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE + 64)
@Component
public class PreHeatMysqlCommandLineRunner implements CommandLineRunner {
  @Autowired private MovieDoubanMapper movieDoubanMapper;

  @Override
  public void run(String... args) throws Exception {
    movieDoubanMapper.selectByPrimaryKey(0L);
  }
}
