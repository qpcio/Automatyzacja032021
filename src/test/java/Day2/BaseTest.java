package Day2;

import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setLogging(){
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //do selenium grid byloby
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/"),options);


        logger.info("Chromedriver created");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
