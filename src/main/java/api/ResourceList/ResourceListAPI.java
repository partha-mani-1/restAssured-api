package api.ResourceList;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ResourceListAPI {
    private static String endPoint = "https://reqres.in/api/unknown";

    public static ResourceResponse getResourceList() {
        ResourceResponse response = null;
        ResourceDetails details = new ResourceDetails();
        while (response == null) {
            try {
                response = given().contentType(ContentType.JSON).
                        body(details).post(endPoint).as(ResourceResponse.class);
            } catch (Exception ex) {

            }
        }
        return response;
    }
}
