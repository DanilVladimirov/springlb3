package org.chdtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Donation donation = context.getBean("firstDonation", Donation.class);
        Donation donation2 = context.getBean("secondDonation", Donation.class);
        donation.sendDonate();

        UserSettings userSettings = context.getBean(UserSettings.class);
        userSettings.uploadImg();

        donation.getPaymentMethod().makePayment(donation.getSum());

        try {
            donation2.getPaymentMethod().makePayment(donation2.getSum());
        } catch (Exception e) {

        }

    }
}
