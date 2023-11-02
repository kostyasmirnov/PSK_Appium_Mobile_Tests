package api.json.body.entity.response;

import api.json.body.Body;

public class ResponseLogin implements Body {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

// для чего в итоге этот класс?
