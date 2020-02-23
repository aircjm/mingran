package com.mingran.framework.aspectj;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mingran.common.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * controller日志切面
 *
 * @author aircjm
 */
@Aspect
@Component
@Slf4j
public class HttpRequestLogAspect {


    /**
     * 切面所切的位置
     */
    @Pointcut("execution(public * com.mingran.project.*.controller.*.*(..))")
    public void log() {
    }

    /**
     * 环绕通知
     *
     * @param pjp 执行的切入点
     * @return Object 方法执行结果
     * @throws Throwable 抛出的异常
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // Method
        Method method = methodSignature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        // 参数
        Object[] args = pjp.getArgs();
        // Parameter
        Parameter[] parameters = method.getParameters();
        // 请求标识
        String uuid = IdUtils.simpleUUID();
        // 获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("\n\t请求标识: {}\n\t请求IP: {}\n\t请求路径: {}\n\t请求方式: {}\n\t方法描述: {}\n\t请求参数: {}",
                uuid,
                request.getRemoteAddr(),
                request.getRequestURL(),
                request.getMethod(),
                getMethodInfo(methodSignature, targetClass, args),
                JSON.toJSONString(request.getParameterMap()));
        long startTime = System.currentTimeMillis();
        Object retVal = pjp.proceed(pjp.getArgs());
        long endTime = System.currentTimeMillis();
        log.info("\n\t请求标识: {} \n\t执行时间: {} ms \n\t返回值: {}",
                uuid,
                endTime - startTime,
                JSONObject.toJSONString(retVal));
        return retVal;
    }

    /**
     * 方法描述
     */
    private String getMethodInfo(MethodSignature methodSignature, Class<?> targetClass, Object[] args) {
        ConcurrentHashMap<String, Object> info = new ConcurrentHashMap<>(3);
        //  类名和方法名
        info.put("class.method", targetClass.getSimpleName() + "#" + methodSignature.getName());
        String[] parameterNames = methodSignature.getParameterNames();
        ConcurrentHashMap<String, Object> params;
        if (Objects.nonNull(parameterNames)) {
            params = new ConcurrentHashMap<>(parameterNames.length);
            for (int i = 0; i < parameterNames.length; i++) {
                Object value = args[i] != null ? args[i] : "null";
                if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                    //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                    //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                    continue;
                }
                params.put(parameterNames[i], value);
            }
            info.put("args", params);
        }
        return JSON.toJSONString(info);
    }
}
