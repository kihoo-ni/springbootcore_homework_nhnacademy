package com.nhnacademy.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

    @Component
    @Aspect
    @Slf4j
    public class LoginAop {

        @Before("execution(* com.nhnacademy.demo.service.AuthenticationService.login(..))")
        public void loginLog(JoinPoint joinPoint) {
            Object[] args = joinPoint.getArgs();
            Long id = (Long) args[0];
            String password = (String) args[1];
            log.info("login(["+id+","+password+"])");
        }

        @Before("execution(* com.nhnacademy.demo.service.AuthenticationService.logout(..))")
        public void logoutLog() {
            log.info("logout([])");
        }
    }
