package com.seatech.service.mail_service_task_schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailService {
    @Autowired
    JavaMailSender mailSender;

    public synchronized void sendEmail(String subject, String message, String recipientEmail) throws MessagingException {
//        Locale locale = LocaleContextHolder.getLocale();
//        // Prepare the evaluation context
//        Context ctx = new Context(locale);
//        ctx.setVariable("message", message);
        // Prepare message using a Spring helper
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setTo(recipientEmail);
        // Create the HTML body using Thymeleaf
        String htmlContent = "";
//        htmlContent = templateEngine.process("mail/email_en.html", ctx);
        mimeMessageHelper.setText(htmlContent, true);
        // Send email
        mailSender.send(mimeMessage);
    }
}