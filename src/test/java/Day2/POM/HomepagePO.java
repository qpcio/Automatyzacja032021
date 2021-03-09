package Day2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomepagePO extends BasePO {

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = "#block_top_menu>ul>li>[title=\"Women\"]")
    private WebElement womenTopMenu;

    @FindBy(xpath = "//a[@title='Dresses'][1]")
    private WebElement menuWomenDisplayed;

    private String myURL = "http://automationpractice.com/index.php";

    public HomepagePO openWomenTopMenu(){
        actions.moveToElement(womenTopMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(menuWomenDisplayed));
        return this;
    }

    public boolean isWomenMenuDisplayed(){
        return menuWomenDisplayed.isDisplayed();
    }

    public HomepagePO openMe() {
        driver.get(myURL);
        return this;
    }

    public boolean isDisplyed() {
        return logo.isDisplayed();
    }

    public HomepagePO(WebDriver driver) {
        super(driver);
    }


}
