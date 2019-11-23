package com.example.config;

import com.example.annotation.LoginAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Handler;

@Component
@Order(1)
public class XLInterceptor implements HandlerInterceptor {
    private String name = "XLInterceptor Order[1] 拦截器";
    private static final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("record-time");
    private static final Logger logger = LoggerFactory.getLogger(XLInterceptor.class);
    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String format = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        logger.info("-------"+ name +" preHandle-------，时间{}",format);
        long beginTime = System.currentTimeMillis();    //1、开始时间
        startTimeThreadLocal.set(beginTime);    //线程绑定变量（该数据只有当前请求的线程可见）
        LoginAnno authPassport = null;

        //handler.getClass() = HandlerMethod.class
        //if(handler.getClass().isAssignableFrom(Handler.class)){
            if(handler instanceof HandlerMethod) {
                authPassport = ((HandlerMethod) handler).getMethodAnnotation(LoginAnno.class);
            }
            //没有声明需要权限,或者声明不验证权限
            if(authPassport==null){
                return true;
            }else{
                //在这里实现自己的权限验证逻辑
                logger.info("获取注解类型:{}，名字:{},值:{}",authPassport.getClass(),authPassport.name(),authPassport.values());
                if(true){//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    logger.info("执行权限校验了");
                    return true;
                }else{//如果验证失败
                    //返回到登录界面
                    //logger.info("权限校验对了");
                    //response.sendRedirect("account/login");
                    return false;
                }
            }
        //}else{
            //return true;
        //}
    }

    /**
     * 在渲染视图之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        logger.info("-------"+ name +" afterCompletion-------");

        long endTime = System.currentTimeMillis();  // 2、结束时间
        long beginTime = startTimeThreadLocal.get();    // 得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime; // 3、消耗的时间
//        if (consumeTime > 500) {  // 此处认为处理时间超过500毫秒的请求为慢请求
//          // TODO 记录到日志文件
            logger.info(String.format("XLInterceptor拦截器afterCompletion  %s consume %d millis",
                    request.getRequestURI(), consumeTime));
//        }
    }

    /**
     * 后处理回调方法，实现处理器（handler/controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        logger.info("-------"+ name +" postHandle-------");
    }
}
