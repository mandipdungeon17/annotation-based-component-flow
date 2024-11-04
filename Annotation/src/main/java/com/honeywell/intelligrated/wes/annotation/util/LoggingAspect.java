package com.honeywell.intelligrated.wes.annotation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.honeywell.intelligrated.wes.annotation.config.LogWebSocketHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Profile("dev")
@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private LogWebSocketHandler logWebSocketHandler;

    private final ObjectMapper objectMapper;

    private static int loop = 0;

    public LoggingAspect() {
        this.objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        this.objectMapper.registerModule(module);
    }

    @Around("@annotation(com.honeywell.intelligrated.wes.annotation.annotation.MyAnnotation)")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String compName = "Annotation";
        loop++;
        if(loop >2) compName = "NewComponent";
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getMethod().getName();
        Object[] args = joinPoint.getArgs();
        LocalDateTime timestamp = LocalDateTime.now();

        Map<String, Object> logMap = new HashMap<>();
        logMap.put("component", compName);
        logMap.put("className", className);
        logMap.put("method", methodName);
        logMap.put("inputValues", args);
        logMap.put("timestamp", timestamp);

        String log = objectMapper.writeValueAsString(logMap);
        logWebSocketHandler.sendLog(log);

        System.out.println(log);
        return joinPoint.proceed();
    }
}