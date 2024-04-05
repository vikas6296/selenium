package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BasePage.getWebdriver;

public class WaitUtil {

    public static WebElement setWebDriverWaitForPresenceOfElementLocated(Duration d,By by)
    {
        return  new WebDriverWait(getWebdriver(), Duration.ofSeconds(d.getSeconds())).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement setWebDriverWaitForvisibilityOfElementLocated(Duration d,By by)
    {
        return  new WebDriverWait(getWebdriver(), Duration.ofSeconds(d.getSeconds())).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement setWebDriverWaitForElementToBeClickable(Duration d,By by)
    {
            return  new WebDriverWait(getWebdriver(), Duration.ofSeconds(d.getSeconds())).until(ExpectedConditions.elementToBeClickable(by));
    }


    public static Alert setWebDriverWaitForAlertIsPresent(Duration d, By by)
    {
        return  new WebDriverWait(getWebdriver(), Duration.ofSeconds(d.getSeconds())).until(ExpectedConditions.alertIsPresent());
    }


}
