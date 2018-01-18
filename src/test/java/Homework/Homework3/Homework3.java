package Homework.Homework3;


import pageObject.IndexPagehw3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework3 {

    WebDriver driver = new ChromeDriver();
    private IndexPagehw3 indexPage;

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPagehw3.class);
        indexPage.open(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    //все через pageobject, здесь только вызывать
    @Test
    public void testIndexPage() {
        WebElement element;
        //2 Assert Browser title
        indexPage.checkTitle(driver);

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName(driver);

        //5 Assert Browser title
        indexPage.checkTitle(driver);

        //6 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkImageIsDisplayed(driver);

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkText(driver);

        //8 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainText(driver);
    }
}
