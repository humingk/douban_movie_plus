package org.humingk.movie.common.enumeration;

import lombok.AllArgsConstructor;

/**
 * 返回结果的状态码和信息
 *
 * @author humingk
 */
@AllArgsConstructor
public enum StatusAndMessage {
    /**
     * status < 1000 :常见已知错误信息
     */
    SUCCESS(200, "success"),
    BADREQUEST(400, "客户端错误"),
    UNAUTHORIZED(401, "认证失败"),
    FORBIDDEN(403, "服务器拒绝提供服务"),
    NOTFOUND(404, "找不到此资源"),
    ERROR(500, "服务器内部处理错误"),
    /**
     * status > 1000 :自定义错误信息
     */
    PARAMTER(1001, "请求参数错误"),
    NOUSER(1101, "无此用户");

    /**
     * 状态码
     */
    public final int status;
    /**
     * 状态信息
     */
    public final String message;

}
