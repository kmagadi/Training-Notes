package com.training.spring_security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // ✅ Correct pointcut (matches your package)
    @Pointcut("execution(* com.training.spring_security.service.*.*(..))")
    public void serviceLayer() {}

    // 🔹 BEFORE
    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("👉 Entering method: {} with args: {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    // 🔹 AFTER RETURNING
    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("✅ Method completed: {} with result: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }

    // 🔹 AFTER THROWING
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("❌ Exception in method: {} | message: {}",
                joinPoint.getSignature().toShortString(),
                ex.getMessage());
    }

    // 🔥 AROUND (BEST ONE - shows execution time)
    @Around("serviceLayer()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        log.info("⏱️ Starting: {}", joinPoint.getSignature().toShortString());

        try {
            Object result = joinPoint.proceed();

            long timeTaken = System.currentTimeMillis() - start;

            log.info("⏱️ Completed: {} in {} ms",
                    joinPoint.getSignature().toShortString(),
                    timeTaken);

            return result;

        } catch (Exception ex) {
            long timeTaken = System.currentTimeMillis() - start;

            log.error("💥 Failed: {} in {} ms",
                    joinPoint.getSignature().toShortString(),
                    timeTaken);

            throw ex;
        }
    }
}