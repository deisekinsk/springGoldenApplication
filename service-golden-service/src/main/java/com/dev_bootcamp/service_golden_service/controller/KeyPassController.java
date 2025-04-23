package com.dev_bootcamp.service_golden_service.controller;

import com.dev_bootcamp.service_golden_service.dto.KeyPassRequestDTO;
import com.dev_bootcamp.service_golden_service.dto.KeyPassResponseDTO;
import com.dev_bootcamp.service_golden_service.service.KeyPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
        return ResponseEntity.status(OK).body(
                keyPassService.findKeyPass(
                keyPass
        ));
    }

    @GetMapping
    public ResponseEntity<List<KeyPassResponseDTO>> getAllKeypass(){
        return ResponseEntity.status(OK).body(
                keyPassService.getAllKeypass());
    }

    @PutMapping("/{keyPass}")
    public ResponseEntity<KeyPassResponseDTO> updateKeyPass(
            @PathVariable String keyPass,
            @RequestBody KeyPassRequestDTO keyPassRequestDTO){
        return ResponseEntity.status(OK).body(
                keyPassService.updateKeyPass(keyPass, keyPassRequestDTO)
        );
    }

    @DeleteMapping("/{keyPass}")
    public ResponseEntity<Void> deleteKeyPass(
            @PathVariable String keyPass
    ){
        keyPassService.deleteKeyPass(keyPass);
        return ResponseEntity.noContent().build();
    }



}
