package com.mqs.emailservice.service;

import com.mqs.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(OrderEvent orderEvent) {
        // TODO: implement logic to send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("vasu9deva@gmail.com");
        message.setSubject("RabbitMQ Order Confirmation Test");
        message.setText(orderEvent.toString());
        javaMailSender.send(message);
    }
}
