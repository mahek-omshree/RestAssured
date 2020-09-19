package Student;

import com.jayway.restassured.path.json.config.JsonPathConfig;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;

public class StudentPatch extends BaseInit {

    @Test
    public void alterEmailId(){

        StudentClass student =new StudentClass();
        student.setEmail("omshree@gmail.com");
         Response patchResponse = given().contentType(JSON).when().body(student).patch("/101");
        //System.out.println(patchResponse.prettyPeek());

   List courseList=patchResponse.jsonPath().getList("Courses[0]");
        System.out.println(courseList); }

}

