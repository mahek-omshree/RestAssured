package Student;

import com.jayway.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;

public class StudentPost extends BaseInit {


    @Test
    public void  createAStudent(){
        List<String> studentCourse =new ArrayList<String>();
        studentCourse.add("Java");
        studentCourse.add("sql");
        studentCourse.add("python");

        StudentClass studentClass =new StudentClass();

        studentClass.setFirstName("Mahek");
        studentClass.setLastName("Omshree");
        studentClass.setEmail("mk@ogmail.com");
        studentClass.setProgramme("Computer Science");
        studentClass.setCourses(studentCourse);


      Response response=given().contentType(JSON).when().body(studentClass).post();
        System.out.println(response.prettyPeek());


    }}
