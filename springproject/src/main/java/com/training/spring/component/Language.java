package com.training.spring.component;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;


@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD,
          ElementType.PARAMETER
})
@Qualifier
public @interface Language {

    String value();

}
