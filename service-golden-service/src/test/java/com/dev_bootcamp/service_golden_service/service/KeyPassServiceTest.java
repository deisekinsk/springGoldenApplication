package com.dev_bootcamp.service_golden_service.service;

import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.exception.KeyPassDuplicatedException;
import com.dev_bootcamp.service_golden_service.model.KeyPass;
import com.dev_bootcamp.service_golden_service.repository.KeyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

//JUnit5
@ExtendWith(MockitoExtension.class)
public class KeyPassServiceTest {
    @Mock
    private KeyRepository keyRepository;

    @InjectMocks
    private KeyPassService keyPassService;
    //private KeyPassRequestDTO keyPassRequestDTO;

    @Test
    public void when_create_keyPass_it_should_return_key_status(){
        KeyPassRequestDTO keyPassRequestDTO = new KeyPassRequestDTO();
        keyPassRequestDTO.setKeyPass("kinsk@msn");
        keyPassRequestDTO.setActiveKey(true);


        when(keyRepository.existsByKeyPass(keyPassRequestDTO.getKeyPass())).thenReturn(false);
        when(keyRepository.save(any(KeyPass.class))).thenAnswer(invocation -> {
            KeyPass entity = invocation.getArgument(0);
            entity.setId(UUID.randomUUID()); //simulation DB
            return entity;
        });

        KeyPassResponseDTO created = keyPassService.createKeyPass(keyPassRequestDTO);

        assertThat(created.getKeyPass()).isEqualTo(keyPassRequestDTO.getKeyPass());
        assertThat(created.getActiveKey()).isEqualTo(keyPassRequestDTO.getActiveKey());

    }

    @Test
    public void when_keyPass_alreadyExists_throwException(){
        KeyPassRequestDTO keyPassRequestDTO = new KeyPassRequestDTO();
        keyPassRequestDTO.setKeyPass("kinsk@msn");
        keyPassRequestDTO.setActiveKey(true);

        when (keyRepository.existsByKeyPass((keyPassRequestDTO.getKeyPass()))).thenReturn(true);

        KeyPassDuplicatedException isAcessible = new KeyPassDuplicatedException("Exception Acessible");
        assertThat(isAcessible).isNotNull();


        assertThatThrownBy(() -> keyPassService.createKeyPass(keyPassRequestDTO))
                .isInstanceOf(KeyPassDuplicatedException.class)
                .hasMessageContaining("The key kinsk@msn exist!");

    }


/**
 * https://www.freecodecamp.org/news/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772/
 * */


}
