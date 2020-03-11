package org.humingk.movie.service.scene.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.domain.scene.*;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.dal.mapper.plus.CelebritySceneMapperPlus;
import org.humingk.movie.service.scene.converter.MovieSceneAllDtoConverter;
import org.humingk.movie.service.scene.converter.MovieSceneBriefDtoConverter;
import org.humingk.movie.service.scene.converter.MovieSceneDtoConverter;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.humingk.movie.service.scene.dto.MovieSceneDto;
import org.humingk.movie.service.scene.service.SceneMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

/** @author humingk */
@Service
@Validated
// @RedisCache
public class SceneMovieServiceImpl implements SceneMovieService {

  /** mapper */
  @Autowired private MovieSceneMapper movieSceneMapper;

  @Autowired private PlaceSceneMapper placeSceneMapper;

  @Autowired private SceneMapper sceneMapper;
  @Autowired private ImagePlaceSceneMapper imagePlaceSceneMapper;
  @Autowired private SceneDetailMapper sceneDetailMapper;
  @Autowired private ImageSceneDetailMapper imageSceneDetailMapper;
  @Autowired private CelebritySceneMapperPlus celebritySceneMapperPlus;
  @Autowired private PlaceSceneToTypePlaceSceneMapper placeSceneToTypePlaceSceneMapper;
  @Autowired private ContinentSceneMapper continentSceneMapper;
  @Autowired private CountrySceneMapper countrySceneMapper;
  @Autowired private CitySceneMapper citySceneMapper;
  @Autowired private StateSceneMapper stateSceneMapper;
  /** example */
  @Autowired private MovieSceneExample movieSceneExample;

  @Autowired private SceneExample sceneExample;
  @Autowired private ImagePlaceSceneExample imagePlaceSceneExample;
  @Autowired private SceneDetailExample sceneDetailExample;
  @Autowired private ImageSceneDetailExample imageSceneDetailExample;
  @Autowired private PlaceSceneToTypePlaceSceneExample placeSceneToTypePlaceSceneExample;
  /** converter */
  @Autowired private MovieSceneAllDtoConverter movieSceneAllDtoConverter;

  @Autowired private MovieSceneBriefDtoConverter movieSceneBriefDtoConverter;
  @Autowired private MovieSceneDtoConverter movieSceneDtoConverter;

  @Override
  public MovieScene getMovieSceneByMovieDoubanId(Long id) {
    movieSceneExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieScene> movieSceneList = movieSceneMapper.selectByExample(movieSceneExample);
    if (movieSceneList.size() == 1) {
      return movieSceneList.get(0);
    } else {
      throw new MyException(CodeAndMsg.NO_RESOURCE);
    }
  }

  @Override
  public List<Scene> getSceneListByMovieSceneId(Long id) {
    sceneExample.start().andIdMovieSceneEqualTo(id);
    return sceneMapper.selectByExample(sceneExample);
  }

  @Override
  public MovieSceneBriefDto getMovieSceneBriefByMovieDoubanId(Long id) {
    MovieScene movieScene = getMovieSceneByMovieDoubanId(id);
    List<SceneBriefDo> sceneBriefDoList = new ArrayList<>();
    for (Scene scene : getSceneListByMovieSceneId(movieScene.getId())) {
      imagePlaceSceneExample.start().andIdPlaceSceneEqualTo(scene.getIdPlaceScene());
      sceneBriefDoList.add(
          new SceneBriefDo(
              scene,
              // place brief
              new PlaceSceneBriefDo(
                  placeSceneMapper.selectByPrimaryKey(scene.getIdPlaceScene()),
                  imagePlaceSceneMapper.selectByExample(imagePlaceSceneExample))));
    }
    return movieSceneBriefDtoConverter.to(movieSceneDtoConverter.to(movieScene), sceneBriefDoList);
  }

  @Override
  public MovieSceneAllDto getMovieSceneAllByMovieDoubanId(Long id) {
    MovieScene movieScene = getMovieSceneByMovieDoubanId(id);
    List<SceneAllDo> sceneAllDoList = new ArrayList<>();
    for (Scene scene : getSceneListByMovieSceneId(movieScene.getId())) {
      List<SceneDetailAllDo> sceneDetailAllDoList = new ArrayList<>();
      sceneDetailExample.start().andIdSceneEqualTo(scene.getId());
      for (SceneDetail sceneDetail : sceneDetailMapper.selectByExample(sceneDetailExample)) {
        // 场景详情图片列表
        imageSceneDetailExample.start().andIdSceneDetailEqualTo(sceneDetail.getId());
        List<ImageSceneDetail> imageSceneDetailList =
            imageSceneDetailMapper.selectByExample(imageSceneDetailExample);
        // 场景影人列表
        List<CelebritySceneOfSceneDetailDo> celebritySceneOfSceneDetailDoList =
            celebritySceneMapperPlus.selectCelebritySceneOfSceneDetailListBySceneDetailId(
                sceneDetail.getId());
        // scene detail all
        sceneDetailAllDoList.add(
            new SceneDetailAllDo(
                sceneDetail, imageSceneDetailList, celebritySceneOfSceneDetailDoList));
      }
      PlaceScene placeScene = placeSceneMapper.selectByPrimaryKey(scene.getIdPlaceScene());
      // 地点图片列表
      imagePlaceSceneExample.start().andIdPlaceSceneEqualTo(placeScene.getId());
      List<ImagePlaceScene> imagePlaceSceneList =
          imagePlaceSceneMapper.selectByExample(imagePlaceSceneExample);
      // 地点类型
      placeSceneToTypePlaceSceneExample.start().andIdPlaceSceneEqualTo(placeScene.getId());
      List<PlaceSceneToTypePlaceScene> placeSceneToTypePlaceSceneList =
          placeSceneToTypePlaceSceneMapper.selectByExample(placeSceneToTypePlaceSceneExample);
      sceneAllDoList.add(
          new SceneAllDo(
              scene,
              sceneDetailAllDoList,
              // place all
              new PlaceSceneAllDo(
                  placeScene,
                  imagePlaceSceneList,
                  placeSceneToTypePlaceSceneList,
                  continentSceneMapper.selectByPrimaryKey(placeScene.getIdContinentScene()),
                  countrySceneMapper.selectByPrimaryKey(placeScene.getIdCountryScene()),
                  citySceneMapper.selectByPrimaryKey(placeScene.getIdCityScene()),
                  stateSceneMapper.selectByPrimaryKey(placeScene.getIdStateScene()))));
    }
    return movieSceneAllDtoConverter.to(movieSceneDtoConverter.to(movieScene), sceneAllDoList);
  }

  @Override
  public List<MovieSceneDto> getMovieSceneListByMovieSceneKeywordStart(
      String keyword, int offset, int limit) {
    movieSceneExample.start().andNameZhLike(keyword.trim() + "%");
    movieSceneExample.or().andNameEnLike(keyword.trim() + "%");
    PageHelper.offsetPage(offset, limit);
    return movieSceneDtoConverter.toList(movieSceneMapper.selectByExample(movieSceneExample));
  }
}
