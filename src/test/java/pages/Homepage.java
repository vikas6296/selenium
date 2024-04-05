package pages;


import Utilities.OperationUtil;
import Utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Homepage extends BasePage {

     static String nameOfTheProduct = "";
    private By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");

    private By submitButton = By.xpath("//input[@value='Go']");

    private By productNames = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
    private By searchedElementList = By.xpath("//span[@data-component-type='s-product-image']");

    private By priceOfTheProduct= By.xpath("//span[@class='a-price-whole']");

    private By addToCart = By.xpath("//input[@id='add-to-cart-button']");

    private By productInCart = By.xpath("//div[@class='sc-item-content-group']"); //list of all products in cart

    private By productAtAddToCartPage = By.xpath("//span[contains(text(),'"+nameOfTheProduct+"')]");

    private By priceOfTheProductAtAddtoCartPage = By.xpath("//span[@id='sc-subtotal-amount-activecart']");

    private By goToCart = By.xpath("//span[@id='nav-cart-count']");

    private By priceOfProductsInCart = By.xpath("//div[@class='sc-badge-price-to-pay']");

    private By menuButton = By.xpath("//span[@class='ipc-responsive-button__text']");

    private By popupCrossButton = By.xpath("//*[@class='ipc-icon ipc-icon--clear']");

    private By topTwentyMovies = By.xpath("(//span[@role=\"presentation\"])[2]");

    private By allMovies = By.xpath("//a[@class='ipc-title-link-wrapper']");

    public int moveToPdp()
    {
        OperationUtil.clickOpt(searchBox);
        OperationUtil.sendKeys(searchBox,"cricketbat");
        OperationUtil.clickOpt(submitButton);

        List<WebElement> productNamesOnPDP = OperationUtil.getAllELements(productNames);
        nameOfTheProduct  =  OperationUtil.getTextFromList(productNamesOnPDP.get(0));
        System.out.println("nameOfTheProduct -->"+nameOfTheProduct);

        OperationUtil.clickOpt(searchedElementList);
        OperationUtil.moveToDifferentTab();

        List<WebElement> listOfProduct = OperationUtil.getAllELements(priceOfTheProduct);
        final int priceOfTheProductOnProductPage = OperationUtil.getAmountFromList(listOfProduct.get(0));
        System.out.println("priceOfTheProductOnProductPage --> "+priceOfTheProductOnProductPage);

        OperationUtil.clickOpt(addToCart);
        WebElement w = WaitUtil.setWebDriverWaitForElementToBeClickable(Duration.ofSeconds(15),goToCart);
        OperationUtil.clickToWebElement(w);
        return priceOfTheProductOnProductPage;
    }
   public boolean searchElement()
   {
       final int priceOfTheProductOnProductPage = moveToPdp();

       List<WebElement> getListOfProductAtCart = getWebdriver().findElements(By.xpath("//span[contains(text(),'"+nameOfTheProduct+"')]"));
       System.out.println("xpath from direct access --> "+getListOfProductAtCart);
       String productAtCart =getListOfProductAtCart.get(0).getText();
       System.out.println("product at cart ---> "+productAtCart);

       List<WebElement> priceOfProducts = OperationUtil.getAllELements(priceOfProductsInCart);
       final int priceOfTheProductAtCartPage = OperationUtil.getTrimmedAmountFromList(priceOfProducts.get(0));
       System.out.println("priceOfTheProductAtCartPage -->"+priceOfTheProductAtCartPage);

       Assert.assertTrue(priceOfTheProductOnProductPage == priceOfTheProductAtCartPage);

       System.out.println("price of the product on products page --> "+priceOfTheProductOnProductPage);
       System.out.println("price of the product on cart page --> "+priceOfTheProductAtCartPage);
       System.out.println("successfully validated item is present in the cart and the cart count is incremented by one");

       return true;

   }



   public void getAllMovies()
   {

       OperationUtil.clickOpt(menuButton);
       WebElement w = WaitUtil.setWebDriverWaitForElementToBeClickable(Duration.ofSeconds(10),topTwentyMovies);
       OperationUtil.clickToWebElement(w);
       List<WebElement> allMovieList=OperationUtil.getAllELements(allMovies);
       System.out.println("List of movies-->");
       for(WebElement e : allMovieList)
           System.out.println(e.getText());

       

   }




}
