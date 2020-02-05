package org.humingk.movie.common.entity;

/**
 * Oauth2的几种模式
 *
 * @author humingk
 */
public class Oauth2Mode {
    /**
     * 授权码模式： 第三方应用先申请一个授权码，然后再用该码获取令牌
     * <p>
     * 请求参数:
     * <p>
     * - response_type      授权类型(默认：code)
     * - redirect_uri       重定向URL
     * - client_id          客户端ID
     * - scope              权限范围
     */
    public static final String CODE = "authorization_code";
    /**
     * 简化模式：省略授权码模式中的获取授权码过程
     * <p>
     * 请求参数：
     * <p>
     * - response_type      授权类型(默认：implicit)
     * - redirect_uri       重定向URL
     * - client_id          客户端ID
     * - scope              权限范围
     */
    public static final String IMPLICIT = "implicit";
    /**
     * 密码模式：根据用户名和密码获取授权
     * <p>
     * 请求参数：
     * <p>
     * - grant_type         授权类型(默认：password)
     * - username           用户名
     * - password           密码
     * - scope              权限范围
     */
    public static final String PASSWORD = "password";
    /**
     * 客户端模式: 针对第三方客户端应用的授权
     * <p>
     * 请求参数：
     * <p>
     * - grant_type         授权类型(默认：client_credentials)
     * - client_id          客户端ID
     * - client_secret      客户端密钥
     * - scope              权限范围
     */
    public static final String CLIENT = "client_credentials";
    /**
     * 刷新token: 登录时发送两个令牌，一个用于获取数据，另一个用于更新令牌
     * <p>
     * 请求参数包括：
     * - grant_type         使用的授权模式(默认：refresh_token)
     * - refresh_token      之前收到的更新令牌
     * - scope              权限范围
     */
    public static final String REFRESH = "refresh_token";
}
