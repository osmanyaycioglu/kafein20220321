package com.training.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithCheckImpl implements ConstraintValidator<StartWith, String> {

    private StartWith startWith;

    @Override
    public void initialize(final StartWith startWith) {
        this.startWith = startWith;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        if ((valueParam == null) || valueParam.isEmpty()) {
            return false;
        }
        return valueParam.startsWith(this.startWith.value());
    }

}
