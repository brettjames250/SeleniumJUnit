package bjss.shorttechtest.testframework.pageobjects;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class APITestBase {

    public static ResponseSpecification responseSpec;
    public static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp()  {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";


        requestSpec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                build();

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();


    }


    protected Response simpleGetTest(String resource) {
        return given()
                .spec(requestSpec)
                .when()
                .get(resource)
                .then().spec(responseSpec)
                .extract()
                .response();
    }

    protected Response simpleDeleteTest(String resource) {
        return given()
                .spec(requestSpec)
                .when()
                .delete(resource)
                .then().spec(responseSpec)
                .extract()
                .response();



    }


    protected String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String nameString = salt.toString();
        return nameString;

    }
}
