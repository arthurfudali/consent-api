package com.dev.consentapi.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "consents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consent {
    @Id
    @MongoId(FieldType.STRING)
    private UUID id;

    private String cpf;

    private ConsentStatus status;
    private LocalDateTime creationDateTime;
    private LocalDateTime expirationDateTime;

    @Size(min = 1, max = 50)
    private String aditionalInfo;
}
