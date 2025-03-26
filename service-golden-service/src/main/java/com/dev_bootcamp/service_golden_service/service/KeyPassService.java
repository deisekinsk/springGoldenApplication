package com.dev_bootcamp.service_golden_service.service;

import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.exception.KeyPassRegistredExcpetion;
import com.dev_bootcamp.service_golden_service.model.KeyPass;
import com.dev_bootcamp.service_golden_service.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyPassService {


    private final KeyRepository keyRepository;


    public KeyPassResponseDTO createKeyPass(final KeyPassRequestDTO keyPassRequestDTO) {

        if(){
            throw new KeyPassRegistredExcpetion(
              String.format("")
            );
        }


        KeyPass keyPass = KeyPass.builder()

                //.keypass(keyPassRequestDTO.getKeyPass())
                .build();

        return null;
}

}
