package com.dev_bootcamp.service_golden_service.dto;

import jakarta.persistence.Column;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyPassRequestDTO {

    private String keyPass;
    private Boolean activeKey;



}
