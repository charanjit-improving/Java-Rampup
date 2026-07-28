package com.example.practice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername,String> {

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username==null) {
            return false;
        }
        if(username.length()<3) {
            return false;
        }

        if (username.contains(" ")) {
            return false;
        }

        return true;

    }
    
}
