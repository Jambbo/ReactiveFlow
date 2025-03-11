package com.example.reactiveflow.mapper;

import com.example.reactiveflow.dto.RecipientDto;
import com.example.reactiveflow.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto map(RecipientEntity recipientEntity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto recipientDto);

}
