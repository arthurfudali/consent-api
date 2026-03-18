package com.dev.consentapi.domain.dto;

import com.dev.consentapi.domain.validation.ValidCPF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ConsentRequestDTO(
        @NotBlank(message = "CPF é obrigatório")
        @ValidCPF
        String cpf,

        LocalDateTime expirationDateTime,

        @Size(min = 1, max = 50, message = "additionalInfo deve ter entre 1 e 50 caracteres")
        String additionalInfo
) {
}
