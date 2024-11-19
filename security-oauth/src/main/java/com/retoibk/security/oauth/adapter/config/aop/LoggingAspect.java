package com.retoibk.security.oauth.adapter.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

//@Component
//@Aspect
//@Slf4j
public class LoggingAspect {
//
//    @Pointcut("execution(* com.retoibk.customer.bcs.adapter.web..*(..))")
//    public void allRequest (){
//    }
//
//    @Before("allRequest()")
//    public void adviceBeforeRequest (JoinPoint jp){
//        String methodName = jp.getSignature().getName();
//        log.info("INIT: " + methodName);
//    }
//
//    @AfterReturning(pointcut = "allRequest()", returning = "result")
//    public void adviceAfterSuccesfulRequest (JoinPoint jp, Object result){
//        String methodName = jp.getSignature().getName();
//
//        if (result instanceof Mono) {
//            ((Mono<?>) result).doOnNext(response -> log.info("Response: {}", response))
//                    .subscribe();
//        }
//
//        log.info("END: " + methodName);
//    }
}
