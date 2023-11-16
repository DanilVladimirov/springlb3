package org.chdtu.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* org.chdtu.Donation.sendDonate(..))")
    public void sendDonatePoint(){}

    @Pointcut("execution(* org.chdtu.UserSettings.uploadImg(..))")
    public void uploadImgUserPoint(){}

    @Pointcut("execution(* org.chdtu.PaymentMethod.makePayment(..))")
    public void makePaymentPoint(){}

}
