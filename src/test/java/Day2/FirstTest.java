package Day2;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void browserIsStartedTest(){
        
        driver.get("http://automationpractice.com/");

//        List<WebElement> listaElementow = driver
//                .findElements(By.cssSelector("takiego_nie_ma"));
//        WebElement element = driver
//                .findElement(By.cssSelector("takiego_nie_ma"));



        WebElement element =
                driver.findElement(By.id("contact-link"));
        System.out.println(element.isDisplayed());
        element.click();

        Assert.assertTrue(driver
                .findElement(By.cssSelector("#submitMessage"))
        .isDisplayed());
        Select select = new Select(driver.findElement(By.id("id_contact")));
        select.selectByValue("2");

        driver.findElement(By.id("email")).sendKeys("test@test.com");
        //--------------------------
        driver.findElement(By.id("id_order")).sendKeys("123");
        //dodanie pliku do upload -> sendkeys("sciezka bezwzgledna do pliku - home tam gdzie pom)
        driver.findElement(By.id("message")).sendKeys("TEST");
        driver.findElement(By.id("submitMessage")).click();
        Assert.assertTrue(driver
                .findElement(By.cssSelector(".alert-success"))
                .isDisplayed());

        //driver.close();

    }


    @Test
    public void waitingTest(){

    }


    


}
