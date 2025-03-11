package com.example.reactiveflow.mapper;

import com.example.reactiveflow.dto.NotificationDto;
import com.example.reactiveflow.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);

}
