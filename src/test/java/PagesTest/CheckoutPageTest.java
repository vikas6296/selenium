package PagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutPageTest extends BaseTest {

    CheckoutPage cp = new CheckoutPage();

    @Test
    public void getShippingAddressTest()
    {
        Assert.assertTrue(cp.moveToCheckout());
    }

}
