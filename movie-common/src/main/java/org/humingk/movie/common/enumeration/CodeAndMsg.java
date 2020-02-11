package org.humingk.movie.common.enumeration;

import lombok.AllArgsConstructor;

/**
 * 返回结果的状态码和信息
 *
 * @author humingk
 */
@AllArgsConstructor
public enum CodeAndMsg {
    /**
     * status < 1000 :常见已知错误信息
     */
    SUCCESS(200, "成功"),
    BADREQUEST(400, "客户端错误"),
    UNAUTHORIZED(401, "认证失败"),
    FORBIDDEN(403, "服务器拒绝提供服务"),
    NOTFOUND(404, "找不到此资源"),
    ERROR(500, "服务器内部处理错误"),
    /**
     * status > 1000 :自定义错误信息
     */
    PARAMTER(1001, "请求参数错误"),
    NOUSER(1002, "无此用户"),
    NOROLE(1003, "此用户无权限"),
    EMAIL_EXIST(1004, "此邮箱已被注册"),
    USER_ID_EXIST(1004, "此豆瓣ID已被注册");

    /**
     * 状态码
     */
    public final int code;
    /**
     * 状态信息
     */
    public final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
