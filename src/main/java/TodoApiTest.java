import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TodoApiTest {
    private static String baseURL;
    private static String username;
    private static String password;


    @BeforeClass
    public void setup(){
        baseURL= "api/v1";
        username="userName";
        password="password";
    }

    @Test
    private void postSignupTest(){
        Response response = RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.createUserPayload(12345,"email","password",
                        System.currentTimeMillis(),System.currentTimeMillis()+30))
                .auth().basic(username,password).when().get("api/v1/signup").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }

    @Test
    private void postSigninTest(){
        Response response = RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.createUserPayload(12345,"email","password"))
                .auth().basic(username,password).when().get("api/v1/signin").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }

    @Test
    private void putChangePasswordTest(){
        Response response = RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.createUserPayload(12345,"email","new password",
                        System.currentTimeMillis(),System.currentTimeMillis()+30))
                .auth().basic(username,password).when().get("api/v1/changePassword").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }

    @Test
    private void getTodosTest(){
        Response response= RestAssured.given().auth().basic(username,password).when().get("api/v1/todos?status=[NotStarted]");
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }

    @Test
    private void postTodosTest(){
        Response response = RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.createTodoPayload
                        (12345,"book","description",54321,System.currentTimeMillis(),System.currentTimeMillis()+20,"OnGoing"))
                .auth().basic(username,password).when().get("api/v1/todos").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }

    @Test
    private void putTodosTest(){
        Response response = RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.createTodoPayload
                        (12345,"new book","new description",54321,System.currentTimeMillis(),System.currentTimeMillis()+20,"OnGoing"))
                .auth().basic(username,password).when().get("api/v1/todos/:id").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals("responses code",response.getStatusCode());
    }


}
