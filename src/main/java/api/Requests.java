package api;

public class Requests {

    private  String url = "";

    public Requests(String url) {
        this.url = url;
    }

    public String getLogin(Body body) {
        RestAssured.baseURL = url;
        String json = "";
        Response response = RestAssured.given();
    }
}
