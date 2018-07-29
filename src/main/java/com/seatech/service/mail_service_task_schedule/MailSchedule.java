package com.seatech.service.mail_service_task_schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling
@Component
public class MailSchedule {
    static int i = 0;
    static int thread = 0;

    @Scheduled(fixedDelay = 5000)
    public void test() {
        i++;
        long time = System.currentTimeMillis();
        long a;
        System.out.println("create task " + i + ": " + System.currentTimeMillis() / 1000);
        sendEmail();
        System.out.println("end task " + i + ": " + (System.currentTimeMillis() - time) / 1000);

    }

    @Autowired
    JavaMailSender mailSender;

    public static synchronized void sendEmail() {
        try {
            thread++;
            System.out.println("create thread " + thread);
            Thread.sleep(10000);
            System.out.println("kill thread " + thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
