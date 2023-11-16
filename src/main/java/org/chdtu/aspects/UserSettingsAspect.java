package org.chdtu.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.chdtu.Donation;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserSettingsAspect {

    @Before("org.chdtu.aspects.Pointcuts.uploadImgUserPoint()")
    public void uploadImgBeforeAdvice() {
        System.out.println("[UserImgUpload]: спроба загрузити картинку");
    }

    @Around("org.chdtu.aspects.Pointcuts.uploadImgUserPoint()")
    public void uploadImgAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - startTime) / 1000;

        System.out.println(
            String.format(
                "[UserImgUpload]: загрузка картинки зайняла %d сек.", executionTime
            )
        );
    }
}
