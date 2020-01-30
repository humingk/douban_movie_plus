package org.humingk.movie.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.humingk.movie.common.enumeration.StatusAndMessage;
import org.humingk.movie.common.exception.MyException;

import java.io.Serializable;

import static org.humingk.movie.common.enumeration.StatusAndMessage.ERROR;
import static org.humingk.movie.common.enumeration.StatusAndMessage.SUCCESS;

/**
 * 返回结果封装类
 *
 * @author humingk
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private int status;
    /**
     * 其他信息
     */
    private String message;
    /**
     * Json格式数据，复杂嵌套对象,Json字符串
     */
    private T data;

    public Result(StatusAndMessage statusAndMessage) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message;
        this.data = null;
    }

    public Result(StatusAndMessage statusAndMessage, T data) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message;
        this.data = data;
    }

    // 成功 -------------------------------------------------------------------------

    /**
     * 执行成功,无具体数据（可用于插入、更新等操作）
     * <p>
     * PS:静态方法不能访问类上定义的泛型T，可以定义在方法上
     *
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<>(SUCCESS);
    }

    /**
     * 执行成功,返回具体数据
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, data);
    }

    // 失败 -------------------------------------------------------------------------

    /**
     * 执行失败,无具体数据（可用于插入、更新等操作）
     *
     * @return
     */
    public static <T> Result<T> error() {
        return new Result<>(ERROR);
    }

    // 一、Controller层拦截抛出异常专用，包括手动抛出，被动抛出 --------------

    // 1. 抛出已知异常 -------

    /**
     * 业务错误，已知错误类型，且错误由MyException封装抛出，是否返回更多的信息由MyException决定
     *
     * @param e
     * @return
     */
    public static <T> Result<T> error(MyException e) {
        return new Result<>(e.getStatus(), e.getMessage(), (T) e.getData());
    }

    // 2. 抛出未知异常 -------

    /**
     * 业务错误，未知错误类型，未被封装抛出，返回更多自定义错误信息
     *
     * @param e
     * @return
     */
    public static <T> Result<T> error(Exception e, T data) {
        return new Result<>(ERROR.status, e.getMessage(), data);
    }

    /**
     * 业务错误，未知错误类型，未被封装抛出，返回具体错误堆栈信息
     *
     * @param e
     * @return
     */
    public static <T> Result<T> error(Exception e) {
        return new Result<T>(ERROR.status, e.getMessage(), (T) e);
    }

    // 二、Controller层直接判断返回错误专用，仅包括已知错误

    /**
     * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，不返回任何细节
     *
     * @param statusAndMessage
     * @return
     */
    public static <T> Result<T> error(StatusAndMessage statusAndMessage) {
        return new Result<>(statusAndMessage);
    }

    /**
     * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，返回更多的自定义错误信息
     *
     * @param statusAndMessage
     * @return
     */
    public static <T> Result<T> error(StatusAndMessage statusAndMessage, T data) {
        return new Result<>(statusAndMessage, data);
    }

    /**
     * 业务错误,已知错误类型，且错误类型已加入StateAndMessage,返回具体的错误堆栈信息
     *
     * @param statusAndMessage
     * @return
     */
    public static <T> Result<T> error(StatusAndMessage statusAndMessage, Exception e) {
        return new Result<T>(statusAndMessage, (T) e);
    }

    /**
     * 业务错误,已知错误类型,但错误类型未加入StateAndMessage,返回更多自定义错误信息
     *
     * @param data
     * @return
     */
    public static <T> Result<T> error(T data) {
        return new Result<T>(ERROR.status, ERROR.message, data);
    }
}
