package com.levi9.internship.TennisScheduler.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CreateTimeSlotDTOValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCreateTimeSlotDTO {

    String message() default "End date of reservation must be after start date of the reservation";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
