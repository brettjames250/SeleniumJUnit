package bjss.shorttechtest.testframework;

import bjss.shorttechtest.testframework.pageobjects.APITestBase;
import bjss.shorttechtest.testframework.reportutils.TestListener;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners({TestListener.class})
public class APITest extends APITestBase {

    private String userId;

    @Test(priority = 3, description = "Create a user and verify a successful response")
    public void createUserThroughAPI() {


        User user = new User();
        user.setName("Test" + getRandomString());
        user.setSalary("123");
        user.setAge("23");

        Response createdUser =
                given().spec(requestSpec).body(user).when().post(Resources.createResource()).
                        then().statusCode(200).extract().response();

        String responseString = createdUser.asString();
        JsonPath js = new JsonPath(responseString);
        userId = js.get("id");



    }

    @Test(priority = 4, description = "Get all employee data")
    public void retrieveAllEmployees() {

        simpleGetTest(Resources.employee()+ "s");


    }

    @Test(priority = 5, description = "Get a single employee data")
    public void retrieveCreatedEmployee() {

        simpleGetTest(Resources.employee()+ "/" + userId);


    }

    @Test(priority = 6, description = "Delete an employee record")
    public void deleteCreatedEmployee() {

        simpleDeleteTest(Resources.deleteResource() + userId);


    }


}
