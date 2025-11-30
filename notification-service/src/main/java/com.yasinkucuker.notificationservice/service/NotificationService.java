package com.yasinkucuker.notificationservice.service;


import com.yasinkucuker.clients.notification.NotificationRequest;
import com.yasinkucuker.notificationservice.model.Notification;
import com.yasinkucuker.notificationservice.repository.NotificationEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationEntityRepository repository;

    public void sendNotification(NotificationRequest request) {
        repository.save(
                Notification.builder()
                        .toCustomerId(request.getToCustomerId())
                        .toCustomerPhone(request.getToCustomerPhone())
                        .message(request.getMessage())
                        .sender("robotdreams")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
        log.info("Notification sent :   {}" , request.getMessage());
    }
}
