package com.luv2code.springmvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String desiredCoursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        desiredCoursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(theCode != null) {
            result = theCode.startsWith(desiredCoursePrefix);
        }
        else{
            result = true;
        }

        return result;
    }
}
