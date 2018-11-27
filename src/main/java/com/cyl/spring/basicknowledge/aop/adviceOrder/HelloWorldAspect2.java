package com.cyl.spring.basicknowledge.aop.adviceOrder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect()
public class HelloWorldAspect2 {
    @Pointcut(value = "execution(* com.cyl.spring.basicknowledge.aop.*.*.*(..))")
    public void pointcutName() {

    }
    @Before(value = "pointcutName()")
    public void beforeAdvice() {
        System.out.println("before advice,2");
    }

    @After(value = "pointcutName()")
    public void afterFinallyAdvice() {
        System.out.println("after finally advice,2");
    }

    @AfterReturning(value = "pointcutName()")
    public void afterReturningAdvice() {
        System.out.println("after return advice,2");
    }

    @AfterThrowing(value = "pointcutName()")
    public void afterThrowingAdvice() {
        System.out.println("after throwing advice,2");
    }

    @Around(value = "pointcutName()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before advice,2");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("around after advice,2");
    }

}
