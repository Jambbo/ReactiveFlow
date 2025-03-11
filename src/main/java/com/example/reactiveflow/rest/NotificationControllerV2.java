package com.example.reactiveflow.rest;

import com.example.reactiveflow.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2/notifications")
@RequiredArgsConstructor
public class NotificationControllerV2 {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> findNotificationByUid(@PathVariable String uid){
        return notificationService.findNotificationWithRecipientByUid(uid);
    }

}
