//package org.humingk.movie.api.movie.hystric;
//
//import org.humingk.movie.api.movie.SearchApi;
//import org.humingk.movie.common.entity.Result;
//import org.springframework.stereotype.Component;
//
///**
// * SearchApi熔断处理
// *
// * @author humingk
// */
//@Component
//public class SearchApiHystric implements SearchApi {
//    /**
//     * 豆瓣电影搜索提示
//     * <p>
//     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
//     *
//     * @param keyword 搜索关键字
//     * @param offset  偏移量（可选，默认0）
//     * @param limit   限制数（可选，默认10）
//     * @return
//     */
//    @Override
//    public Result searchMovieTips(String keyword, int offset, int limit) {
//        return Result.error("Hystric");
//    }
//
//    /**
//     * 豆瓣电影搜索结果
//     * <p>
//     * 根据电影名称字符串找出豆瓣电影的基本信息列表
//     *
//     * @param keyword 搜索关键字
//     * @param offset  偏移量（可选，默认0）
//     * @param limit   限制数（可选，默认10）
//     * @return
//     */
//    @Override
//    public Result searchMovieResult(String keyword, int offset, int limit) {
//        return null;
//    }
//
//    /**
//     * 豆瓣影人搜索结果
//     * <p>
//     * 根据影人名称字符串找出豆瓣影人的基本信息列表
//     *
//     * @param keyword 搜索关键字
//     * @param offset  偏移量（可选，默认0）
//     * @param limit   限制数（可选，默认10）
//     * @return
//     */
//    @Override
//    public Result searchCelebrityResult(String keyword, int offset, int limit) {
//        return null;
//    }
//}
