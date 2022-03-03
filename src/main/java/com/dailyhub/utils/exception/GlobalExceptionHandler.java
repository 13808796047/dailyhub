package com.dailyhub.utils.exception;

import cn.hutool.json.JSONUtil;
import com.dailyhub.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof IllegalArgumentException || ex instanceof IllegalStateException) {
            log.error(ex.getMessage());
        } else {
            log.error(ex.getMessage(), ex);
        }
        // 处理ajax请求
        String requestType = request.getHeader("x-Requested-With");
        if ("XMLHttpRequest".equals(requestType)) {
            response.setContentType("application/json;charset=UTF8");
            try {
                response.getWriter().print(JSONUtil.toJsonStr(Response.failure(500, ex.getMessage(), null)));
            } catch (IOException e) {

            }
        } else {
            request.setAttribute("message", "系统异常，请稍后再试！");
        }
        return new ModelAndView("error");
    }
}
