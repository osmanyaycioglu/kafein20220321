package com.training.spring.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD
})
@Constraint(validatedBy = {
                            CheckTwoFieldCheckImpl.class
})
public @interface CheckTwoField {

    int value();

    String message() default "İkili check patladı";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
