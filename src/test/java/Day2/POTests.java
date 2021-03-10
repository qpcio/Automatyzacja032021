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

        homepagePO
                .openMe()
                .openWomenTopMenu();

        boolean wynik = homepagePO.isDisplyed();


        Assert.assertTrue(wynik);
    }

    @Test
    public void priceOfFirstProductTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        double expectedPrice = 16.51;

        //when
        double result = homepagePO
                .openMe()
                .getNthPrice(1);

        //then
        Assert.assertEquals(result,expectedPrice);
    }



}
