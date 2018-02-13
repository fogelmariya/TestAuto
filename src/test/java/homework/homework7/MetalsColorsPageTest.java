package homework.homework7;

import entities.MetalsColorsData;
import org.testng.annotations.Test;

import static site.JDISite.*;

public class MetalsColorsPageTest extends TestInit {

    @Test
    public void loginTest() {
        homePage.open();
        login();
        homePage.checkOpened();
        openMetalsColorsPage();
        metalsColorsPage.checkOpened();
        MetalsColorsData metalsColorsData = new MetalsColorsData();
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);
        metalsColorsPage.metalsColorsForm.submitButton.click();
        metalsColorsPage.metalsColorsResultSection.checkResultLog(metalsColorsData);
        //metalsColorsPage.metalsColorsForm.checkResultLog(new MetalsColorsData());
        //checkResultLog();
//
    }
}
