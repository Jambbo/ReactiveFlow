package com.example.reactiveflow.service;

import com.example.reactiveflow.dto.NotificationDto;
import com.example.reactiveflow.mapper.NotificationMapper;
import com.example.reactiveflow.repository.NotificationRepository;
import com.example.reactiveflow.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findNotificationByUid(String uid){

        return notificationRepository.findById(uid)
                .map(notificationMapper::map);
    }

    public Mono<NotificationDto> findNotificationWithRecipientByUid(String uid){
        return notificationRepository.findById(uid)
                .flatMap(notificationEntity -> recipientRepository.findById(
                            notificationEntity.getRecipientUid()
                        )
                        .map(recipientEntity -> {
                            notificationEntity.setRecipient(recipientEntity);
                            return notificationEntity;
                        })
                        .map(notificationMapper::map)
                );
    }

}
