package com.cn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class AopLog {
    private Logger logger= Logger.getLogger(AopLog.class); // 获取logger实例
    @Pointcut("execution(public * com.cn.controller..*.*(..))")
    public void webLog(){

    }
    @Before("webLog()")
    public void DoBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("###############打印开始#############");
        logger.info("URL:"+request.getRequestURL().toString());//获取请求地址
        logger.info("METHOD:"+request.getMethod());//获取方法POST 还是GET
        logger.info("IP地址："+request.getRemoteAddr());//获取ＩＰ地址
        Enumeration<String> enumeration=request.getParameterNames();//获取一连串的请求参数
        while (enumeration.hasMoreElements()){
           String name=enumeration.nextElement();//获取参数名字
           logger.info("name:"+name+",value:"+request.getParameter(name));//加上参数值
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void AfterMethod(Object ret){
        //处理完请求   返回内容
        logger.info("RESPONSE:"+ret);//请求结束   返回请求结果
        logger.info("###############打印结束#############");

    }


}
