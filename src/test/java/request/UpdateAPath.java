package request;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateAPath extends RequestBase {

    private final String path = "/pet/1234567890";
    private final String pathWithNonExistedPetId = "/pet/1234567891";

        @Test
        public void updateAPet() {
            given()
                    .spec(requestWithFormData)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8")
                    .formParam("name", "test")
                    .formParam("status", "available")
            .when()
                    .post(path)
            .then()
                    .statusCode(200)
                    .body("code", equalTo(200))
                    .body("type", equalTo("unknown"))
                    .body("message", equalTo("1234567890"));
        }

    @Test
    public void shouldNotUpdateWithNonExistedPetId() {
            given()
                .spec(requestWithFormData)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", "test")
                .formParam("status", "available")
            .when()
                .post(pathWithNonExistedPetId)
            .then()
                .statusCode(404)
                .body("code", equalTo(404))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("not found"));
    }

    @Test
    public void shouldNotUpdateWithUnSupportedMediaType() {
            given()
                .spec(requestWithFormData)
                .contentType("application/json")
                .formParam("name", "test")
                .formParam("status", "available")
            .when()
                .post(path)
            .then()
                .statusCode(415);
    }
}
