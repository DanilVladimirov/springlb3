package org.chdtu.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PaymentAspect {
    @AfterThrowing(pointcut = "org.chdtu.aspects.Pointcuts.makePaymentPoint()", throwing = "e")
    public void handleExceptionPaymentAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("[Payment] error: " + e.getMessage());
    }
}
