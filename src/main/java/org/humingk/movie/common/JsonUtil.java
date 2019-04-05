package org.humingk.movie.common;


import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtil {

    private static Gson gson = new Gson();

    /**
     * 将对象转为JSON串
     * @param src :将要被转化的对象
     * @return :转化后的JSON串
     */
    public static String toJson(Object src) {
        if (src == null) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }

    /**
     * 将json串转换为对象
     * @param src 将要转换的json串
     * @param cls 对象的类型
     * @param <T>
     * @return  转换后的对象
     */
    public static <T> T toBean(String src,Class<T> cls){
        if(src == null){
            return null;
        }
        return gson.fromJson(src,cls);
    }
}


