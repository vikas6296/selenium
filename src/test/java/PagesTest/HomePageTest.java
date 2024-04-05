package PagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

public class HomePageTest extends BaseTest {


    Homepage hp = new Homepage();

    @Test
    public void getHomePageTest() throws InterruptedException
    {
      Assert.assertTrue(hp.searchElement());
    }

    @Test
    public void getAllmoviesTest() throws InterruptedException
    {
        hp.getAllMovies();
    }



}
