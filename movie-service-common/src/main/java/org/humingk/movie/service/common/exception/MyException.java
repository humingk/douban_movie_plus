package org.humingk.movie.service.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.humingk.movie.service.common.common.StatusAndMessage;

import static org.humingk.movie.service.common.common.StatusAndMessage.ERROR;

/**
 * 自定义异常类
 * <p>
 * 匹配 StatusAndMessage
 *
 * @author humingk
 */
@Data
@ToString
@AllArgsConstructor
public class MyException extends RuntimeException {
    /**
     * 异常状态码
     */
    protected int status;
    /**
     * 异常信息
     */
    protected String message;


    /**
     * 默认错误类型
     */
    public MyException() {
        this.status = ERROR.status;
        this.message = ERROR.message;
    }

    /**
     * 默认错误类型,其他自定义报错信息
     *
     * @param message
     */
    public MyException(String message) {
        this.status = ERROR.status;
        this.message = message;
    }

    /**
     * 已知自定义类型
     *
     * @param statusAndMessage
     */
    public MyException(StatusAndMessage statusAndMessage) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message;
    }

    /**
     * 已知自定义类型,其他自定义信息
     *
     * @param statusAndMessage
     */
    public MyException(StatusAndMessage statusAndMessage, String message) {
        this.status = statusAndMessage.status;
        this.message = statusAndMessage.message + "," + message;
    }

}
