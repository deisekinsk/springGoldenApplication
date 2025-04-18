package com.dev_bootcamp.service_golden_service.service;

import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.exception.KeyPassNotFoundException;
import com.dev_bootcamp.service_golden_service.exception.KeyPassDuplicatedException;
import com.dev_bootcamp.service_golden_service.model.KeyPass;
import com.dev_bootcamp.service_golden_service.repository.KeyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KeyPassService {


    private final KeyRepository keyRepository;

    @Transactional
    public KeyPassResponseDTO createKeyPass(final KeyPassRequestDTO keyPassRequestDTO) {

        if(keyRepository.existsByKeyPass(keyPassRequestDTO.getKeyPass())){
            throw new KeyPassDuplicatedException(
              String.format("The key is: %s exist!", keyPassRequestDTO.getKeyPass())
            );
        }

        KeyPass keyPass = new KeyPass();
        keyPass.setKeyPass(keyPassRequestDTO.getKeyPass());
        keyPass.setActiveKey(keyPassRequestDTO.getActiveKey());

        KeyPass saved = keyRepository.save(keyPass);

        return KeyPassResponseDTO.builder()
                .keyPass(keyPassRequestDTO.getKeyPass())
                .activeKey(keyPassRequestDTO.getActiveKey())
                .build();


}

    public KeyPassResponseDTO findKeyPass (final String searchedKeyPass) {

        KeyPass keyPass = keyRepository.findByKeyPass(searchedKeyPass).orElseThrow(
                () -> new KeyPassNotFoundException(
                        String.format("THe key: %s is not found.", searchedKeyPass)
                ));

        return KeyPassResponseDTO.builder()
                .keyPass(keyPass.getKeyPass())
                .activeKey(keyPass.getActiveKey())
                .build();

}


    public List<KeyPassResponseDTO> getAllKeypass() {
        return keyRepository.findAll().stream()
                .map(keyPass -> KeyPassResponseDTO.builder()
                        .keyPass(keyPass.getKeyPass())
                        .activeKey(keyPass.getActiveKey())
                        .build())
                .collect(Collectors.toList());
    }

}
