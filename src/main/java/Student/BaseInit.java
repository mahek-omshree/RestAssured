package Student;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BaseInit {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 5050;
        RestAssured.basePath = "/student";
    }

    @AfterClass
    public static void printStudentList() {
        Response response = given().when().get("/list");
        System.out.println(response.prettyPeek());
    }

}
