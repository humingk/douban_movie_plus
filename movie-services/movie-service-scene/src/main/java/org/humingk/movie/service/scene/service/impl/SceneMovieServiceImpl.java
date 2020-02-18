package org.humingk.movie.service.scene.service.impl;

import org.humingk.movie.dal.domain.scene.*;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.dal.mapper.plus.CelebritySceneMapperPlus;
import org.humingk.movie.service.scene.converter.MovieSceneAllDtoConverter;
import org.humingk.movie.service.scene.converter.MovieSceneBriefDtoConverter;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.humingk.movie.service.scene.service.SceneMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

  /**
   * 获取场景电影信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "此豆瓣电影ID暂无对应场景电影")
  public MovieScene getMovieSceneByMovieDoubanId(Long id) {
    movieSceneExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieScene> movieSceneList = movieSceneMapper.selectByExample(movieSceneExample);
    return movieSceneList.size() != 1 ? null : movieSceneList.get(0);
  }

  /**
   * 获取场景列表
   *
   * @param id 场景电影ID
   * @return
   */
  @NotEmpty(message = "此场景电影ID暂无对应场景列表")
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
    return movieSceneBriefDtoConverter.to(movieScene, sceneBriefDoList);
  }

  @Override
  public MovieSceneAllDto getMovieSceneAllByMovieDoubanId(Long id) {
    MovieScene movieScene = getMovieSceneByMovieDoubanId(id);
    List<SceneAllDo> sceneAllDoList = new ArrayList<>();
    for (Scene scene : getSceneListByMovieSceneId(movieScene.getId())) {
      List<SceneDetailAllDo> sceneDetailAllDoList = new ArrayList<>();
      sceneDetailExample.start().andIdSceneEqualTo(scene.getId());
      for (SceneDetail sceneDetail : sceneDetailMapper.selectByExample(sceneDetailExample)) {
        imageSceneDetailExample.start().andIdSceneDetailEqualTo(sceneDetail.getId());
        // scene detail all
        sceneDetailAllDoList.add(
            new SceneDetailAllDo(
                sceneDetail,
                imageSceneDetailMapper.selectByExample(imageSceneDetailExample),
                celebritySceneMapperPlus.selectCelebritySceneOfSceneDetailListBySceneDetailId(
                    sceneDetail.getId())));
      }
      PlaceScene placeScene = placeSceneMapper.selectByPrimaryKey(scene.getIdPlaceScene());
      imagePlaceSceneExample.start().andIdPlaceSceneEqualTo(placeScene.getId());
      placeSceneToTypePlaceSceneExample.start().andIdPlaceSceneEqualTo(placeScene.getId());
      sceneAllDoList.add(
          new SceneAllDo(
              scene,
              sceneDetailAllDoList,
              // place all
              new PlaceSceneAllDo(
                  placeScene,
                  imagePlaceSceneMapper.selectByExample(imagePlaceSceneExample),
                  placeSceneToTypePlaceSceneMapper.selectByExample(
                      placeSceneToTypePlaceSceneExample),
                  continentSceneMapper.selectByPrimaryKey(placeScene.getIdContinentScene()),
                  countrySceneMapper.selectByPrimaryKey(placeScene.getIdCountryScene()),
                  citySceneMapper.selectByPrimaryKey(placeScene.getIdCityScene()),
                  stateSceneMapper.selectByPrimaryKey(placeScene.getIdStateScene()))));
    }
    return movieSceneAllDtoConverter.to(movieScene, sceneAllDoList);
  }
}
