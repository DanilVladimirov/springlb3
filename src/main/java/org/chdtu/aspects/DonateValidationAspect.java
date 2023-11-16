package org.chdtu.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.chdtu.Donation;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DonateValidationAspect {

    @Before("org.chdtu.aspects.Pointcuts.sendDonatePoint()")
    public void sendDonateBeforeAdvice() {
        System.out.println("спроба відправити донат");
    }

    @After("org.chdtu.aspects.Pointcuts.sendDonatePoint()")
    public void sendDonateStatisticsAdvice(JoinPoint joinPoint) {
        Donation donation = (Donation) joinPoint.getThis();

        System.out.println(
            String.format(
                "[Statistics]: Відправили донат від користувача %s на суму %f",
                donation.getUsername(), donation.getSum()
            )
        );
    }
}
