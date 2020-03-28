package com.student.junit;

import Student.StudentClass;
import com.student.testbase.TestBase;
import com.student.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CrudModified extends TestBase {

    // TestBase class is having all initialisation part

    //to show it in the report we use Steps
    @Steps
    StudentSerenitySteps steps;

    StudentClass studentClass = new StudentClass();

    static String firstName = "Pragya";
    static int studentId;

    String arrays[] = {"java", "C++", "python"};
    List<String> listOfCourses = Arrays.asList(arrays);


    @Title("post a new student")
    @Test
    public void postStudent() {
        // made this code reusable and using through Steps
        steps.createStudent(103,
                "Pragya",
                "Verma",
                TestUtils.randomValue() + "@domain.com",
                listOfCourses, "IT")
                .statusCode(201);
    }

    @Title("get all data")
    @Test
    public void getStudentData() {
        SerenityRest
                .given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200);
    }


    @Title("verify extraction of data")
    @Test
    public void getStudent() {

        //.rest is used to mention reports and logs
        HashMap<String, Object> value = steps.getStudentInfoByFirstName("Pragya");
        System.out.println("the value is " + value);
        assertThat(value, hasValue(firstName));
        studentId = (int) value.get("id");
        steps.logForSerenityReport("the id of student is" + value.get("id"));
    }


    @Title("update and verify data")
    @Test
    public void test003() {
        // a postr request
        firstName = firstName + "_updated";
        studentClass.setFirstName(firstName);
        studentClass.setEmail(TestUtils.randomValue() + "@domain.com");
        studentClass.setLastName("Verma");
        studentClass.setCourses(listOfCourses);
        studentClass.setId(101);
        studentClass.setProgramme("Comp");

        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(studentClass)
                .put("/" + studentClass.getId())
                .then()
                .statusCode(200);
    }


    @Title("delete a student")
    @Test
    public void testt004() {
        SerenityRest.given().when().delete("/" + studentClass.getId());

        SerenityRest.given().when().get("/" + studentClass.getId()).then().log().all().statusCode(404);
    }

    @Test
    public void getStudentsList() {
        Response response = RestAssured
                .given()
                .when()
                .get("/list");
        //to print in a string
        System.out.println(response.body().asString());
        //to print as in json form
        System.out.println(response.prettyPrint());

        // given().when().get("/list").then().assertThat().statusCode(200);
    }
}
