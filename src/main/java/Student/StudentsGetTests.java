package Student;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class StudentsGetTests extends BaseInit{


    @Test
    public void getStudentsList() {
        Response response = RestAssured.given().when().get("/list");
        //to print in a string
        System.out.println(response.body().asString());
        //to print as in json form
        System.out.println(response.prettyPrint());

       // given().when().get("/list").then().assertThat().statusCode(200);
    }





}
