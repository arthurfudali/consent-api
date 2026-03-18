package com.dev.consentapi.domain.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CPFValidator implements ConstraintValidator<ValidCPF, String> {
    private static final Pattern FORMAT = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || !FORMAT.matcher(cpf).matches()) {
            return false;
        }
        String digits = cpf.replaceAll("[^\\d]", "");

        if (digits.chars().distinct().count() == 1) return false;

        return digitVerifier(digits, 9) && digitVerifier(digits, 10);
    }

    private boolean digitVerifier(String digits, int position) {
        int sum = 0;
        for (int i = 0; i < position; i++) {
            sum += Character.getNumericValue(digits.charAt(i)) * (position + 1 - i);
        }
        int remainder = (sum * 10) % 11;
        int expected = (remainder == 10 || remainder == 11) ? 0 : remainder;
        return expected == Character.getNumericValue(digits.charAt(position));
    }
}
