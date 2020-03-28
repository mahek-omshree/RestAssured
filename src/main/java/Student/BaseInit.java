package Student;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;

import org.junit.BeforeClass;


import static net.serenitybdd.rest.SerenityRest.given;

public class BaseInit {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/student";
    }

    @AfterClass
    public static void printStudentList() {
        Response response = given().when().get("/list");
        System.out.println(response.prettyPeek());
    }

}
