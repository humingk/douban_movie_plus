package org.humingk.movie.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.humingk.movie.exception.MyException;

import static org.humingk.movie.common.StatusAndMessage.*;

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
    private int status;
    /**
     * 其他信息
     */
    private Object message;
    /**
     * json数据
     */
    private Object data;

    public Result(StatusAndMessage statusAndMessage) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message;
        this.data = "";
    }

    public Result(StatusAndMessage statusAndMessage, Object data) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message;
        this.data = data;
    }

    /**
     * 执行成功,未返回结果
     *
     * @return
     */
    public static Result success() {
        return new Result(SUCCESS);
    }

    /**
     * 执行成功,返回结果
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return new Result(SUCCESS, data);
    }

    /**
     * 未找到相应资源
     *
     * @return
     */
    public static Result notFound() {
        return new Result(NOTFOUND);
    }

    /**
     * 未找到相应资源
     *
     * @param e
     * @return
     */
    public static Result notFound(Exception e) {
        return new Result(NOTFOUND.status, e, "");
    }


    /**
     * 业务错误,默认错误类型
     *
     * @return
     */
    public static Result error() {
        return new Result(ERROR);
    }

    /**
     * 业务错误,自定义错误
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        return new Result(ERROR.status, message, "");
    }


    /**
     * 业务错误,其他错误类型
     *
     * @param statusAndMessage
     * @return
     */
    public static Result error(StatusAndMessage statusAndMessage) {
        return new Result(statusAndMessage);
    }

    /**
     * 业务错误,其他错误类型,包括其他错误信息
     *
     * @param statusAndMessage
     * @return
     */
    public static Result error(StatusAndMessage statusAndMessage, String message) {
        return new Result(statusAndMessage.status, statusAndMessage.message + " : " + message, "");
    }


    /**
     * 业务错误,已知错误类型
     *
     * @param e
     * @return
     */
    public static Result error(MyException e) {
        return new Result(e.getStatus(), e.getMessage(), "");
    }
}
