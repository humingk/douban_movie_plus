package org.humingk.movie.service.douban.converter.celebrity;

import org.humingk.movie.dal.domain.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.domain.MovieDoubanOfCelebrityDoubanDo;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.dal.entity.ImageCelebrityDouban;
import org.humingk.movie.service.douban.converter.ImageDoubanDoConverter;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanDtoConverter.class, ImageDoubanDoConverter.class})
public interface CelebrityDoubanDetailsDtoConverter {
  @Mappings({
    @Mapping(target = "celebrityDoubanDto", source = "celebrityDouban"),
    @Mapping(target = "imageDoubanDoList", source = "imageCelebrityDoubanList")
  })
  CelebrityDoubanDetailsDto to(
      /** 豆瓣影人基础信息 */
      CelebrityDouban celebrityDouban,
      /** 豆瓣影人别称列表 */
      List<AliasCelebrityDouban> aliasCelebrityDoubanList,
      /** 豆瓣影人图片列表 */
      List<ImageCelebrityDouban> imageCelebrityDoubanList,
      /** 与豆瓣影人相关的豆瓣电影列表 */
      List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoList,
      /** 豆瓣影人-电影奖项 */
      List<AwardOfMovieAndCelebrityDoubanDo> awardOfMovieAndCelebrityDoubanDoList);
}
