package com.nhnacademy.demo.aop;

import com.nhnacademy.demo.exception.NoLoginException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAop {
    @Around("execution(* com.nhnacademy.demo.service.AuthenticationService.getCurrentAccount(..))")
    public Object logCitiesAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드 실행
        Object result = joinPoint.proceed();

        // 메소드 실행 후 작업
        if (result == null) {

            throw new NoLoginException("\033[31mplease Login first!\033[0m");
        }

        return result;
    }

}
//
//    public AuthenticationAop(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @Before("execution(* com.nhnacademy.demo.MyCommands.*(..)) && !execution(* com.nhnacademy.demo.MyCommands.currentUser(..)) && " +
//            "!execution(* com.nhnacademy.demo.MyCommands.login(..)) && !execution(* com.nhnacademy.demo.MyCommands.logout(..)) ")
//    public void authenticateUserBefore(JoinPoint joinPoint) throws NoLoginException {
//        Account account = authenticationService.getCurrentAccount();
//
//        if (account == null) {
//            throw new NoLoginException("\033[31mplease Login first!\033[0m");
//        }
//    }