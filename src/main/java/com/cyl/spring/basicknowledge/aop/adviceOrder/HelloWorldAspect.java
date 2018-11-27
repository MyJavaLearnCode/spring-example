package com.cyl.spring.basicknowledge.aop.adviceOrder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect()
public class HelloWorldAspect {
    @Pointcut(value = "execution(* spring.basicknowledge.aop.*.*.*(..))")
    public void pointcutName() {

    }
    @Before(value = "pointcutName()")
    public void beforeAdvice() {
        System.out.println("before advice");
    }

    @After(value = "pointcutName()")
    public void afterFinallyAdvice() {
        System.out.println("after finally advice");
    }

    @AfterReturning(value = "pointcutName()")
    public void afterReturningAdvice() {
        System.out.println("after return advice");
    }

    @AfterThrowing(value = "pointcutName()")
    public void afterThrowingAdvice() {
        System.out.println("after throwing advice");
    }

    @Around(value = "pointcutName()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before advice");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("around after advice");
    }

}
