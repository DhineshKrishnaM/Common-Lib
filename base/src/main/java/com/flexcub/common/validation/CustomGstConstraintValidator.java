package com.flexcub.common.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomGstConstraintValidator implements ConstraintValidator<CustomGst, String> {

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(String, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     *
     * <p>This method is guaranteed to be called before any use of this instance for
     * validation.
     *
     * <p>The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(CustomGst constraintAnnotation) {

    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     *
     * <p>This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            String regEx = "^[0-9]{2}[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}[1-9A-Za-z]{1}[Zz][0-9A-Za-z]{1}$";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();

        }
        return false;
    }

}