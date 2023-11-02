package driver;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Listener extends BaseDriver implements ITestListener {

    private static int done = 0;
    private static int error = 0;
    private static int skip = 0;

    public void onTestStart(ITestResult result) {
        System.out.printf("In progress %s on %s\n", result.getTestClass(), getDriver().getCapabilities().getCapability("udid"));
    }

    public void onTestSuccess(ITestResult result) {
        done++;
        statisticPrint();
    }

    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        error++;
        statisticPrint();
        attach();
    }

    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        skip++;
        statisticPrint();
        attach();
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        error++;
        statisticPrint();
        attach();
    }

    public void statisticPrint() {
        System.out.println("-------------------------------------------------");
        System.out.println("Done: " + done + " Error: " + error + " Skip: " + skip);
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public void attach() {
        try {
            Allure.addAttachment("attachment", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

