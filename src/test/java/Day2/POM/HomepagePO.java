package Day2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomepagePO extends BasePO {

    @FindBy(css = ".logo")
    private WebElement logo;

    private String myURL = "http://automationpractice.com/index.php";


    public void openMe() {
        driver.get(myURL);
    }

    public boolean isDisplyed() {
        return logo.isDisplayed();
    }


    public HomepagePO(WebDriver driver) {
        super(driver);
    }


}
