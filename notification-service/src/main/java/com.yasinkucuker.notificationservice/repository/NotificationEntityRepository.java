package com.yasinkucuker.notificationservice.repository;


import com.yasinkucuker.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEntityRepository extends JpaRepository<Notification, Integer> {
}