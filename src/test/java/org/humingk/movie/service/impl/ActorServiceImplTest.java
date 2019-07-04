package org.humingk.movie.service.impl;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.service.ActorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActorServiceImplTest extends baseTest {

    @Autowired
    private ActorService actorService;

    @Test
    public void getActorByActorId() {
    }

    @Test
    public void getAllMoviesByActorId() {
    }

    @Test
    public void getCoperationActor() {
        CooperationActor cooperationActor = actorService.getCoperationActor(1054524, 3);
    }

    @Test
    public void getMoviesByDirectorId() {
    }

    @Test
    public void getMoviesByWriterId() {
    }

    @Test
    public void getMoviesByLeadingactorId() {
    }
}