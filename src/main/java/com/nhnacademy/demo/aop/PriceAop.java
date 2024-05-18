package com.nhnacademy.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PriceAop {

    @Around("execution(* com.nhnacademy.demo.MyCommands.getPrice(..))")
    public Object logPriceAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드 실행
        Object result = joinPoint.proceed();

        // 메소드 실행 후 작업
        if (result != null) {
            log.info(result.toString());
        } else {
            log.info("Price not found or no result returned.");
        }

        return result;
    }

    @Around("execution(* com.nhnacademy.demo.MyCommands.listCities(..))")
    public Object logCitiesAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드 실행
        Object result = joinPoint.proceed();

        // 메소드 실행 후 작업
        if (result != null) {
            log.info(result.toString());
        } else {
            log.info("Cities not found or no result returned.");
        }

        return result;
    }

    @Around("execution(* com.nhnacademy.demo.MyCommands.bill(..))")
    public Object logBillAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드 실행
        Object result = joinPoint.proceed();

        // 메소드 실행 후 작업
        if (result != null) {
            log.info(result.toString());
        } else {
            log.info("bill not found or no result returned.");
        }

        return result;
    }

    @Around("execution(* com.nhnacademy.demo.MyCommands.listSectors(..))")
    public Object logSectorsAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드 실행
        Object result = joinPoint.proceed();

        // 메소드 실행 후 작업
        if (result != null) {
            log.info(result.toString());
        } else {
            log.info("sectors not found or no result returned.");
        }

        return result;
    }
}


