package org.humingk.movie.common;

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

    public Result(Object data) {
        this.code = Code.SUCCESS;
        this.msg = Message.SUCCESS;
        this.data = data;
    }
}
