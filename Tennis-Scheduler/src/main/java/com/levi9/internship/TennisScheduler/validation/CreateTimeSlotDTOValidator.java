package com.levi9.internship.TennisScheduler.validation;

import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateTimeSlotDTOValidator implements ConstraintValidator<ValidCreateTimeSlotDTO, CreateTimeSlotDTO> {
    @Override
    public void initialize(ValidCreateTimeSlotDTO constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateTimeSlotDTO value, ConstraintValidatorContext context) {

        if (value.getStartDateAndTime().isBefore(value.getEndDateAndTime())){
            return true;
        }

        return false;
    }
}
