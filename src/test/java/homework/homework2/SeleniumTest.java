package homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class SeleniumTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest
    public void setUp() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeMethod
    public void tearDown() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown2() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @AfterTest
    public void tearDown3() {
        driver.close();
    }

    @AfterMethod
    public void setUp3() {
        System.out.println(driver.getTitle());
    }


    @Test
    public void test1() {
        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.findElement(By.xpath("//button[contains(@class, 'header-search')]")).click();

        WebElement menuButton = driver.findElement(By.xpath("//button[contains(@class, 'hamburger-menu')]"));
        assertTrue(menuButton.isDisplayed());
        assertEquals(menuButton.getText(), "MENU");
    }
}
