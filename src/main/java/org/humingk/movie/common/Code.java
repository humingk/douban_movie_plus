package org.humingk.movie.common;

/**
 * 返回结果状态码
 *
 * @author humingk
 */
public class Code {
    /**
     * 请求成功
     */
    public final static int SUCCESS = 200;

    /**
     * 警告
     */
    public final static int WARN = 201;

    /**
     * 客户端错误
     */
    public final static int BADREQUEST = 400;

    /**
     * 未认证
     */
    public final static int UNAUtHORIZED = 401;


    /**
     * 服务器拒绝提供服务
     */
    public final static int FORBIDDEN = 403;

    /**
     * 请求失败
     */
    public final static int NOTFOUND = 404;

    /**
     * 服务器处理失败
     */
    public final static int ERROR = 500;
}
