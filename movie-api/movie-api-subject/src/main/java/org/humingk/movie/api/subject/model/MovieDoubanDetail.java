package org.humingk.movie.api.subject.model;

import org.humingk.common.entity.*;

import java.util.List;

/**
 * 豆瓣电影详细信息
 *
 * @author humingk
 */
public class MovieDoubanDetail {
    /**
     * 基础信息
     */
    private MovieDouban movieDouban;
    /**
     * 豆瓣评分
     */
    private RateMovieDouban rateMovieDouban;
    /**
     * 影人信息列表
     */
    private List<CelebrityDouban> celebrityDoubanList;
    /**
     * 别称列表
     */
    private List<AliasMovieDouban> aliasMovieDoubanList;
    /**
     * 标签列表
     */
    private List<TagMovie> tagMovieList;
    /**
     * 类型列表
     */
    private List<TypeMovie> typeMovieList;
    /**
     * 预告片列表
     */
    private List<TrailerMovieDouban> trailerMovieDoubanList;
    /**
     * 图片列表
     */
    private List<ImageMovieDouban> imageMovieDoubanList;
}
