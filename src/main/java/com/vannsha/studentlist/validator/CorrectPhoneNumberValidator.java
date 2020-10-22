package com.vannsha.studentlist.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CorrectPhoneNumberValidator implements ConstraintValidator<CorrectPhoneNumber, String> {
    private static final String PHONE_REGEX = "\\+\\d{2}(-\\d{3}){2}-\\d{2}-\\d{2}";
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !s.isEmpty() && s.matches(PHONE_REGEX);
    }
}
