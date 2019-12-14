package com.example.aop;

import com.example.dto.validate.People;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 基于注解的AOP
 .TimerInterceptor - -------TimerInterceptor Order[1] 拦截器 preHandle-------，时间20191002
 .WebInterceptor - -------TimerInterceptor Order[2] 拦截器 preHandle-------，时间20191002
 .XLAop - AOP @Around aspet around...（1）
 .XLAop - AOP @Before aspet before...
 BookController - GoInto BookController selectById
 BooksServiceImpl - GoInto serviceImpl selectByid
 .XLAop - AOP @Around aspet around...（2）
 .XLAop - AOP @After aspet after...
 .XLAop - AOP @AfterReturning aspet afterreturning...
 .WebInterceptor - -------TimerInterceptor Order[2] 拦截器 postHandle-------
 .TimerInterceptor - -------TimerInterceptor Order[1] 拦截器 postHandle-------
 .WebInterceptor - -------TimerInterceptor Order[2] 拦截器 afterCompletion-------
 .TimerInterceptor - -------TimerInterceptor Order[1] 拦截器 afterCompletion-------
 */
@Component
@Aspect
@Order(2)  //设置切面的优先级：如果有多个切面，可通过设置优先级控制切面的执行顺序（数值越小，优先级越高）
public class XLAop {
    private static final Logger logger = LoggerFactory.getLogger(XLAop.class);
    private final String pointCutStr = "execution(* com.example.controller..*.*(..))";
    public XLAop() {
        logger.info("加载了...XLAop");
    }

    /**
     * 	  例如定义切入点表达式 execution(* com.sample.service.impl..*.*(..))
     execution()是最常用的切点函数，其语法如下所示：
     整个表达式可以分为五个部分：
     1、execution(): 表达式主体。
     2、第一个*号：表示返回类型，*号表示所有的类型。
     3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     4、第二个*号：表示类名，*号表示所有的类。
     5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut(pointCutStr)
    public void checkPointcut(){}

    /**
     * 返回值不能是void，不然值返回不到前端
     */
    @Around("checkPointcut()")
    public Object aroundCheck(ProceedingJoinPoint call) throws Throwable{
        logger.info("AOP @Around aspet around...（前置）");
        Object obj = call.proceed();
        logger.info("AOP @Around aspet around...（后置）");
        return obj;
    }

    /**
     * 前置通知，可以【处理入参】
     * https://blog.csdn.net/puhaiyang/article/details/78146620
     */
    @Before("checkPointcut()")
    public void before(JoinPoint joinPoint) {
        logger.info("AOP @Before aspet before...");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof People) {
                People paramVO = (People) argItem;
                paramVO.setAge(paramVO.getAge()+10);
            }
            System.out.println("---->after-->argItem:" + argItem);
        }
    }

    @After("checkPointcut()")
    public void after() {
        logger.info("AOP @After aspet after...");
    }

    /**
     * 后置返回通知
     * 这里需要注意的是:
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
     * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "checkPointcut()",returning = "object")
    public void afterReturning(JoinPoint joinPoint,Object object) {
        logger.info("AOP @AfterReturning aspet afterreturning...");
        if(object instanceof String){
            object = "由AOP处理统一返回：" + object;
        }
    }

    @AfterThrowing(value = "checkPointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("AOP @AfterThrowing aspet thow exception...");
    }

}

