package com.luv2code.springmvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "NBG";

    public String message() default "must start with NBG";

    // to club similar other annotations together
    public Class<?>[] groups() default {};

    // to customize error messages on validation failure
    public Class<? extends Payload>[] payload() default {};

}
