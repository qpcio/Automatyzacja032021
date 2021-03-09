package Day2;

import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POTests extends BaseTest{

    @Test
    public void firstPOTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        boolean wynik = homepagePO
                .openMe()
                .isDisplyed();
        //then
        Assert.assertTrue(wynik);
    }

    //Zadanie:
    // Najechac na Women
    // sprawdzic, ze wyswietla sie podmenu

    @Test
    public void womenMenuTest(){
        HomepagePO homepagePO = new HomepagePO(driver);

        boolean wynik = homepagePO
                .openMe()
                .openWomenTopMenu()
                .isWomenMenuDisplayed();

        Assert.assertTrue(wynik);
    }


}
