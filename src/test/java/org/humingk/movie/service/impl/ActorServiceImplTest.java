package org.humingk.movie.service.impl;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.CooperationActor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorServiceImplTest extends baseTest {

    @Test
    public void getActorByActorId() {
    }

    @Test
    public void getAllMoviesByActorId() {
        new ActorServiceImpl().getAllMoviesByActorId(1054524);
    }

    @Test
    public void getCoperationActor() {
        CooperationActor cooperationActor = new ActorServiceImpl().getCoperationActor(1054524, 3);

        for (Integer key : cooperationActor.getActorMap().keySet()) {
            System.out.println(key + "-" + cooperationActor.getActorMap().get(key).toString());
        }
        System.out.println("---------------");
        for (Integer key : cooperationActor.getMovieMap().keySet()) {
            System.out.println(key + "-" + cooperationActor.getMovieMap().get(key).toString());
        }
        System.out.println("---------------");
        for (Integer key:cooperationActor.getActorMovieMap().keySet()){
            System.out.println(key+"-"+cooperationActor.getActorMovieMap().get(key).toString());
        }

    }
}