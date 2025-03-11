package com.example.reactiveflow.service;

import com.example.reactiveflow.dto.RecipientDto;
import com.example.reactiveflow.entity.NotificationEntity;
import com.example.reactiveflow.entity.RecipientEntity;
import com.example.reactiveflow.mapper.RecipientMapper;
import com.example.reactiveflow.repository.NotificationRepository;
import com.example.reactiveflow.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;


    @Override
    public Mono<RecipientDto> getRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(
                recipientRepository.findById(uid),
                notificationRepository.findAllByRecipientUid(uid).collectList()
        ).map(tuples -> {
            RecipientEntity recipientEntity = tuples.getT1();
            List<NotificationEntity> notificationEntities = tuples.getT2();
            recipientEntity.setNotifications(notificationEntities);
            return recipientEntity;
        }).map(recipientMapper::map);
    }
}
