package com.dev_bootcamp.service_golden_service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
@AllArgsConstructor
public class KeyPassRequestDTO {

    private String keyPass;
    private Boolean activeKey;



}
