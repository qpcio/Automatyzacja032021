package Day2;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Ignore
    @Test
    public void browserIsStartedTest() {

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
    public void waitingTest() {
        //wejsc na https://swiatroweru.com.pl/warsztat/seminariumStronka/
        //kliknac na guzik sekcji 4
//        asercja na wyswietlenie zdjecia

        //wait max time na findElement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement guzik = driver.findElement(By.cssSelector("[data-section]+section button"));
        //czekanie na konkretny stan elementu
        //wait.until(ExpectedConditions.elementToBeClickable(guzik));
        //guzik.click();
        waitAndClick(guzik);
        WebElement obrazek = driver.findElement(By.tagName("img"));
        wait.until(ExpectedConditions.visibilityOf(obrazek));
        Assert.assertTrue(obrazek.isDisplayed());
    }

    public void waitAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//        wait.until(ExpectedConditions.stalenessOf()); czekanie na znikniecie elementu
    }

    @Test
    public void alertsTest(){
        //given
        int licznik = 4;

        //when
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");
        WebElement guzikS3 = driver.findElement(By.cssSelector("[data-section] button"));
        for (int i = 0; i < licznik; i++) {
            guzikS3.click();
            Alert alert = driver.switchTo().alert();
            alert.dismiss();  //.accept();
        }

        //then
        List<WebElement> rowy = driver.findElements(By.cssSelector(".row"));
        Assert.assertEquals(rowy.size(),licznik);
    }

    @Test
    public void testDragAndDrop() {
        //given
        Actions actions = new Actions(driver);
        //when
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement coPrzeciagamy = driver.findElement(By.cssSelector("[data-id=\"2\"]"));
        WebElement dokad = driver.findElement(By.id("amt7"));
        actions.dragAndDrop(coPrzeciagamy,dokad).build().perform();
        //then
        Assert.assertTrue(driver.findElement(By.cssSelector("#amt7>[data-id=\"2\"]")).isDisplayed());
    }
}
