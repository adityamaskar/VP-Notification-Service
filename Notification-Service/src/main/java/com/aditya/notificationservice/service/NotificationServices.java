package com.aditya.notificationservice.service;

import com.aditya.notificationservice.dto.AuthCompleteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServices {

    @KafkaListener(topics = "notificationTopic", groupId = "notificationId")
    public void receiveNotification(AuthCompleteEvent authCompleteEvent){
//        AuthCompleteEvent authCompleteEvent1 = (AuthCompleteEvent) authCompleteEvent;
      log.info("User " + authCompleteEvent.getFullName() + " have Logged in.");
    }

}
