package com.student.cucumber.serenity;

import Student.StudentClass;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.List;

public class StudentSerenitySteps {


    //if want to add step this method in the report to create reusable steps we use @Step anotation
    @Step
    public ValidatableResponse createStudent(int id,String firstName,
            String lastname,
            String email,
            List<String>
                    courses) {

        StudentClass studentClass = new StudentClass();
        studentClass.setId(id);
        studentClass.setFirstName(firstName);
        studentClass.setEmail(email);
        studentClass.setLastName(lastname);
        studentClass.setCourses(courses);

        return (ValidatableResponse)SerenityRest.rest().given().contentType(ContentType.JSON).log().all().when().body(studentClass).then();
        //then() will provide a validatable response
    }
}
