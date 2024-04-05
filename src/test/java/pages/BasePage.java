package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    protected static Properties properties = null;

    public static String browser;

    public static String baseURL;
    protected static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    public static void webdriverInit(String browser)
    {

        if(browser.contains("chrome"))
        {

            WebDriver driver = WebDriverManager.chromedriver().create();
            threadDriver.set(driver);
            getWebdriver().manage().window().maximize();
            getWebdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

        else if(browser.contains("firefox"))
        {
            WebDriver driver = WebDriverManager.firefoxdriver().create();
            threadDriver.set(ThreadGuard.protect(driver));

            getWebdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            getWebdriver().manage().window().maximize();

        }
        else  if (browser.contains("egde"))
        {
            WebDriver driver = WebDriverManager.edgedriver().create();
            threadDriver.set(ThreadGuard.protect(driver));

            getWebdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            getWebdriver().manage().window().maximize();

        }


    }


    public static WebDriver getWebdriver()
    {

        return threadDriver.get() ;

    }

    public static void tearDown()
    {
        getWebdriver().close();
    }

    public boolean gotoHomePage(String browser,String baseURL)
    {
        try
        {

            loadProperties();
            webdriverInit(browser);
            getWebdriver().get(baseURL);

        }

        catch (Exception e)
        {
            System.out.println("unable to redirect to homepage");
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public synchronized void loadProperties()
    {
        FileInputStream file = null;

        try
        {

            properties = new Properties();
            file = new FileInputStream("C:\\Users\\vikas.kumar5\\Downloads\\SeleniumAutomationFramework\\src\\test\\java\\Resources\\Config.Properties");
            properties.load(file);

            browser = properties.getProperty("browser");
            baseURL = properties.getProperty("baseURL");

        }
        catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
        finally {
            try{
                file.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }



    public void takeScreenshot(WebDriver driver,String fileWithPath) throws IOException {

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File(fileWithPath);

        FileUtils.copyFile(SrcFile, DestFile);
    }

}
