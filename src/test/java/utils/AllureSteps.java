package utils;

import driver.DriverSingleton;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureSteps {
   @Step("Capture screenshot (spoiler)")
   public static void screenshotSpoiler() {
       Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
               DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES)));
   }


   @Attachment(value = "Screenshot", type = "image/png")
   public static byte[] screenshot() {
       return ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
   }


   @Attachment(value = "HTML", type = "text/html")
   public static String sourceCode() {
       return DriverSingleton.getDriver().getPageSource();
   }
}
