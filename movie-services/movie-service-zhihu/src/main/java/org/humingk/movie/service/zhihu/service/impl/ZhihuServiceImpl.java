package org.humingk.movie.service.zhihu.service.impl;

import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.MovieZhihu;
import org.humingk.movie.dal.entity.MovieZhihuExample;
import org.humingk.movie.dal.entity.QuestionZhihuExample;
import org.humingk.movie.dal.mapper.auto.MovieZhihuMapper;
import org.humingk.movie.dal.mapper.auto.QuestionZhihuMapper;
import org.humingk.movie.service.zhihu.converter.ZhihuDtoConverter;
import org.humingk.movie.service.zhihu.dto.ZhihuDto;
import org.humingk.movie.service.zhihu.service.ZhihuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class ZhihuServiceImpl implements ZhihuService {
  @Autowired private ZhihuDtoConverter zhihuDtoConverter;
  @Autowired private MovieZhihuMapper movieZhihuMapper;
  @Autowired private QuestionZhihuMapper questionZhihuMapper;
  @Autowired private MovieZhihuExample movieZhihuExample;
  @Autowired private QuestionZhihuExample questionZhihuExample;

  @Override
  public ZhihuDto getMovieZhihuByMovieDoubanId(Long id) {
    movieZhihuExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieZhihu> movieZhihuList = movieZhihuMapper.selectByExample(movieZhihuExample);
    if (movieZhihuList.size() == 1) {
      questionZhihuExample.start().andIdMovieDoubanEqualTo(id);
      return zhihuDtoConverter.to(
          movieZhihuList.get(0), questionZhihuMapper.selectByExample(questionZhihuExample));
    } else {
      throw new MyException(CodeAndMsg.NO_RESOURCE);
    }
  }
}
