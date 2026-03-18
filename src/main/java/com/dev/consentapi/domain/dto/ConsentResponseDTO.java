package com.dev.consentapi.domain.dto;

import com.dev.consentapi.domain.ConsentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsentResponseDTO(
        UUID id,
        String cpf,
        ConsentStatus status,
        LocalDateTime creationDateTime,
        LocalDateTime expirationDateTime,
        String additionalInfo
) {
}