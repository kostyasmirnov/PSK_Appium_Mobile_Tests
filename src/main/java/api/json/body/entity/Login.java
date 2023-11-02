package api.json.body.entity;

import api.json.body.Body;

public class Login implements Body {

    //private String appVersion = "";
    private String deviceId = "9923f40e2da972a9";
    private String deviceType = "mobile";
    private String password = "Testik12!#";
    private String userName = "testik19";

    public Login(String password, String userName){
        this.password = password;
        this.userName = userName;
//        this.deviceType = deviceType;
//        this.deviceId = deviceId;
    }

//    public void setAppVersion(String appVersion) {
//        this.appVersion = appVersion;
//    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getAppVersion() {
//        return appVersion;
//    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
