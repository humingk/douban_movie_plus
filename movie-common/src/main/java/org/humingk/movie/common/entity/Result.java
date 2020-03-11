package org.humingk.movie.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;

import java.io.Serializable;

import static org.humingk.movie.common.enumeration.CodeAndMsg.ERROR;
import static org.humingk.movie.common.enumeration.CodeAndMsg.SUCCESS;

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
  /** 状态码 */
  private int code;
  /** 状态信息 */
  private String msg;
  /** 具体结果 */
  private T data;

  // 成功 -------------------------------------------------------------------------

  /**
   * 成功
   *
   * @return
   */
  public static Result<Object> success() {
    return new Result<>(SUCCESS.code, SUCCESS.msg, null);
  }

  /**
   * 成功
   *
   * @param data 具体数据
   * @return
   */
  public static <T> Result<T> success(T data) {
    return new Result<>(SUCCESS.code, SUCCESS.msg, data);
  }

  // 失败 -------------------------------------------------------------------------

  /**
   * 失败
   *
   * @return
   */
  public static Result<Object> error() {
    return new Result<>(ERROR.code, ERROR.msg, null);
  }

  /**
   * 失败
   *
   * @param msg 自定义错误信息
   * @return
   */
  public static Result<Object> error(String msg) {
    return new Result<>(ERROR.code, msg, null);
  }

  /**
   * 业务错误
   *
   * @param codeAndMsg 已知错误类型
   * @return
   */
  public static Result<Object> error(CodeAndMsg codeAndMsg) {
    return new Result<>(codeAndMsg.code, codeAndMsg.msg, null);
  }
  /**
   * 业务错误
   *
   * @param codeAndMsg 已知错误类型
   * @param msg 自定义错误信息
   * @return
   */
  public static Result<Object> error(CodeAndMsg codeAndMsg, String msg) {
    return new Result<>(codeAndMsg.code, msg, null);
  }

  /**
   * 业务错误
   *
   * @param e 已知错误类型
   * @return
   */
  public static Result<Object> error(MyException e) {
    return new Result<>(e.getCode(), e.getMsg(), null);
  }
}
