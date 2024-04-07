package com.luv2code.springmvc;

import com.luv2code.springmvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 3, message = "minimum legth of 3 required")
    private String firstName;
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "value should be greater than or equal to 0")
    @Max(value = 10, message = "value should be lesser than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "maximum of 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "MSD", message = "must start with MSD")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
