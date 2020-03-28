package Student;

import org.junit.Test;

import static net.serenitybdd.rest.SerenityRest.given;

public class StudentDelete extends BaseInit{

    @Test
    public void deleteStudent(){
        given().when().delete("/103").then().assertThat().statusCode(204);
    }
}
