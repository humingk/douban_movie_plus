package org.humingk.movie.common.entity;

import com.alibaba.fastjson.JSONObject;
import org.humingk.movie.common.exception.MyException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * response封装类,效果等同于@Responsebody
 *
 * @author humingk
 */
public class ResultResponse {
    /**
     * 封装为自定义已知异常
     *
     * @param response
     * @param e
     * @return
     */
    public static void error(HttpServletResponse response, MyException e) throws IOException {
        response.setStatus(e.getStatus());
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        // 写入Json字符串
        response.getWriter().write(
                new JSONObject(
                        new HashMap() {{
                            put("status", e.getStatus());
                            put("message", e.getMessage());
                            put("data", "");
                        }}
                ).toString()
        );
    }
}
