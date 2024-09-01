package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAllNotifications();
    Notification findNotificationById(Long notificationId);
    Notification createNotification(Notification notification);
    Notification updateNotification(Notification notification);
    Boolean deleteNotification(Long notificationId);
}
