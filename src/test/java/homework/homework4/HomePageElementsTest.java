package homework.homework4;

import base.BaseSelenide;
import enums.Metals;
import enums.ServicePageEnum;
import listeners.AllureAttachmentListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.HomePagehw4;
import pageObject.ServicePagehw4;

import static enums.ColorsEnum.COLOR;
import static enums.ColorsEnum.YELLOW;
import static enums.Nature.WATER;
import static enums.Nature.WIND;


@Listeners(AllureAttachmentListener.class)
public class HomePageElementsTest extends BaseSelenide{

    private HomePagehw4 homePage;
    private ServicePagehw4 servicePagehw4;

    @Test
    public void IndexAndServicePageTest1() {
        // page(homePage);
        //1 Open test site by URL
        //open("https://jdi-framework.github.io/tests");
        homePage.openSite();

        //2 Perform login
        homePage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName("PITER CHAILOVSKII");

        //4 Check interface on Home page, it contains all needed elements.
        homePage.checkImageIsDisplayed();
        homePage.checkTextUnderImages();
        homePage.checkMainText();

        //5 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServicesLeft(ServicePageEnum.getServices());

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServicesHeader(ServicePageEnum.getServices());

        //7 Check interface on Service page, it contains all needed elements.
        homePage.openServiceDifferentElements();
        servicePagehw4.checkInterfaces();

        //8 Select and assert checkboxes
        servicePagehw4.checkCheckbox(WATER.text);
        servicePagehw4.checkCheckbox(WIND.text);

        //9 Select radio
        servicePagehw4.checkMetalRadio(Metals.SELEN.text);

        //10 Select in dropdown
        servicePagehw4.checkDropdown(YELLOW.text);

        //11 Check in logs section selected values and status (true|false)
        servicePagehw4.checkLogValue(COLOR.text, YELLOW.text);
        servicePagehw4.checkLogValue(Metals.METALS.text, Metals.SELEN.text);
        servicePagehw4.checkLogCondition(WIND.text, true);
        servicePagehw4.checkLogCondition(WATER.text, true);

        //12 Unselect and assert checkboxes
        servicePagehw4.checkUnselect(WATER.text);
        servicePagehw4.checkUnselect(WIND.text);

        //13 Check in logs section unselected values and status (true|false)
        servicePagehw4.checkLogCondition( WIND.text, false);
        servicePagehw4.checkLogCondition( WATER.text, false);
    }


}
