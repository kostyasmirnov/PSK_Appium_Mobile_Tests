package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {

    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public void setDriver(String url, String platformName, String automationName, String deviceName, String udid, String platformVersion ) {
        try {
            driver.set(new AndroidDriver(new URL(url), getCapabilities(platformName, automationName, deviceName, udid, platformVersion)));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    private UiAutomator2Options getCapabilities(String platformName, String automationName, String deviceName, String udid, String platformVersion) {
        UiAutomator2Options option = new UiAutomator2Options();
        option.setCapability("enforceXPath1", true);
        option.setCapability("allowInvisibleElements", true);
        option.setCapability("ignoreUnimportantViews", false);
        option.setCapability("autoAcceptAlerts", true);
        option.setCapability("unicodeKeyboard", true);
        option.setCapability("resetKeyboard", true);
        return option.setPlatformName(platformName)
                .setAutomationName(automationName)
                .setAdbExecTimeout(Duration.ofSeconds(40))
                .setAndroidInstallTimeout(Duration.ofSeconds(40))
                .setDeviceName(deviceName)
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setEnforceAppInstall(true)
                .autoGrantPermissions();
    }

    public void closeSession() {
        getDriver().quit();
    }
}

