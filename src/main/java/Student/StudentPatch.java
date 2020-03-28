package Student;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.given;

public class StudentPatch extends BaseInit {

    @Test
    public void alterEmailId(){

        StudentClass student =new StudentClass();
        student.setEmail("omshree@gmail.com");
         Response patchResponse = given().contentType(JSON).when().body(student).patch("/101");
        //System.out.println(patchResponse.prettyPeek());
    }

}

