package com.example.reactiveflow.consumer;

import com.example.reactiveflow.dto.NotificationDto;
import com.example.reactiveflow.entity.NotificationEntity;
import com.example.reactiveflow.mapper.NotificationMapper;
import com.example.reactiveflow.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationsSQSConsumer {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto message){
        log.info("received notification: {}", message);
        NotificationEntity notification = notificationMapper.map(message);
        notificationRepository.save(notification).subscribe();
    }

}
