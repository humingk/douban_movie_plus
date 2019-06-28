package org.humingk.movie.service.impl;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.mapper.ActorMapper;
import org.humingk.movie.mapper.MovieMapper;
import org.humingk.movie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author humin
 * @author J1anbo
 * @see humingk
 */
@Transactional
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Actor getActorByActorId(int actorId) {
        try{
            Actor actor=actorMapper.selectByPrimaryKey(actorId);
            return actor;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByDirectorId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByDirectorId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByWriterId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByWriterId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByLeadingactorId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByLeadingactorId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据演员id获取该演员所参与的所有电影
     *
     * @param actorId
     * @return
     */
    @Override
    public List<List<Movie>> getAllMoviesByActorId(int actorId){
        try{
            List<List<Movie>> movies = new ArrayList();
            //获取主演电影列表
            List<Movie> leadingactorMovies = getMoviesByLeadingactorId(actorId);
            //获取编剧电影列表
            List<Movie> writerMovies = getMoviesByWriterId(actorId);
            //获取导演电影列表
            List<Movie> directerMovies = getMoviesByDirectorId(actorId);

            movies.add(leadingactorMovies);
            movies.add(writerMovies);
            movies.add(directerMovies);
            return movies;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据演员id获取与他合作的所有人员及电影的CooperationActor列表
     *
     * @param actorId
     * @return
     */
    @Override
    public List<CooperationActor> getCoomovieByActorId(int actorId){
        List<CooperationActor> coomovieList = new ArrayList<CooperationActor>();
        try{
            //获取该id相关的所有电影
            List<Integer> allMovie = getMovieIdByMovie(getMoviesByLeadingactorId(actorId));
            allMovie.addAll(getMovieIdByMovie(getMoviesByWriterId(actorId)));
            allMovie.addAll(getMovieIdByMovie(getMoviesByDirectorId(actorId)));
            //数据去重
            HashSet h = new HashSet(allMovie);
            allMovie.clear();
            allMovie.addAll(h);

            List<Actor> actorList = null;
            //遍历该电影相关的每一个人的id
            for(int id:allMovie){
                actorList = actorMapper.selectDirectorsOfMovieById(id);
                actorList.addAll(actorMapper.selectWritersOfMovieById(id));
                actorList.addAll(actorMapper.selectLeadingactorsOfMovieById(id));
                //actorList去重
                h = new HashSet(actorList);
                actorList.clear();
                actorList.addAll(h);
                //在coomovieList中遍历该人员是否存在
                for(Actor actor:actorList){
                    int index = indexOfActor(coomovieList,actor);
                    Movie tempMovie = movieMapper.selectMovieBaseById(id);
                    //该人员第一次出现，添加新的Ccoomovie
                    if(index == -1){
                        List<Movie> temp = new ArrayList<Movie>();
                        temp.add(tempMovie);
                        coomovieList.add(new CooperationActor(actor,temp));
                    }
                    //该人员已存在，直接修改
                    else {
                        coomovieList.get(index).getMovies().add(tempMovie);
                    }
                }
                actorList.clear();
            }
            //在结果列表中去掉搜索的actor
            for(int i = 0;i < coomovieList.size();i++){
                if(coomovieList.get(i).getActor().getActorId().equals(actorId)){
                    coomovieList.remove(i);
                    break;
                }
            }
            //cooperationList根据CooperationActor元素num排序
            Collections.sort(coomovieList, new Comparator<CooperationActor>() {
                @Override
                public int compare(CooperationActor u1, CooperationActor u2) {
                    int diff = u2.getMovieCount() - u1.getMovieCount();
                    if (diff > 0) {
                        return 1;
                    }else if (diff < 0) {
                        return -1;
                    }
                    return 0; //相等为0
                }
            });
            return coomovieList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 接受Movie列表，返回MOvieId列表
     *
     * @param list
     * @return
     */
    public List<Integer> getMovieIdByMovie(List<Movie> list){
        List<Integer> newList = new ArrayList<Integer>();
        for(Movie m:list){
            newList.add(m.getMovieId());
        }
        return newList;
    }

    /**
     * 返回List<Coomovie>中是Actor的位置
     *
     * @param coomovieList
     * @param actor
     * @return
     */
    public int indexOfActor(List<CooperationActor> coomovieList, Actor actor){
        for(int i = 0;i<coomovieList.size();i++) {
            if (coomovieList.get(i).getActor().getActorId().equals(actor.getActorId())) {
                return i;
            }
        }
        return -1;
    }
}
