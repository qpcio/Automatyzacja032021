package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomepagePO extends BasePO {
    Logger logger = Logger.getLogger(HomepagePO.class);

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = "#block_top_menu>ul>li>[title=\"Women\"]")
    private WebElement womenTopMenu;

    @FindBy(xpath = "//a[@title='Dresses'][1]")
    private WebElement menuWomenDisplayed;

    @FindBy(css = "#homefeatured .product-container")
    private List<WebElement> allFeaturedProducts;

//    private By logo2 = By.cssSelector(".logo");
//
//    private By nthProduct(int n){
//        return By.cssSelector(""+n);
//    }



    private List<ProductMiniaturePO> getProductMiniatures(){
        List<ProductMiniaturePO> list = new ArrayList<>();
        for (WebElement e:allFeaturedProducts) {
            list.add(new ProductMiniaturePO(e,driver));
        }
        return list;
    }

    public double getNthPrice(int n){
        ProductMiniaturePO pm = getProductMiniatures().get(n-1);
        logger.info("Product "+pm.getProductName()+" costs $"+pm.getPrice());
        return pm.getPrice();
    }


    private String myURL = "http://automationpractice.com/index.php";

    public HomepagePO openWomenTopMenu(){
        logger.trace("Will try to move to "+womenTopMenu.getText());
        actions.moveToElement(womenTopMenu).build().perform();
        logger.trace("Moved to element "+womenTopMenu.getText());
        logger.trace("Will wait for visibility of "+menuWomenDisplayed.getText());
        wait.until(ExpectedConditions.visibilityOf(menuWomenDisplayed));
        logger.info("Opened Women Top Menu");
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
