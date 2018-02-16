package homework.homework7;

import entities.MetalsColorsData;
import homework.TestInit;
import org.testng.annotations.Test;

import static site.JDISite.*;

public class MetalsColorsPageTest extends TestInit {

    @Test
    public void loginTest() {
        //1 Login on JDI site as User
        homePage.open();
        login();
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        openMetalsColorsPage();
        metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        MetalsColorsData metalsColorsData = new MetalsColorsData();
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        //4 Submit form Metals & Colors
        metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data  below:
        metalsColorsPage.metalsColorsResultSection.checkResultLog(metalsColorsData);
        //metalsColorsPage.metalsColorsForm.checkResultLog(new MetalsColorsData());
        //checkResultLog();
//
    }
}
