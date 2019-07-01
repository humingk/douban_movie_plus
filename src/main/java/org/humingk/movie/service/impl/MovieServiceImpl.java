package org.humingk.movie.service.impl;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.entity.Releasetime;
import org.humingk.movie.entity.Tag;
import org.humingk.movie.entity.Type;
import org.humingk.movie.mapper.*;
import org.humingk.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humingk
 */
@Transactional
@Service
public class MovieServiceImpl implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ReleasetimeMapper releasetimeMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private MovieDirectorMapper movieDirectorMapper;
    @Autowired
    private MovieWriterMapper movieWriterMapper;
    @Autowired
    private MovieLeadingactorMapper movieLeadingactorMapper;
    @Autowired
    private MovieTypeMapper movieTypeMapper;
    @Autowired
    private MovieTagMapper movieTagMapper;
    @Autowired
    private MovieReleasetimeMapper movieReleasetimeMapper;

    /**
     * 根据电影Id找出电影的详细资料
     *
     * @param movieId
     * @return
     */
    @Override
    public MovieAll getMovieAllByMovieId(int movieId) {

        try {
            // 提取电影信息
            MovieAll movieAll = new MovieAll(movieMapper.selectMovieBaseById(movieId));
            movieAll.setDirectors(actorMapper.selectDirectorsOfMovieById(movieId));
            movieAll.setWriters(actorMapper.selectWritersOfMovieById(movieId));
            movieAll.setLeadingactors(actorMapper.selectLeadingactorsOfMovieById(movieId));
            movieAll.setTypes(typeMapper.selectTypesOfMovieById(movieId));
            movieAll.setTags(tagMapper.selectTagsOfMovieById(movieId));
            movieAll.setReleasetimes(releasetimeMapper.selectReleasetimesOfMovieById(movieId));
            return movieAll;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }


    /**
     * 根据电影名称找出所有电影的所有详细资料
     *
     * @param s
     * @param start
     * @param count
     * @return
     */
    @Override
    public List<MovieAll> getMovieAllsOfMovieByAlias(String s, int start, int count) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByAlias(s, start, count);
            if (movies != null) {
                List<MovieAll> movieAlls = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie != null) {
                        Integer movieId = movie.getMovieId();
                        MovieAll movieAll = new MovieAll(movieMapper.selectMovieBaseById(movieId));
                        movieAll.setDirectors(actorMapper.selectDirectorsOfMovieById(movieId));
                        movieAll.setWriters(actorMapper.selectWritersOfMovieById(movieId));
                        movieAll.setLeadingactors(actorMapper.selectLeadingactorsOfMovieById(movieId));
                        movieAll.setTypes(typeMapper.selectTypesOfMovieById(movieId));
                        movieAll.setTags(tagMapper.selectTagsOfMovieById(movieId));
                        movieAll.setReleasetimes(releasetimeMapper.selectReleasetimesOfMovieById(movieId));
                        movieAlls.add(movieAll);
                    }
                }
                return movieAlls;
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    /**
     * 根据电影名称开头的字符串找出所有电影的基本资料
     *
     * @param s
     * @return
     */
    @Override
    public List<Movie> getMoviesByNameStart(String s) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByNameStart(s);

            if (movies == null) {
                logger.error("movies为空,没有此电影...");
                return null;
            }
            return movies;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    /**
     * 更新电影评分
     *
     * @param movieId
     * @param rate
     */
    @Override
    public boolean updateRateByMovieId(int movieId, float rate) {
        try {
            movieMapper.updateRateByPrimaryKey(movieId, rate);
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }

    /**
     * 更新imdbId
     *
     * @param movieId
     * @param imdbId
     * @return
     */
    @Override
    public boolean updateImdbIdByMovieId(int movieId, String imdbId) {
        try {
            movieMapper.updateImdbIdByPrimaryKey(movieId, imdbId);
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }


    /**
     * 向数据库添加movieAll
     *
     * @param movieAll
     * @return
     */
    @Override
    public Boolean addMovieAll(MovieAll movieAll) {
        try {
            movieMapper.updateMovieBaseByMovieAll(movieAll.getMovieId(), movieAll.getName(),
                    movieAll.getRate(), movieAll.getImdbId(), movieAll.getAlias());
            for (int i = 0; i < movieAll.getDirectors().size(); i++) {
                // 有的演员豆瓣没有收录，没有actor_id
                if (movieAll.getDirectors().get(i).getActorId() != null) {
                    actorMapper.updateActorsByMovieAll(movieAll.getDirectors().get(i).getActorId(), movieAll.getDirectors().get(i).getName());
                    movieDirectorMapper.updateMovieDirectorByMovieAll(movieAll.getMovieId(), movieAll.getDirectors().get(i).getActorId());
                }
            }
            for (int i = 0; i < movieAll.getWriters().size(); i++) {
                if (movieAll.getWriters().get(i).getActorId() != null) {
                    actorMapper.updateActorsByMovieAll(movieAll.getWriters().get(i).getActorId(), movieAll.getWriters().get(i).getName());
                    movieWriterMapper.updateMovieWriterByMovieAll(movieAll.getMovieId(), movieAll.getWriters().get(i).getActorId());
                }
            }
            for (int i = 0; i < movieAll.getLeadingactors().size(); i++) {
                if (movieAll.getLeadingactors().get(i).getActorId() != null) {
                    actorMapper.updateActorsByMovieAll(movieAll.getLeadingactors().get(i).getActorId(), movieAll.getLeadingactors().get(i).getName());
                    movieLeadingactorMapper.updateMovieLeadingactorByMovieAll(movieAll.getMovieId(), movieAll.getLeadingactors().get(i).getActorId());
                }
            }
            // tag type releasetime 主键都是自增ID，故需要返回插入数据或已有数据的自增ID
            for (int i = 0; i < movieAll.getTags().size(); i++) {
                Tag tag = tagMapper.selectByTagName(movieAll.getTags().get(i).getTagName());
                // 如果查无此tagName，进行插入操作再更新关联表
                if (tag == null) {
                    // insert语句，加上useGenerateKeys等属性，返回当前插入的id
                    int tagId = tagMapper.updateTagsByMovieAll(movieAll.getTags().get(i));
                    movieTagMapper.updateMovieTagByMovieAll(tagId, movieAll.getMovieId());
                }
                // 若有此tagName，只进行关联表
                else {
                    movieTagMapper.updateMovieTagByMovieAll(tag.getTagId(), movieAll.getMovieId());
                }
            }
            for (int i = 0; i < movieAll.getTypes().size(); i++) {
                Type type = typeMapper.selectTypesByTypeName(movieAll.getTypes().get(i).getTypeName());
                if (type != null) {
                    movieTypeMapper.updateMovieTypeByMovieAll(type.getTypeId(), movieAll.getMovieId());
                }
            }
            for (int i = 0; i < movieAll.getReleasetimes().size(); i++) {
                Releasetime releasetime = releasetimeMapper.selectByreleasetimeTimeArea(movieAll.getReleasetimes().get(i).getTimeArea());
                if (releasetime == null) {
                    int releasetimeId = releasetimeMapper.updateReleasetimesByMovieAll(movieAll.getReleasetimes().get(i));
                    movieReleasetimeMapper.updateMovieReleasetimeByMovieAll(movieAll.getMovieId(), releasetimeId);
                } else {
                    movieReleasetimeMapper.updateMovieReleasetimeByMovieAll(movieAll.getMovieId(), releasetime.getReleasetimeId());
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("", e);
        }
        return false;
    }
}