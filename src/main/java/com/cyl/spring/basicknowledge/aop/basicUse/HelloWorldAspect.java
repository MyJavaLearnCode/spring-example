package com.cyl.spring.basicknowledge.aop.basicUse;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWorldAspect {
    public void beforeAdvice() {
        System.out.println("before advice");
    }

    public void afterFinallyAdvice() {
        System.out.println("after finally advice");
    }

    public void afterReturningAdvice() {
        System.out.println("after return advice");
    }

    public void afterThrowingAdvice() {
        System.out.println("after throwing advice");
    }

    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before advice");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("around after advice");
    }

}
