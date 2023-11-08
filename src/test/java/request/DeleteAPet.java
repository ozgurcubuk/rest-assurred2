package request;

import objects.Pet;
import objects.PetCategory;
import objects.PetTags;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static objects.PetStatus.available;

public class DeleteAPet extends RequestBase {

    private final String path = "/pet/1234567899";
    private final String pathToPost = "/pet";
    private final String nonExistedPetInPath = "/pet/1234567891";

    @Test
    public void deleteAPet() {
            Pet petPayload = new Pet();
            PetCategory petCategory = new PetCategory();
            List<String> petPhotoUrls = new ArrayList<String>();
            petPhotoUrls.add("https://petphoto.com/image.png");
            PetTags petTags = new PetTags();
            List<PetTags> petTagsList = new ArrayList<PetTags>();

            petPayload.setId(1234567899);
            petCategory.setId(0);
            petCategory.setName("Dog");
            petPayload.setCategory(petCategory);
            petPayload.setName("Karabaş");
            petPayload.setPhotoUrls(petPhotoUrls);
            petTags.setId(0);
            petTags.setName("funnyDog");
            petTagsList.add(petTags);
            petPayload.setTags(petTagsList);
            petPayload.setStatus(available);

                given()
                        .spec(request)
                        .body(petPayload)
                .when()
                        .post(pathToPost)
                .then()
                        .statusCode(200)
                        .extract().as(Pet.class);

                given()
                        .spec(request)
                .when()
                        .delete(path)
                .then()
                        .statusCode(200);
    }

    @Test
    public void shouldNotDeleteNonExistedPet() {
            given()
                .spec(request)
            .when()
                .delete(nonExistedPetInPath)
            .then()
                .statusCode(404);
    }
}
