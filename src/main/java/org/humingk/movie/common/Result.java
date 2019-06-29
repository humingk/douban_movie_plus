package org.humingk.movie.common;

/**
 * @author humingk
 */
public class Result {
    private int code;
    private String message;
    private Object data;


    /**
     * 创建成功返回信息
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static Result createMessage(int code, String message, Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
