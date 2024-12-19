package com.mqs.emailservice.consumer;

import com.mqs.emailservice.dto.OrderEvent;
import com.mqs.emailservice.service.EmailService;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailOrderConsumer {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmailOrderConsumer.class);

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.email.queue}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info("Consumed {} from email queue", orderEvent.toString());
        // TODO: implement logic to send email
        emailService.sendEmail(orderEvent);
    }
}
