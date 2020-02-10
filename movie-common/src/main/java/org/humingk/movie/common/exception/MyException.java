package org.humingk.movie.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.humingk.movie.common.enumeration.CodeAndMsg;

import static org.humingk.movie.common.enumeration.CodeAndMsg.ERROR;

/**
 * 自定义异常类
 * <p>
 * 封装StatusAndMessage或其他异常，抛出并在Controller层被拦截
 *
 * @author humingk
 */
@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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
     * 更多异常信息（包括自定义异常信息、错误堆栈信息）
     */
    protected Object data;

    /**
     * 500，服务器内部错误,不包括任何详细错误信息
     */
    public MyException() {
        this.status = ERROR.code;
        this.message = ERROR.msg;
        this.data = null;
    }

    /**
     * 500，服务器内部错误,包括更多自定义错误信息
     *
     * @param data
     */
    public MyException(Object data) {
        this.status = ERROR.code;
        this.message = ERROR.msg;
        this.data = data;
    }

    /**
     * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，不包括任何错误细节
     *
     * @param codeAndMsg
     */
    public MyException(CodeAndMsg codeAndMsg) {
        this.status = codeAndMsg.code;
        this.message = codeAndMsg.msg;
        this.data = null;
    }

    /**
     * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，包括更多错误信息（自定义信息，甚至错误堆栈信息）
     *
     * @param codeAndMsg
     * @return
     */
    public MyException(CodeAndMsg codeAndMsg, Object data) {
        this.status = codeAndMsg.code;
        this.message = codeAndMsg.msg;
        this.data = data;
    }
}
