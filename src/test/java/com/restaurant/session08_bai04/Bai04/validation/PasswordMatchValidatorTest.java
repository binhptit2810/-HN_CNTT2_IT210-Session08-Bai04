package com.restaurant.session08_bai04.Bai04.validation;

import com.restaurant.session08_bai04.Bai04.dto.RegisterForm;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PasswordMatchValidatorTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    static void setup() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    static void tearDown() {
        validatorFactory.close();
    }

    @Test
    void shouldPassWhenPasswordEqualsConfirmPassword() {
        RegisterForm form = new RegisterForm();
        form.setUsername("alice");
        form.setPassword("123456");
        form.setConfirmPassword("123456");

        Set<ConstraintViolation<RegisterForm>> violations = validator.validate(form);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailWhenPasswordDifferentFromConfirmPassword() {
        RegisterForm form = new RegisterForm();
        form.setUsername("bob");
        form.setPassword("123456");
        form.setConfirmPassword("654321");

        Set<ConstraintViolation<RegisterForm>> violations = validator.validate(form);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(
                violations.stream().anyMatch(v -> "confirmPassword".equals(v.getPropertyPath().toString()))
        );
    }

    @Test
    void shouldNotThrowNpeWhenBothPasswordFieldsNull() {
        RegisterForm form = new RegisterForm();

        Assertions.assertDoesNotThrow(() -> validator.validate(form));
    }
}

