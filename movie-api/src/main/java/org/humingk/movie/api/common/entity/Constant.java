package org.humingk.movie.api.common.entity;

import com.google.common.collect.ImmutableMap;

/**
 * 常量类
 *
 * @author humingk
 */
public class Constant {
  /** 影片类型 */
  public static final ImmutableMap<Byte, String> VIDEO_TYPE =
      ImmutableMap.<Byte, String>builder()
          .put((byte) 1, "未知")
          .put((byte) 2, "电影")
          .put((byte) 3, "电视剧")
          .put((byte) 4, "短片")
          .put((byte) 5, "迷你电视剧")
          .put((byte) 6, "电视短片")
          .put((byte) 7, "电视特辑")
          .put((byte) 8, "电视电影")
          .put((byte) 9, "视频")
          .put((byte) 10, "视频游戏")
          .build();

  /** 电影类型 */
  public static final ImmutableMap<Short, String> MOVIE_TYPE =
      ImmutableMap.<Short, String>builder()
          .put((short) 1, "未知")
          .put((short) 2, "剧情")
          .put((short) 3, "喜剧")
          .put((short) 4, "爱情")
          .put((short) 5, "动作")
          .put((short) 6, "惊悚")
          .put((short) 7, "动画")
          .put((short) 8, "犯罪")
          .put((short) 9, "纪录片")
          .put((short) 10, "短片")
          .put((short) 11, "恐怖")
          .put((short) 12, "悬疑")
          .put((short) 13, "科幻")
          .put((short) 14, "冒险")
          .put((short) 15, "奇幻")
          .put((short) 16, "家庭")
          .put((short) 17, "战争")
          .put((short) 18, "历史")
          .put((short) 19, "传记")
          .put((short) 20, "音乐")
          .put((short) 21, "同性")
          .put((short) 22, "古装")
          .put((short) 23, "歌舞")
          .put((short) 24, "运动")
          .put((short) 25, "情色")
          .put((short) 26, "儿童")
          .put((short) 27, "武侠")
          .put((short) 28, "西部")
          .put((short) 29, "真人秀")
          .put((short) 30, "黑色电影")
          .put((short) 31, "灾难")
          .put((short) 32, "脱口秀")
          .put((short) 33, "舞台艺术")
          .put((short) 34, "戏曲")
          .put((short) 35, "鬼怪")
          .build();
}
