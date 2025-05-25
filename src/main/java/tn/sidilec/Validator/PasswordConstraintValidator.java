package tn.sidilec.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&     // au moins une majuscule
               password.matches(".*[0-9].*");       // au moins un chiffre
    }
}
