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

  public Result(CodeAndMsg codeAndMsg) {
    this.code = codeAndMsg.code;
    this.msg = codeAndMsg.msg;
    this.data = null;
  }

  public Result(CodeAndMsg codeAndMsg, T data) {
    this.code = codeAndMsg.code;
    this.msg = codeAndMsg.msg;
    this.data = data;
  }

  // 成功 -------------------------------------------------------------------------

  /**
   * 执行成功,无具体数据（可用于插入、更新等操作）
   *
   * <p>PS:静态方法不能访问类上定义的泛型T，可以定义在方法上
   *
   * @return
   */
  public static Result success() {
    return new Result(SUCCESS);
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
  public static Result error() {
    return new Result(ERROR);
  }

  // 一、Controller层拦截抛出异常专用，包括手动抛出，被动抛出 --------------

  // 1. 抛出已知异常 -------

  /**
   * 业务错误，已知错误类型，且错误由MyException封装抛出，是否返回更多的信息由MyException决定
   *
   * @param e
   * @return
   */
  public static Result error(MyException e) {
    return new Result(e.getStatus(), e.getMessage(), e.getData());
  }

  // 2. 抛出未知异常 -------

  /**
   * 业务错误，未知错误类型，未被封装抛出，返回更多自定义错误信息
   *
   * @param e
   * @return
   */
  public static Result error(Exception e, Object data) {
    return new Result(ERROR.code, e.getMessage(), data);
  }

  /**
   * 业务错误，未知错误类型，未被封装抛出，不返回具体错误堆栈信息
   *
   * @param e
   * @return
   */
  public static Result error(Exception e) {
    return new Result(ERROR.code, e.getMessage(), "");
  }

  // 二、Controller层直接判断返回错误专用，仅包括已知错误

  /**
   * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，不返回任何细节
   *
   * @param codeAndMsg
   * @return
   */
  public static Result error(CodeAndMsg codeAndMsg) {
    return new Result(codeAndMsg);
  }

  /**
   * 业务错误,已知错误类型，且错误类型已加入StateAndMessage，返回更多的自定义错误信息
   *
   * @param codeAndMsg
   * @return
   */
  public static Result error(CodeAndMsg codeAndMsg, Object data) {
    return new Result(codeAndMsg, data);
  }

  /**
   * 业务错误,已知错误类型，且错误类型已加入StateAndMessage,返回简略的错误堆栈信息
   *
   * @param codeAndMsg
   * @return
   */
  public static Result error(CodeAndMsg codeAndMsg, Exception e) {
    return new Result(codeAndMsg, e.getMessage());
  }

  /**
   * 业务错误,已知错误类型,但错误类型未加入StateAndMessage,返回更多自定义错误信息
   *
   * @param data
   * @return
   */
  public static Result error(Object data) {
    return new Result(ERROR.code, ERROR.msg, data);
  }
}
