package org.humingk.movie.service.douban.converter;

import org.humingk.movie.dal.domain.douban.ImageDoubanDo;
import org.humingk.movie.dal.entity.ImageCelebrityDouban;
import org.humingk.movie.dal.entity.ImageMovieDouban;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ImageDoubanDoConverter {
  ImageDoubanDo to(ImageMovieDouban imageMovieDouban);

  ImageDoubanDo to(ImageCelebrityDouban imageCelebrityDouban);

  List<ImageDoubanDo> toMovieList(List<ImageMovieDouban> imageMovieDoubanList);

  List<ImageDoubanDo> toCelebrityList(List<ImageCelebrityDouban> imageCelebrityDoubanList);
}
