package com.flexcub.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class CustomNotBlankConstraintValidator implements ConstraintValidator<CustomNotBlank, CharSequence> {

    private CustomNotBlank notBlank;

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(CharSequence, ConstraintValidatorContext)} calls.
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
    public void initialize(CustomNotBlank constraintAnnotation) {
        notBlank = constraintAnnotation;
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
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        CharSequence trimmedValue = value;
        if (notBlank.trim() && value != null) {
            trimmedValue = value.toString().trim();
        }
        return !(StringUtils.isBlank(trimmedValue));
    }
}
