package Homework.Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class SeleniumTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp3(){
        System.out.println("ready for test");
    }

    @BeforeSuite
    public void setUp2(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @AfterSuite
    public void tearDown2(){
        System.out.println("all tests passed");
    }

    @AfterTest
    public void tearDown3(){
        System.out.println("well done!");
    }

    @Test
    public void test1(){
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }

}
