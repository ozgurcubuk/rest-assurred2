package request;

import objects.Pet;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class GetAPetTest extends RequestBaseTest {

    private final String path = "/pet/1234567890";
    private final String nonExistedPetInPath = "/pet/1234567891";

    @Test
    public void getAPet() {
        Pet petResponse =
                given()
                        .spec(request)
                .when()
                        .get(path)
                .then()
                        .statusCode(200)
                        .extract().as(Pet.class);

        assertFalse(petResponse.getName().isEmpty());
        assertEquals(petResponse.getId(), 1234567890);
    }

    @Test
    public void shouldNotGetNonExistedPet() {
                given()
                        .spec(request)
                .when()
                        .get(nonExistedPetInPath)
                .then()
                        .statusCode(404)
                        .body("type", equalTo("error"))
                        .body("message", equalTo("Pet not found"));
    }
}
