package org.humingk.movie.service;

import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;

import java.util.List;

public interface ResourceService {
    /**
     * 通过关键字获取电影资源---电影搜索结果
     *
     * @param keyword        搜索关键字
     * @param dateType       电影上映时间类型
     *                       0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                       1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                       2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param movieSearchMax 电影搜索最大数
     * @param threadMax      线程最大数
     * @return
     */
    List<Search> getResourceSearch(
            String keyword, int dateType, int movieSearchMax, int threadMax);

    /**
     * 通过关键字获取电影资源---电影资源
     *
     * @param keyword   搜索关键字
     * @param dateType  电影上映时间类型
     *                  0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                  1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                  2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param threadMax 线程最大数
     * @return
     */
    List<Resource> getResourceAll(
            String keyword, int dateType, int threadMax);
}
