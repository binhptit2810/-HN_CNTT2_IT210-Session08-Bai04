package com.restaurant.session08_bai04.Bai04.validation;

import com.restaurant.session08_bai04.Bai04.dto.RegisterForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<ValidPasswordMatch, RegisterForm> {

    @Override
    public boolean isValid(RegisterForm value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String password = value.getPassword();
        String confirmPassword = value.getConfirmPassword();

        // Objects.equals handles both-null safely and avoids NullPointerException.
        boolean matched = Objects.equals(password, confirmPassword);
        if (matched) {
            return true;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Password va confirmPassword phai giong nhau")
                .addPropertyNode("confirmPassword")
                .addConstraintViolation();
        return false;
    }
}

