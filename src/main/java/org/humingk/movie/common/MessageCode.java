package org.humingk.movie.common;

/**
 * @author humingk
 */
public class MessageCode {

    /**
     * 请求成功
     */
    public static int SUCCESS = 200;

    /**
     * 警告
     */
    public static int WARN = 201;

    /**
     * 客户端错误
     */
    public static int BADREQUEST = 400;

    /**
     * 未认证
     */
    public static int UNAUtHORIZED = 401;


    /**
     * 服务器拒绝提供服务
     */
    public static int FORBIDDEN = 403;

    /**
     * 请求失败
     */
    public static int NOTFOUND = 404;

    /**
     * 服务器处理失败
     */
    public static int ERROR = 500;


}
