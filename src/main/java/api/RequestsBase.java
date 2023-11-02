package api;

import api.json.Actions;
import api.json.body.entity.Login;

import java.util.Map;


public class RequestsBase {

    private final Requests requests;
    private final String login;
    private final String password;

    public RequestsBase(String login, String password) {
        this.requests = new Requests("https://10.194.176.235/backend/");
        this.login = login;
        this.password = password;
    }

    public String request(Actions action, Map<String, String> data) {
        switch (action.name()) {
            case "LOGIN":
                Login l = new Login(password, login);
                return requests.getLogin(l);
                case "CREATE_TASK"
            default:
                return "fuck";
        }
    }
}