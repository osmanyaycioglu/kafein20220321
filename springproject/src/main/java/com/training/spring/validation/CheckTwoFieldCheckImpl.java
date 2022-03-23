package com.training.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import com.training.spring.person.rest.models.PersonRest;

public class CheckTwoFieldCheckImpl implements ConstraintValidator<CheckTwoField, PersonRest> {

    private CheckTwoField anno;

    @Override
    public void initialize(final CheckTwoField anno) {
        this.anno = anno;

    }

    @Override
    public boolean isValid(final PersonRest valueParam,
                           final ConstraintValidatorContext contextParam) {
        if ((valueParam.getHeight() / this.anno.value()) < valueParam.getWeight()) {
            contextParam.disableDefaultConstraintViolation();
            ConstraintViolationBuilder cvLoc = contextParam.buildConstraintViolationWithTemplate("deneme xyz");
            cvLoc.addConstraintViolation();
            return false;
        }
        return true;
    }

}
