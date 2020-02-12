package org.humingk.movie.api.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 豆瓣电影详细信息
 *
 * @author humingk
 */
@Data
public class MovieDoubanDetailsVo {
    /**
     * 豆瓣电影基础信息
     */
    private MovieDoubanVo movieDoubanVo;

    /**
     * 豆瓣电影别名列表
     */
    List<String> aliasList;

    // more...

}
