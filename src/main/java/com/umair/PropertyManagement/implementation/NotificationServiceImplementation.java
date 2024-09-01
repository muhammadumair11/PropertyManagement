package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Notification;
import com.umair.PropertyManagement.repository.NotificationRepository;
import com.umair.PropertyManagement.services.NotificationService;
import com.umair.PropertyManagement.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImplementation implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId).orElse(null);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        Notification notification1 = findNotificationById(notification.getId());

        if(notification1 != null) {
            notification.setId(notification1.getId());
            return notificationRepository.save(notification);
        }

        return null;
    }

    @Override
    public Boolean deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);

        if(findNotificationById(notificationId) == null)
            return true;
        return false;
    }
}
