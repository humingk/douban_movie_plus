package org.humingk.movie.api.common.entity;

import com.google.common.collect.ImmutableMap;

/**
 * 常量类
 *
 * @author humingk
 */
public class Constant {
    /**
     * 影片类型
     */
    public static final ImmutableMap<Byte, String> VIDEO_TYPE = ImmutableMap.<Byte, String>builder()
            .put((byte) 1, "未知")
            .put((byte) 2, "电影")
            .put((byte) 3, "电视剧")
            .put((byte) 4, "短片")
            .put((byte) 5, "迷你电视剧")
            .put((byte) 6, "电视短片")
            .put((byte) 7, "电视特辑")
            .put((byte) 8, "电视电影")
            .put((byte) 9, "视频")
            .put((byte) 10, "视频游戏").build();
}
