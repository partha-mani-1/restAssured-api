package api.Logon;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class LoginSuccessfulAPI {

    private static String endPoint = "https://reqres.in/api/login";

    public static LoginResponse getToken() {

        UserLogonDetails logon = new UserLogonDetails();
        LoginResponse response = null;
        while (response == null) {
            try {
                response = given().contentType(ContentType.JSON).body(logon).post(endPoint).as(LoginResponse.class);
            } catch (Exception ex) {

            }
        }
        return response;
    }

}
