package com.vannsha.studentlist.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CorrectEmailValidator.class)
public @interface CorrectEmail {
    String message() default "{correctEmail}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
