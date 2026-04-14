package com.restaurant.session08_bai04.Bai04.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPasswordMatch {

    String message() default "Password va confirmPassword khong khop";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

