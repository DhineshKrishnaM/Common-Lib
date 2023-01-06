package com.flexcub.common.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.flexcub.common.message.MessageConstants;


@Constraint(validatedBy = CustomEngineChassisConstraintValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomEngineChassis {

    String fieldCode();

    String fieldDefaultValue();

    String message() default MessageConstants.INVALIDENGINENUMBERFORMAT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
