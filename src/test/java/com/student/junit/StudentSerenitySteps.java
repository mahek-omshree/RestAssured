package com.student.junit;

import Student.StudentClass;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class StudentSerenitySteps {


    //if want to add step this method in the report to create reusable steps we use @Step anotation
    @Step("Creating student with studentid:{0}, firstname:{1}, lastname:{2}, email:{3}, courses:{4}, programme:{5}")
    public ValidatableResponse createStudent(int id, String firstName,
            String lastname,
            String email,
            List<String> courses,
            String programme) {

        StudentClass studentClass = new StudentClass();
        studentClass.setId(id);
        studentClass.setFirstName(firstName);
        studentClass.setEmail(email);
        studentClass.setLastName(lastname);
        studentClass.setCourses(courses);
        studentClass.setProgramme(programme);

        return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(studentClass).post().then();
        //then() will provide a validatable response
    }

    @Step
    public HashMap<String,Object> getStudentInfoByFirstName(String firstName){

        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        return SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path(p1+firstName+p2);
    }

    @Step
    public void logForSerenityReport(String input) {
        //logic step used to store sth to report
    }
}
