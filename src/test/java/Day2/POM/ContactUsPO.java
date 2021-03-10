package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPO extends BasePO{
    Logger logger = Logger.getLogger(ContactUsPO.class);
    // Form
    @FindBy(css = ".row")
    private WebElement contactForm;

    @FindBy(id = "id_contact")
    private Select subjectHeading;

    //todo List?

    @FindBy(id = "uniform-id_contact")
    private WebElement subject;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(id = "submitMessage")
    private WebElement sendMsgButton;

    @FindBy(css = ".alert-success")
    private WebElement success;
    
    @FindBy(id = "submitMessage")
    private WebElement submitButtonChanged;

    public boolean isSubmitButtonDisplayed(){
        logger.trace("Will check if "+ submitButtonChanged +" is displayed");
        return submitButtonChanged.isDisplayed();
    }


    public ContactUsPO(WebDriver driver) {
        super(driver);
    }

    public boolean contactFormIsDisplayed() {
        logger.trace("contactFormIsDisplayed " + contactForm);
        return contactForm.isDisplayed();
    }

    public boolean subjectIsDisplayed() {
        logger.trace("subjectIsDisplayed " + subject);
        return subject.isDisplayed();
    }

    public boolean emailIsDisplayed() {
        logger.trace("emailIsDisplayed " + email);
        return email.isDisplayed();
    }

    public boolean messageIsDisplayed() {
        logger.trace("messageIsDisplayed " + message);
        return message.isDisplayed();
    }

    public boolean sendMsgButtonIsDisplayed() {
        logger.trace("sendMsgButtonIsDisplayed " + sendMsgButton);
        return sendMsgButton.isDisplayed();
    }

    public boolean successIsDisplayed() {
        logger.trace("successIsDisplayed " + success);
        wait.until(ExpectedConditions.visibilityOf(success));
        return success.isDisplayed();
    }

    public ContactUsPO selectHeading(String value) {
        logger.trace("selectHeading " + value);
        subjectHeading.selectByValue(value);
        return this;
    }

    public ContactUsPO typeEmailAddress(String emailAddress) {
        logger.trace("typeEmail " + emailAddress);
        email.sendKeys(emailAddress);
        return this;
    }

    public ContactUsPO sendMessage(String msg) {
        logger.trace("sendMessage " + msg);
        success.sendKeys(msg);
        sendMsgButton.click();
        return this;
    }
 

}
