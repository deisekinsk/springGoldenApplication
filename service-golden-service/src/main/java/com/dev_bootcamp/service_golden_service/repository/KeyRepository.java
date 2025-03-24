package com.dev_bootcamp.service_golden_service.repository;

import com.dev_bootcamp.service_golden_service.model.KeyPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KeyRepository extends JpaRepository<KeyPass, UUID> {


    boolean existByKeyPass(final String keyPass);
    Optional<KeyPass> findByKeyPass(final String gotKeyPass);


}
