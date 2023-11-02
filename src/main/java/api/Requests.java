package api;

import api.json.body.Body;
import api.json.body.entity.response.ResponseLogin;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;


public class Requests {

    private String url = "";

    public Requests(String url) {
        this.url = url;
    }

    public String getLogin(Body body) {
        RestAssured.baseURI = url;
        String json = "";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("DeviceType", "web")
                .body(body)
                .when()
                .post("//login")
                .then()
                .statusCode(200)
                .extract()
                .response();
        try {
            json = response.jsonPath().getString("AccessToken");
        } catch (JsonPathException e) {
            System.out.printf("Value \"AccessToken\" in Json not found in %s", response.body().print());
        }
        return String.valueOf(response.getBody().as(ResponseLogin.class)); //точно ли токен сохрнаиться
    }


    public String getCreateTask(Body body) {
        RestAssured.baseURI = url;
        String json = "";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token) //как передать сюда токен?
                .header("DeviceType", "web")
                .body("{\"query\":\"mutation TasksBulkReturnFromMobile($id: [ID!]!) {\\n  TasksBulkReturnFromMobile(ID: $id)\\n}\",\"variables\":{\"id\":[\"4dd91832-0b3e-43db-b0a1-0eb59cd0645c\"]}}")
                .when()
                .post("//graphql")
                .then()
                .statusCode(200)
                .extract().response();
        try {
            json = response.jsonPath().getString("ID");
        } catch (JsonPathException e) {
            System.out.printf("Value \"token\" in Json not found in %s", response.body().print());
        }
        return json;
    }

}
