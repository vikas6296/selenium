package pages;

import Utilities.OperationUtil;
import Utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

import static pages.BasePage.properties;

public class CheckoutPage
{
  private By proceedToBuyButton = By.xpath("//*[@name='proceedToRetailCheckout']");

  private By addNewAddressbutton = By.xpath("//a[@id='add-new-address-popover-link']");

  private By firstName = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']");

  private By mobileNumber = By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']");

  private By pincode = By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']");

  private By flatNo = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']");

  private By Area = By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']");

  private By landmark = By.xpath("//input[@id='address-ui-widgets-landmark']");

  private By town = By.xpath("//input[@id='address-ui-widgets-enterAddressCity']");

  private By chooseState = By.xpath("//select[@name='address-ui-widgets-enterAddressStateOrRegion']");

  private By useThisAddressbutton = By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']");

  private By useThisAddressButtn = By.xpath("//input[@data-testid='Address_selectShipToThisAddress']");

  private By getDeliveryAddress = By.xpath("//li[@class='displayAddressLI displayAddressAddressLine1']");

  private By useThisAddress = By.xpath("//span[@id='address-ui-widgets-form-submit-button-announce']");
  Homepage page = new Homepage();
  public boolean moveToCheckout()
  {
    page.moveToPdp();
    OperationUtil.clickOpt(proceedToBuyButton);
    OperationUtil.clickOpt(addNewAddressbutton);
    OperationUtil.sendKeys(firstName,properties.getProperty("firstName"));
    OperationUtil.sendKeys(mobileNumber,properties.getProperty("mobileNumber"));
    OperationUtil.sendKeys(pincode,properties.getProperty("pincode"));
    OperationUtil.sendKeys(flatNo,properties.getProperty("flatNo"));
    OperationUtil.sendKeys(Area,properties.getProperty("Area"));
    final String deliveryAddress = properties.getProperty("flatNo");
    WebElement w = WaitUtil.setWebDriverWaitForElementToBeClickable(Duration.ofSeconds(10),useThisAddressbutton);
    OperationUtil.clickToWebElement(w);
    //OperationUtil.clickOpt(useThisAddressbutton);

    System.out.println("Flat Address enterted while adding new address  --> "+deliveryAddress );
    final String deliveryAddressFromCheckoutPage = OperationUtil.getText(getDeliveryAddress);
    System.out.println("shipping address for the order on checkout page for delivery --> "+deliveryAddressFromCheckoutPage);

    Assert.assertTrue(deliveryAddress.contains(deliveryAddressFromCheckoutPage));
    System.out.println("succesfully validated the the current shipping address for the order ...");

    return true;


  }

}
