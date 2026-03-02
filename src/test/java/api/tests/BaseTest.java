package api.tests;

import api.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class BaseTest {
    @BeforeClass
    public void setup() {
        login();
    }

    public static User createUser() {
        final int UID = (int) (System.currentTimeMillis() / 1000);
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.proxy = host("14.56.107.244").withPort(3128); // https://free-proxy-list.net/en/

        User newUser = User.builder()
                .id(UID)
                .firstName("Test")
                .lastName("User" + UID)
                .username("testuser_" + UID)
                .email("test_" + UID + " @example.com")
                .password("123456")
                .phone("123-456-7890")
                .userStatus(1)
                .build();

            given()
                    .log().all()
                .contentType(ContentType.JSON)
                .body(newUser)
            .when()
                .post("/user")
            .then()
                .statusCode(200);
            return newUser;
    }

    public static void login() {
        User newUser = createUser();
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/user/login?username=" + newUser.getUsername() + "&password=" + newUser.getPassword())
                .then()
                .statusCode(200);
    }
}
