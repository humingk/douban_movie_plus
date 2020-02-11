package org.humingk.movie.common.entity;

import com.google.common.collect.ImmutableMultimap;

/**
 * 常量类
 *
 * @author humingk
 */
public class Constant {
    /**
     * 影片类型
     */
    public static final ImmutableMultimap<Integer, String> VIDEO_TYPE = ImmutableMultimap.<Integer, String>builder()
            .put(1, "未知")
            .put(2, "电影")
            .put(3, "电视剧")
            .put(4, "短片")
            .put(5, "迷你电视剧")
            .put(6, "电视短片")
            .put(7, "电视特辑")
            .put(8, "电视电影")
            .put(9, "视频")
            .put(10, "视频游戏").build();
}
