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
        homepagePO.openMe();
        //then
        Assert.assertTrue(homepagePO.isDisplyed());
    }

    //Zadanie:
    // Najechac na Women
    // sprawdzic, ze wyswietla sie podmenu


}
