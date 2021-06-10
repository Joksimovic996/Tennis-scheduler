package com.levi9.internship.TennisScheduler.validation;

import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.xml.bind.SchemaOutputResolver;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CreateTimeSlotDTOValidator implements ConstraintValidator<ValidCreateTimeSlotDTO, Set<CreateTimeSlotDTO>> {



    @Override
    public void initialize(ValidCreateTimeSlotDTO constraintAnnotation) {

    }

    @Override
    public boolean isValid(Set<CreateTimeSlotDTO> timeSlots, ConstraintValidatorContext context) {
        if (timeSlots.isEmpty()) {
            customMessageForValidation(context, "List of Time Slots is empty!");
            return false;
        } else {
            for (CreateTimeSlotDTO value : timeSlots ) {
                context.disableDefaultConstraintViolation();
                DayOfWeek dayOfWeek = value.getStartDateAndTime().getDayOfWeek();
                int startHourOfDay = value.getStartDateAndTime().getHour();
                int startMinuteOfHour = value.getStartDateAndTime().getMinute();
                int endHourOfDay = value.getEndDateAndTime().getHour();
                int endMinuteOfHour = value.getEndDateAndTime().getMinute();
                int minutesToPlay = (endHourOfDay * 60 + endMinuteOfHour) - (startHourOfDay * 60 + startMinuteOfHour);

                if (value.getStartDateAndTime().isBefore(value.getEndDateAndTime())) {
                    if (minutesToPlay >= 30 && minutesToPlay <= 120) {
                        if ((dayOfWeek != DayOfWeek.SATURDAY) && (dayOfWeek != DayOfWeek.SUNDAY)) {
                            if ((startHourOfDay >= 18) && (endHourOfDay <= 23)) {
                                return true;
                            } else {
                                customMessageForValidation(context, "On working days, you can register the slot from 18h to 23h!");
                                return false;
                            }
                        } else {
                            if ((startHourOfDay >= 17) && (endHourOfDay <= 22)) {
                                return true;
                            } else {
                                customMessageForValidation(context, "Working time on weekends is from 17h to 22h!");
                                return false;
                            }
                        }
                    } else {
                        customMessageForValidation(context, "Period cannot be longer than 2 hours. Period cannot be less than 30 minutes!");
                        return false;
                    }
                } else {
                    customMessageForValidation(context, "You cannot reserve a time slot in the past. Only for the current date and days in the future!");
                    return false;
                }
            }
        }
        return false;
    }

    private void customMessageForValidation(ConstraintValidatorContext context, String message) {
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
