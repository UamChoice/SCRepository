package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Order(2)
@Slf4j
public class WebInterceptor implements HandlerInterceptor {
    private String name = "WebInterceptor Order[2] 拦截器";
    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String format = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        log.info("-------"+ name +" preHandle-------，时间{}",format);
        response.setHeader("Content-type","application/json;charset=UTF-8");
        return true;
    }

    /**
     * 在渲染视图之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        log.info("-------"+ name +" afterCompletion-------");
    }

    /**
     * 后处理回调方法，实现处理器（handler/controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        log.info("-------"+ name +" postHandle-------");
    }

    private void returnResult(HttpServletResponse response,String json) throws Exception{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
        response.getWriter().close();
    }
}
