package com.dev.consentapi.repository;

import com.dev.consentapi.domain.Consent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ConsentRepository extends MongoRepository<Consent, UUID> {
}
