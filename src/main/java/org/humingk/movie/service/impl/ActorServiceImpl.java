package org.humingk.movie.service.impl;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.mapper.ActorMapper;
import org.humingk.movie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author humin
 */
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorMapper actorMapper;

    @Override
    public Actor getActor(int actorId) {
        try{
            Actor actor=actorMapper.selectByPrimaryKey(actorId);
            return actor;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
