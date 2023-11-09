package request;

import objects.Pet;
import objects.PetCategory;
import objects.PetTags;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static objects.PetStatus.available;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class PostPetTest extends RequestBaseTest {

    private final String path = "/pet";

    @Test
    public void createPetHappyPath() {
        Pet petPayload = new Pet();
        PetCategory petCategory = new PetCategory();
        List<String> petPhotoUrls = new ArrayList<String>();
        petPhotoUrls.add("https://petphoto.com/image.png");
        PetTags petTags = new PetTags();
        List<PetTags> petTagsList = new ArrayList<PetTags>();

        petPayload.setId(1234567890);
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

        Pet petResponse =
                given()
                        .spec(request)
                        .body(petPayload)
                .when()
                        .post(path)
                .then()
                        .statusCode(200)
                        .extract().as(Pet.class);

        assertFalse(petResponse.getName().isEmpty());
        assertNotNull(petResponse.getId());
    }
}
