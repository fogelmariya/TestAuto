package homework.homework8;


import entities.MetalsColorsData;
import entities.User;
import homework.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonLoader;

import static site.JDISite.*;

public class MetalsColorsPageTestWithData extends TestInit {

    @BeforeClass
    public void openHomePage() {
        homePage.open();
        login(new User());
        homePage.checkOpened();
    }

    @AfterClass
    public void tearDown() {
        // logout();
    }

    @DataProvider
    public Object[][] jsonData() {
        JsonLoader jsonLoader = new JsonLoader();
        return jsonLoader.data;
    }

    @Test(dataProvider = "jsonData")
    public void jsonDataMetalsColorsTest(MetalsColorsData metalsColorsData) {
        //1 Login on JDI site as User
//        homePage.open();
        //login(new User());
//        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        openMetalsColorsPage();
        metalsColorsPage.checkOpened();

        //3
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(metalsColorsData);

        metalsColorsPage.metalsColorsForm.submitButton.click();
        metalsColorsPage.metalsColorsResultSection.checkResultLog(metalsColorsData);
    }
}
