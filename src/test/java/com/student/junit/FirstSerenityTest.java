package com.student.junit;


import Student.StudentClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
    //first class

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/student";
    }

    @Test
    public void addAStudent() {
        StudentClass student = new StudentClass();
        student.setId(101);
        student.setFirstName("Mk");
        student.setLastName("kumwat");
        student.setEmail("mk@gmail.com");
        String listOfProgramme[] = {"Java", "C++"};
        student.setCourses(Arrays.asList(listOfProgramme));
        student.setProgramme("IT");

        RestAssured.given().contentType(ContentType.JSON).when().body(student).then().statusCode(201);
    }

    @Test
    public void getAllStudents() {
        RestAssured.given().when().get("/list").then().log().all().statusCode(200);
    }

    @Test
    public void thisIsAFailingTest() {
        SerenityRest.given().when().get("/list").then().statusCode(500);
    }
}
