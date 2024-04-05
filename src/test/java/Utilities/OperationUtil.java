package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static pages.BasePage.getWebdriver;

public class OperationUtil {

    public static void clickOpt(By by)
    {
        getWebdriver().findElement(by).click();
    }

    public static String getText(By by)
    {

        return getWebdriver().findElement(by).getText();
    }
    public static int getAmount(By by)
    {
        String amount =  getWebdriver().findElement(by).getText();
        amount = amount.replace(",","");
        double b = Double.parseDouble(amount);
        return (int) b;
    }
    public static void clickToWebElement(WebElement w)
    {
        w.click();
    }


    public static String getTextFromList(WebElement w)
    {

        return w.getText();
    }

    public static int getAmountFromList(WebElement w)
    {

        String amount=  w.getText();
        return Integer.parseInt(amount);
    }
    public static int getTrimmedAmountFromList(WebElement w)
    {

        String amount=  w.getText();
        amount = amount.replace(",","");
        double b = Double.parseDouble(amount);
        return (int)b;
    }



    public static void sendKeys(By by,String text)
    {
        getWebdriver().findElement(by).sendKeys(text);
    }

    public static List<WebElement> getAllELements(By by)
    {
        return getWebdriver().findElements(by);
    }


    public static void moveToDifferentTab()
    {
        String parentWindow = getWebdriver().getWindowHandle();
        System.out.println("parent window--> "+parentWindow);
        Set<String> activeWindows = getWebdriver().getWindowHandles();


        List<String> li = new ArrayList<>(activeWindows);
        System.out.println("window list --> "+li);

        for(String s : li ) {
            if (!s.equalsIgnoreCase(parentWindow)) {
                getWebdriver().switchTo().window(s);
                break;
            }
            System.out.println("switched to new window");
        }
    }


    public static void handleDropDown(By by,String text)
    {
        Select dropDown = new Select(getWebdriver().findElement(by));
        dropDown.selectByVisibleText(text);
    }
}
