package org.humingk.movie.api.common.converter.scene;

import org.humingk.movie.dal.domain.scene.PlaceSceneAllDo;
import org.humingk.movie.dal.domain.scene.SceneAllDo;
import org.humingk.movie.dal.domain.scene.SceneDetailAllDo;
import org.humingk.movie.dal.entity.CountryScene;
import org.humingk.movie.dal.entity.Scene;
import org.humingk.movie.dal.entity.SceneDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SceneAllVoConverterTest {

  @Autowired private SceneAllVoConverter sceneAllVoConverter;

  @Test
  public void to() {
    Scene scene = new Scene();
    scene.setId(325262346326L);
    List<SceneDetailAllDo> sceneDetailAllDoList = new ArrayList<>();
    SceneDetailAllDo sceneDetailAllDo = new SceneDetailAllDo();
    SceneDetail sceneDetail = new SceneDetail();
    sceneDetail.setId(3525325L);
    sceneDetailAllDo.setSceneDetail(sceneDetail);
    sceneDetailAllDoList.add(sceneDetailAllDo);
    PlaceSceneAllDo placeSceneAllDo = new PlaceSceneAllDo();
    placeSceneAllDo.setCountryScene(new CountryScene((short) 22, "fff", "ddd"));
    SceneAllDo sceneAllDo = new SceneAllDo(scene, sceneDetailAllDoList, placeSceneAllDo);
    System.out.println(sceneAllDo);
    System.out.println("-----------------------------");
    System.out.println(sceneAllVoConverter.to(sceneAllDo));
  }
}
