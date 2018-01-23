package homework.homework4;

import com.codeborne.selenide.Configuration;
import enums.ServicePageEnum;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.IndexPagehw4;
import pageObject.ServicePagehw4;

import static com.codeborne.selenide.Selenide.open;


public class Homework4 {

    private IndexPagehw4 indexPage = new IndexPagehw4();
    private ServicePagehw4 servicePagehw4 = new ServicePagehw4();

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void IndexAndServicePageTest1(){
        //1 Open test site by URL
        open("https://jdi-framework.github.io/tests");
//        indexPage.openSite();

        //2 Perform login
        indexPage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName("PITER CHAILOVSKII");

        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkImageIsDisplayed();
        indexPage.checkTextUnderImages();
        indexPage.checkMainText();

        //5 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkServicesLeft(ServicePageEnum.values());

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkServicesHeader(ServicePageEnum.values());

        //7 Check interface on Service page, it contains all needed elements.
        servicePagehw4.checkInterfaces();

        //8 Select and assert checkboxes
        servicePagehw4.checkWaterAndWindCheckboxes();

        //9 Select radio
        servicePagehw4.checkSelenRadio();

        //10 Select in dropdown
        servicePagehw4.checkYellowDropdown();

        //11 Check in logs section selected values and status (true|false)
        servicePagehw4.checkLogValue(0, "Colors", "Yellow");
        servicePagehw4.checkLogValue(1, "metal", "Selen");
        servicePagehw4.checkLogCondition(2, "Wind", true);
        servicePagehw4.checkLogCondition(3, "Water", true);

        //12 Unselect and assert checkboxes
        servicePagehw4.checkUnselect();

        //13 Check in logs section unselected values and status (true|false)
        servicePagehw4.checkLogCondition(0, "Wind", false);
        servicePagehw4.checkLogCondition(1, "Water", false);
    }


}
