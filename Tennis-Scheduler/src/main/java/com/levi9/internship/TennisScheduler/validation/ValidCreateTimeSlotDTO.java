package com.levi9.internship.TennisScheduler.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CreateTimeSlotDTOValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCreateTimeSlotDTO {

    String message() default "default";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
