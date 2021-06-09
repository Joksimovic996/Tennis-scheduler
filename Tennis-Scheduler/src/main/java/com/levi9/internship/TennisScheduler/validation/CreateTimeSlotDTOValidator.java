package com.levi9.internship.TennisScheduler.validation;

import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DayOfWeek;


public class CreateTimeSlotDTOValidator implements ConstraintValidator<ValidCreateTimeSlotDTO, CreateTimeSlotDTO> {
    @Override
    public void initialize(ValidCreateTimeSlotDTO constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateTimeSlotDTO value, ConstraintValidatorContext context) {

        if (value.getStartDateAndTime().isBefore(value.getEndDateAndTime())){
            System.out.println("PRVI IF: isBefore");
            if ((value.getStartDateAndTime().getDayOfWeek() != DayOfWeek.SATURDAY) &&
                    (value.getStartDateAndTime().getDayOfWeek() != DayOfWeek.SUNDAY)){
                System.out.println("DRUGI IF: RADNI DAN");
                if ((value.getStartDateAndTime().getHour() >= 18) && (value.getEndDateAndTime().getHour() <= 23)) {
                    System.out.println("TRECI IF: DOBRO VREME");
                    return true;
                }
            } else {
                System.out.println("DRUGI IF: VIKEND");
                if ((value.getStartDateAndTime().getHour() >= 17) && (value.getEndDateAndTime().getHour() <= 22)) {
                    System.out.println("CETVRTI IF: DOBRO VREME");
                    return true;
                }
            }
        }

        return false;
    }
}
