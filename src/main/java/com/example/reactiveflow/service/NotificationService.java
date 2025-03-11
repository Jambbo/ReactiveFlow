package com.example.reactiveflow.service;

import com.example.reactiveflow.dto.NotificationDto;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<NotificationDto> findNotificationByUid(String uid);

    Mono<NotificationDto> findNotificationWithRecipientByUid(String uid);

}
