package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 场景地点
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSceneVo implements Serializable {
  /** 场景地点ID */
  private Long id;

  /** 经度 */
  private BigDecimal longitude;

  /** 纬度 */
  private BigDecimal latitude;

  /** 中文名 */
  private String nameZh;

  /** 英文名 */
  private String nameEn;

  /** 其他语言名 */
  private String nameOther;

  /** 别名 */
  private String alias;

  /** 中文地址 */
  private String addressZh;

  /** 英文地址 */
  private String addressEn;

  /** 地点描述 */
  private String description;

  /** 区域中文 */
  private String areaZh;

  /** 区域英文 */
  private String areaEn;

  /** 电话号码 */
  private String phone;

  /** 地点海报图链接 */
  private String urlPoster;

  /** 地点地球位置图链接 */
  private String urlEarth;

  /** 地点卫星图链接 */
  private String urlSatellite;

  /** 地点地图 */
  private String urlMap;

  private static final long serialVersionUID = 1L;
}
