package Student;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;


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
