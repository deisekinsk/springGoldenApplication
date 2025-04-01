package com.dev_bootcamp.service_golden_service.dto;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyPassResponseDTO {

    private String keyPass;
    private Boolean activeKey;

}
