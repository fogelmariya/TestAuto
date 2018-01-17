package Homework.Homework2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class Homework2 {

    private WebDriver driver;
    private List<WebElement> hometext;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        hometext = driver.findElements(By.className("benefit-txt"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] dp() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM projec"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "dp")
    public void testText1(int num, String txt) {

        for (WebElement text : hometext) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(hometext.get(num).getText(), txt);
        assertEquals(hometext.get(num).getText(), txt);
        assertEquals(hometext.get(num).getText(), txt);
        assertEquals(hometext.get(num).getText(), txt);
    }
}
