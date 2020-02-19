package org.humingk.movie.common.entity;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;

/**
 * 电影相关常量类
 *
 * @author humingk
 */
public class MovieConstant {
  /** 影片类型 */
  public static final ListMultimap<Byte, String> VIDEO_TYPE = ArrayListMultimap.create();

  static {
    VIDEO_TYPE.put((byte) 1, "未知");
    VIDEO_TYPE.put((byte) 1, "unknown");
    VIDEO_TYPE.put((byte) 2, "电影");
    VIDEO_TYPE.put((byte) 2, "movie");
    VIDEO_TYPE.put((byte) 3, "电视剧");
    VIDEO_TYPE.put((byte) 3, "tv series");
    VIDEO_TYPE.put((byte) 4, "短片");
    VIDEO_TYPE.put((byte) 4, "short");
    VIDEO_TYPE.put((byte) 5, "迷你电视剧");
    VIDEO_TYPE.put((byte) 5, "tv mini series");
    VIDEO_TYPE.put((byte) 6, "电视短片");
    VIDEO_TYPE.put((byte) 6, "tv short");
    VIDEO_TYPE.put((byte) 7, "电视特辑");
    VIDEO_TYPE.put((byte) 7, "tv special");
    VIDEO_TYPE.put((byte) 8, "电视电影");
    VIDEO_TYPE.put((byte) 8, "tvMovie");
    VIDEO_TYPE.put((byte) 9, "视频");
    VIDEO_TYPE.put((byte) 9, "video");
    VIDEO_TYPE.put((byte) 10, "视频游戏");
    VIDEO_TYPE.put((byte) 10, "video game");
  }

  /** 影人职业类型 */
  public static final ListMultimap<Byte, String> PROFESSION_TYPE = ArrayListMultimap.create();

  static {
    PROFESSION_TYPE.put((byte) 1, "未知");
    PROFESSION_TYPE.put((byte) 1, "unknown");
    PROFESSION_TYPE.put((byte) 2, "导演");
    PROFESSION_TYPE.put((byte) 2, "director");
    PROFESSION_TYPE.put((byte) 3, "编剧");
    PROFESSION_TYPE.put((byte) 3, "writer");
    PROFESSION_TYPE.put((byte) 4, "演员");
    PROFESSION_TYPE.put((byte) 4, "starring");
    PROFESSION_TYPE.put((byte) 5, "男演员");
    PROFESSION_TYPE.put((byte) 5, "actor");
    PROFESSION_TYPE.put((byte) 6, "女演员");
    PROFESSION_TYPE.put((byte) 6, "actress");
    PROFESSION_TYPE.put((byte) 7, "存档胶片");
    PROFESSION_TYPE.put((byte) 7, "archive_footage");
    PROFESSION_TYPE.put((byte) 8, "存档声音");
    PROFESSION_TYPE.put((byte) 8, "archive_sound");
    PROFESSION_TYPE.put((byte) 9, "摄影师");
    PROFESSION_TYPE.put((byte) 9, "cinematographer");
    PROFESSION_TYPE.put((byte) 10, "作曲家");
    PROFESSION_TYPE.put((byte) 10, "composer");
    PROFESSION_TYPE.put((byte) 11, "编辑");
    PROFESSION_TYPE.put((byte) 11, "editor");
    PROFESSION_TYPE.put((byte) 12, "制片人");
    PROFESSION_TYPE.put((byte) 12, "producer");
    PROFESSION_TYPE.put((byte) 13, "美工");
    PROFESSION_TYPE.put((byte) 13, "production_designer");
    PROFESSION_TYPE.put((byte) 14, "自己?");
    PROFESSION_TYPE.put((byte) 14, "self");
  }

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

  /** 场景地点类型 */
  public static final ImmutableMap<Byte, String> PLACE_TYPE =
      ImmutableMap.<Byte, String>builder()
          .put((byte) 100, "未知")
          .put((byte) 0, "旅游景点")
          .put((byte) 1, "历史建筑")
          .put((byte) 2, "餐饮")
          .put((byte) 3, "商铺")
          .put((byte) 4, "自然风光")
          .put((byte) 5, "民居")
          .put((byte) 6, "酒店")
          .put((byte) 7, "地标")
          .put((byte) 8, "宗教场所")
          .put((byte) 9, "街道")
          .put((byte) 10, "影视基地")
          .put((byte) 11, "公园")
          .put((byte) 12, "演艺场所")
          .put((byte) 13, "展馆")
          .put((byte) 14, "交通站")
          .put((byte) 15, "商用建筑")
          .put((byte) 16, "广场")
          .put((byte) 17, "政府机关")
          .put((byte) 18, "医疗机构")
          .put((byte) 19, "")
          .put((byte) 20, "工厂")
          .put((byte) 21, "体育场馆")
          .put((byte) 22, "金融机构")
          .put((byte) 23, "港口")
          .put((byte) 24, "社会福利机构")
          .put((byte) 25, "墓地")
          .put((byte) 26, "学校")
          .build();

  /** 资源网站类型 */
  public static final ListMultimap<Short, String> WEBSITE_RESOURCE = ArrayListMultimap.create();

  static {
    WEBSITE_RESOURCE.put((short) (short) 2, "爱奇艺视频");
    WEBSITE_RESOURCE.put((short) (short) 2, "https://www.iqiyi.com");
    WEBSITE_RESOURCE.put((short) 3, "腾讯视频");
    WEBSITE_RESOURCE.put((short) 3, "https://v.qq.com");
    WEBSITE_RESOURCE.put((short) 4, "哔哩哔哩");
    WEBSITE_RESOURCE.put((short) 4, "https://www.bilibili.com");
    WEBSITE_RESOURCE.put((short) 5, "搜狐视频");
    WEBSITE_RESOURCE.put((short) 5, "https://tv.sohu.com");
    WEBSITE_RESOURCE.put((short) 6, "优酷视频");
    WEBSITE_RESOURCE.put((short) 6, "https://www.youku.com");
    WEBSITE_RESOURCE.put((short) 7, "1905电影网");
    WEBSITE_RESOURCE.put((short) 7, "https://vip.1905.com");
    WEBSITE_RESOURCE.put((short) 8, "芒果TV");
    WEBSITE_RESOURCE.put((short) 8, "https://www.mgtv.com");
    // ---
    WEBSITE_RESOURCE.put((short) 101, "电影天堂");
    WEBSITE_RESOURCE.put((short) 101, "https://www.dy2018.com");
    WEBSITE_RESOURCE.put((short) 102, "LOL电影天堂");
    WEBSITE_RESOURCE.put((short) 102, "https://www.loldytt.tv");
    WEBSITE_RESOURCE.put((short) 103, "BT电影天堂");
    WEBSITE_RESOURCE.put((short) 103, "http://www.btbtdy.me");
    WEBSITE_RESOURCE.put((short) 104, "xl720");
    WEBSITE_RESOURCE.put((short) 104, "https://www.xl720.com");
    WEBSITE_RESOURCE.put((short) 105, "6v电影网");
    WEBSITE_RESOURCE.put((short) 105, "http://www.hao6v.com");
    WEBSITE_RESOURCE.put((short) 106, "狗带TV");
    WEBSITE_RESOURCE.put((short) 106, "http://www.goodaitv.com");
    WEBSITE_RESOURCE.put((short) 107, "在线之家");
    WEBSITE_RESOURCE.put((short) 107, "http://www.zxzjs.com");
    WEBSITE_RESOURCE.put((short) 108, "比热大雄");
    WEBSITE_RESOURCE.put((short) 108, "https://www.btdx8.com");
  }

  /** 电影资源类型 */
  public static final ImmutableMap<Short, String> RESOURCE_TYPE =
      ImmutableMap.<Short, String>builder()
          .put((short) 2, "免费观看")
          .put((short) 3, "VIP免费观看")
          .put((short) 4, "单片付费")
          .put((short) 5, "用劵/单片付费")
          // ---
          .put((short) 100, "未知")
          .put((short) 101, "在线观看")
          .put((short) 102, "网盘")
          .put((short) 111, "BluRay")
          .put((short) 112, "1080p")
          .put((short) 113, "1280超清")
          .put((short) 114, "1024超清")
          .put((short) 115, "720p")
          .put((short) 116, "1280高清")
          .put((short) 117, "1024高清")
          .build();
}
