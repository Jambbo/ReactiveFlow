package com.example.reactiveflow.service;

import com.example.reactiveflow.dto.RecipientDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RecipientService {

    Mono<RecipientDto> getRecipientWithNotificationsByUid(String uid);

}
