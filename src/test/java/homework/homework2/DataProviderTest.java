package homework.homework2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DataProviderTest {

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
                {0, "To include good practices and ideas from successful EPAM projec"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "dp")
    public void testText1(int num, String txt) {

        for (WebElement text : hometext) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
        assertEquals(hometext.get(num).getText().replaceAll("\\n", " "), txt);
    }
}
