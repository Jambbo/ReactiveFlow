package com.example.reactiveflow.rest;


import com.example.reactiveflow.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/recipients")
@RequiredArgsConstructor
public class RecipientControllerV1 {

    private final RecipientService recipientService;

    @GetMapping("/{uid}")
    public Mono<?> getRecipientWithNotifications(@PathVariable String uid){
        return recipientService.getRecipientWithNotificationsByUid(uid);
    }

}
