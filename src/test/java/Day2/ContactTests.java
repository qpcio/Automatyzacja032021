package Day2;

import Day2.POM.ContactUsPO;
import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends BaseTest{

    // homepage -> contact us - sprawdzenie zaladowania potrzebnych elementow
    // homepage -> contact us - wyslanie wiadomosci
    // homepage -> contact us - wyslanie wiadomosci drugiego typu (cust service / webmaster)

    @Test
    public void openingContactFormTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);

        //when
        boolean result = homepagePO
                .openMe()
                .openContact()
                .isSubmitButtonDisplayed();

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void verifyIfContactFormHasAllFieldsVisibleAndEnabledTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactUsPO contactPO = new ContactUsPO(driver);
        //given
        homepagePO.openMe().openContact();
        //when
        contactPO.contactFormIsDisplayed();
        //then
        Assert.assertTrue(contactPO.sendMsgButtonIsDisplayed());
        Assert.assertTrue(contactPO.emailIsDisplayed());
        Assert.assertTrue(contactPO.messageIsDisplayed());
        Assert.assertTrue(contactPO.subjectIsDisplayed());
    }

  

}
