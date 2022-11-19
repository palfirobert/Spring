package main.java.com;


import main.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;
    @Min(value = 0,message = "Must be greater then 0")
    @Max(value=10,message = "Most be less than 10")
    @NotNull(message = "is required")
    private Integer freePasses;    // aici a pus integer ca asa se apeleaza si string trimmer si nu da eroare de conversion
    @Pattern(regexp = "^[0-9]{6}",message = "only 6 digits")
    private String postalCode;
    @CourseCode(value = "LUV",message = "must start with LUV")
    private String courseCode;
    public Customer(){}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
