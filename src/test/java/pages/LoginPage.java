package pages;

import Utilities.OperationUtil;
import org.openqa.selenium.By;

public class LoginPage extends BasePage
{
    private By signInButtononHomepage = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");

    private By usernameInputBox = By.xpath("//input[@type='email']");

    private By continueButton = By.xpath("//input[@id='continue']");

    private By passwordInput = By.xpath("//input[@type='password']");

    private By signInButton = By.xpath("//input[@id='signInSubmit']");

    public Homepage userSignIn()
    {
        OperationUtil.clickOpt(signInButtononHomepage);
        OperationUtil.sendKeys(usernameInputBox,properties.getProperty("username"));
        OperationUtil.clickOpt(continueButton);
        OperationUtil.sendKeys(passwordInput,properties.getProperty("password"));
        OperationUtil.clickOpt(signInButton);
        return new Homepage();
    }

}
