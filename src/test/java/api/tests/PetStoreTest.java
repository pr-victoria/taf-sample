package api.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.testng.Assert.assertFalse;

public class PetStoreTest extends BaseTest {

    @Test
    public void verifyPetFoundByStatus() {
        List<Object> pets = given()
                .contentType(ContentType.JSON)
                .when()
                .get("pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(""); // Извлекаем весь массив
        System.out.println(pets);
        assertFalse(pets.isEmpty(), "List of available pets is empty");
    }

    @Test
    public void verifyPetsSold() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200)
                .body("sold", greaterThan(0));
    }

}