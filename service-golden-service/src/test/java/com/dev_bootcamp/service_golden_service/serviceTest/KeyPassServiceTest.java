package com.dev_bootcamp.service_golden_service.serviceTest;


import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.model.KeyPass;
import com.dev_bootcamp.service_golden_service.repository.KeyRepository;
import com.dev_bootcamp.service_golden_service.service.KeyPassService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class KeyPassServiceTest {
    @Mock
    private KeyRepository keyRepository;

    @InjectMocks
    private KeyPassService keyPassService;
    private KeyPassRequestDTO keyPassRequestDTO;

    @BeforeEach
    void setUp(){
        keyPassRequestDTO = new KeyPassRequestDTO();
        keyPassRequestDTO.setKeyPass("kinsk@msn");
        keyPassRequestDTO.setActiveKey(true);
    }


    @Test
    void createKeyPass_withSuccess(){

    when(keyRepository.existsByKeyPass("kinsk@msn")).thenReturn(false);

    when(keyRepository.save(any(KeyPass.class))).thenAnswer(invocation -> {
        KeyPass savedKeyPass = invocation.getArgument(0);
        return savedKeyPass;

    KeyPassResponseDTO keyPassResponseDTO = keyPassService.createKeyPass(requestDTO);

    assertEquals("kinsk@msn", keyPassResponseDTO.getKeyPass());
    assertTrue(keyPassResponseDTO.getActiveKey());;
    verify(keyRepository, times(1)).save(any(KeyPass.class));

    }


}
