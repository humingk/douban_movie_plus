package org.humingk.movie.common;

import lombok.AllArgsConstructor;

/**
 * 返回结果的状态码和信息
 * <p>
 * status > 1000 :自定义的错误信息
 *
 * @author humingk
 */
@AllArgsConstructor
public enum StatusAndMessage {
    /**
     * 请求成功
     */
    SUCCESS(200, "success"),
    /**
     * 客户端错误
     */
    BADREQUEST(400, "客户端错误"),
    /**
     * 未认证,无权限
     */
    UNAUTHORIZED(401, "认证失败"),
    /**
     * 服务器拒绝提供服务
     */
    FORBIDDEN(403, "服务器拒绝提供服务"),
    /**
     * 请求资源失败,不存在
     */
    NOTFOUND(404, "找不到此资源"),
    /**
     * 服务器处理失败,内部错误
     */
    ERROR(500, "服务器内部处理错误"),
    /**
     * 请求参数错误
     */
    PARAMTER(1001, "请求参数错误"),
    /**
     * 没有用户
     */
    NOUSER(1101, "无此用户"),
    /**
     * 例子
     */
    EXAMPLE(0, "example");

    private final int status;
    private final String message;

    public int status() {
        return status;
    }

    public string message() {
        return message;
    }


}
