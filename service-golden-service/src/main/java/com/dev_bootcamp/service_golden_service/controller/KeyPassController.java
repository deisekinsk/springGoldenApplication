package com.dev_bootcamp.service_golden_service.controller;

import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.service.KeyPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/golden/keypass")
@RestController
@RequiredArgsConstructor
public class KeyPassController {

    private final KeyPassService keyPassService;

    @PostMapping
    public ResponseEntity<KeyPassResponseDTO> createKeyPass(
            @RequestBody KeyPassRequestDTO keyPassRequestDTO){
        return ResponseEntity.status(CREATED).body(
                keyPassService.createKeyPass(
                keyPassRequestDTO
        ));
    }

    @GetMapping("/{keyPass}")
    public ResponseEntity<KeyPassResponseDTO> findKeyPass(
            @PathVariable String keyPass){
        return ResponseEntity.status(CREATED).body(
                keyPassService.findKeyPass(
                keyPass
        ));
    }
}
