package com.dev_bootcamp.service_golden_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KeyPass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String keyPass;
    @Column
    private Boolean activeKey;

}
