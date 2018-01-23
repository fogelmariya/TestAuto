package homework.homework4;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.IndexPagehw4;
import pageObject.ServicePagehw4;


public class TestCase2 {

    private IndexPagehw4 indexPage = new IndexPagehw4();
    private ServicePagehw4 servicePagehw4 = new ServicePagehw4();

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void IndexAndServicePageTest2(){
        //1 Open test site by URL
        indexPage.openSite();

        //2 Perform login
        indexPage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName("PITER CHAILOVSKII");

        //4 Open Service -> Dates
        indexPage.openServiceDates();

        //5 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position


    }
}
