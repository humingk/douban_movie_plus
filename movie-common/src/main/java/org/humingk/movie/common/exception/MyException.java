package org.humingk.movie.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.humingk.movie.common.enumeration.CodeAndMsg;

import static org.humingk.movie.common.enumeration.CodeAndMsg.ERROR;

/**
 * 自定义异常类
 *
 * <p>封装StatusAndMessage或其他异常，抛出并在Controller层被拦截
 *
 * @author humingk
 */
@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MyException extends RuntimeException {
  /** 异常状态码 */
  protected int code;
  /** 异常信息 */
  protected String msg;

  /** 500，服务器内部错误 */
  public MyException() {
    this.code = ERROR.code;
    this.msg = ERROR.msg;
  }

  /**
   * 500，服务器内部错误
   *
   * @param msg 自定义异常信息
   */
  public MyException(String msg) {
    this.code = ERROR.code;
    this.msg = msg;
  }

  /**
   * 业务错误
   *
   * @param codeAndMsg 已知错误类型
   * @return
   */
  public MyException(CodeAndMsg codeAndMsg) {
    this.code = codeAndMsg.code;
    this.msg = codeAndMsg.msg;
  }
  /**
   * 业务错误
   *
   * @param codeAndMsg 已知错误类型
   * @param msg 自定义异常信息
   * @return
   */
  public MyException(CodeAndMsg codeAndMsg, String msg) {
    this.code = codeAndMsg.code;
    this.msg = msg;
  }
}
