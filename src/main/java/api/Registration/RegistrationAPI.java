package api.Registration;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RegistrationAPI {
    private static String endPoint = "https://reqres.in/api/register";

    public static RegistrationResponse getRegistration() {
        RegistrationResponse response = null;
        RegistrationDetails register = new RegistrationDetails();
        while (response == null) {
            try {
                response = given().contentType(ContentType.JSON).
                        body(register).post(endPoint).as(RegistrationResponse.class);
            } catch (Exception ex) {

            }
        }
        return response;
    }
}
