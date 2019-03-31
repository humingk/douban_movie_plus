package org.humingk.movie.common;

/**
 * @author humin
 */
public class ResultMessage {
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
    public static String createMessage(int code, String message, Object data){
        ResultMessage resultMessage=new ResultMessage();
        resultMessage.setCode(code);
        resultMessage.setMessage(message);
        resultMessage.setData(data);
        return JsonUtil.toJson(resultMessage);
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
