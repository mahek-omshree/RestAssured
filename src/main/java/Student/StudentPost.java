package Student;


import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.given;

public class StudentPost extends BaseInit {

    @Test
    public void  createAStudent(){
        List<String> studentCourse =new ArrayList<String>();
        studentCourse.add("Java");
        studentCourse.add("sql");
        studentCourse.add("python");

        StudentClass studentClass =new StudentClass();
        studentClass.setId(101);
        studentClass.setFirstName("Mahek");
        studentClass.setLastName("Omshree");
        studentClass.setEmail("mk@ogmail.com");
        studentClass.setProgramme("Computer Science");
        studentClass.setCourses(studentCourse);


     Response response=given().contentType(JSON).when().body(studentClass).post();
       System.out.println(response.prettyPeek());

    }}
