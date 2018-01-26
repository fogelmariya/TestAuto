package homework.homework4;

import com.codeborne.selenide.Configuration;
import enums.ServicePageEnum;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.HomePagehw4;
import pageObject.ServicePagehw4;

import static com.codeborne.selenide.Selenide.*;
import static enums.ColorsEnum.YELLOW;
import static enums.ElementsEnum.WATER;
import static enums.ElementsEnum.WIND;
import static enums.MetalEnum.SELEN;
import static enums.ServicePageEnum.COLORS;
import static enums.ServicePageEnum.METAL;

@Listeners(AllureAttachmentListener.class)
public class HomePageElementsTest {

    private HomePagehw4 homePage ;
    private ServicePagehw4 servicePagehw4;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        homePage = page(HomePagehw4.class);
        servicePagehw4 = page(ServicePagehw4.class);
    }

    @AfterTest
    public void tearDown(){
        close();
    }

    @Test
    public void IndexAndServicePageTest1(){
        page(homePage);
        //1 Open test site by URL
        open("https://jdi-framework.github.io/tests");
//        homePage.openSite();

        //2 Perform login
        homePage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName("PITER CHAILOVSKII");

        //4 Check interface on Home page, it contains all needed elements.
        homePage.checkImageIsDisplayed();
        homePage.checkTextUnderImages();
        homePage.checkMainText();

        //5 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServicesLeft(ServicePageEnum.values());

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServicesHeader(ServicePageEnum.values());

        //7 Check interface on Service page, it contains all needed elements.
        homePage.openServiceDifferentElements();
        servicePagehw4.checkInterfaces();

        //8 Select and assert checkboxes
        servicePagehw4.checkCheckbox(WATER.text);
        servicePagehw4.checkCheckbox(WIND.text);

        //9 Select radio
        servicePagehw4.checkSelenRadio();

        //10 Select in dropdown
        servicePagehw4.checkYellowDropdown();

        //11 Check in logs section selected values and status (true|false)
        servicePagehw4.checkLogValue(0, COLORS.text, YELLOW.text);
        servicePagehw4.checkLogValue(1, METAL.text, SELEN.text);
        servicePagehw4.checkLogCondition(2, WIND.text, true);
        servicePagehw4.checkLogCondition(3, WATER.text, true);

        //12 Unselect and assert checkboxes
        servicePagehw4.checkUnselect(WATER.text);
        servicePagehw4.checkUnselect(WIND.text);

        //13 Check in logs section unselected values and status (true|false)
        servicePagehw4.checkLogCondition(0, WIND.text, false);
        servicePagehw4.checkLogCondition(1, WATER.text, false);
    }


}
