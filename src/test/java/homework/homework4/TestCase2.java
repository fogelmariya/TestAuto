package homework.homework4;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.DataPagehw4;
import pageObject.HomePagehw4;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;


public class TestCase2 {

    private HomePagehw4 homePage;
    private DataPagehw4 dataPagehw4;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        homePage = page(HomePagehw4.class);
        dataPagehw4 = page(DataPagehw4.class);
    }

    @AfterTest
    public void tearDown(){
        close();
    }

    @Test
    public void DataServiceTest(){
        //1 Open test site by URL
        homePage.openSite();

        //2 Perform login
        homePage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName("PITER CHAILOVSKII");

        //4 Open Service -> Dates
        homePage.openServiceDates();

        //5 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        dataPagehw4.setAndCheckSliders(0, 0);

    }
}
