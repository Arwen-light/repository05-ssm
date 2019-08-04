package com.admain.log;

import com.admin.domain.SysLog;
import com.admin.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService iSysLogService;

    @Around("execution(* com.admain.controller.*.*(..))")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable{
        /*
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
         */
        //访问时间
        Date visitTime = new Date();
        //  private String username;  获取访问的操作者
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // 获取执行该方法进入的时间
        long startTime= System.currentTimeMillis();
        //执行切入点的方法
        Object proceed = joinPoint.proceed();
        // 获取访问ip
        String ip = request.getRemoteAddr();
        // 获取url
        String url = request.getRequestURI();
        // 获取方法执行的结束时间
        long endTime = System.currentTimeMillis();
        // 获取执行时间
        Long executionTime = endTime - startTime;
        //访问方法
        //获取切入点方法所在类的字节码对象
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String method = className + "." + methodName;
        //将以上参数封装SysLog对象中；
        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(visitTime);
        sysLog.setUsername(username);
        sysLog.setIp(ip);
        sysLog.setUrl(url);
        sysLog.setExecutionTime(executionTime);
        sysLog.setMethod(method);

        System.out.println(sysLog);
        iSysLogService.saveSysLog(sysLog);
        return proceed;
    }


}
