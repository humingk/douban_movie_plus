package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 场景详情剧照
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageSceneDetail implements Serializable {
    /**
     * 场景详情剧照ID
     */
    private Long id;

    /**
     * 场景详情ID
     */
    private Long idSceneDetail;

    /**
     * 图片链接
     */
    private String urlImage;

    private static final long serialVersionUID = 1L;
}