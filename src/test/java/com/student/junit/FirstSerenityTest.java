package com.student.junit;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;


public class FirstSerenityTest {


    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 5050;
        RestAssured.basePath = "/student";
    }

    @Test
    public void getAllStudents() {
        RestAssured.given().when().get("/list").then().log().all().statusCode(200);
    }
}
