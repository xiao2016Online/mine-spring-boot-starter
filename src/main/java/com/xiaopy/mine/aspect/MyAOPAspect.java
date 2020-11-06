package com.xiaopy.mine.aspect;

import com.xiaopy.mine.annotation.MyAOP;
import com.xiaopy.mine.domain.MyObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xiaopeiyu
 * @since 2020/11/5
 */
@Aspect
@Component
@Slf4j
@Order(-999)
public class MyAOPAspect {

    @Autowired
    private MyObject myObject;

    @Pointcut(value = "@annotation(com.xiaopy.mine.annotation.MyAOP)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAroundGame(ProceedingJoinPoint point) throws Throwable   {
        System.out.println(myObject.toString());
        log.info(myObject.toString());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        MyAOP myAOP = method.getAnnotation(MyAOP.class);
        log.info("myaop={},{}",myAOP.name(),myAOP.value());
        return point.proceed();
    }
}
