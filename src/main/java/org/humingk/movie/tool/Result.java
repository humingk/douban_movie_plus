package org.humingk.movie.tool;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回结果封装类
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 其他信息
     */
    private String msg;
    /**
     * json数据
     */
    private Object data;
}
