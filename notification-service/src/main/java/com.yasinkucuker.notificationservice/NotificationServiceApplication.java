package com.yasinkucuker.notificationservice;


import com.yasinkucuker.notificationservice.config.NotificationConfig;
import com.yasinkucuker.notificationservice.model.Notification;
import com.yasinkucuker.rabbitmq.RabbitMQMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {
        "com.yasinkucuker.notificationservice",
        "com.yasinkucuker.rabbitmq"
})
@EnableDiscoveryClient
public class NotificationServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Autowired
    RabbitMQMessageProducer producer;

    @Autowired
    NotificationConfig config;

    public void run(String... args) throws Exception{
        // producer.publish("Test test...", config.getNotificationExchange(), config.getNotificationRoutingKey());
        producer.publish(Notification.builder().toCustomerPhone("05431129459")
                .sender("aaa")
                .build(),
                config.getNotificationExchange(),
                config.getNotificationRoutingKey());
    }

}
