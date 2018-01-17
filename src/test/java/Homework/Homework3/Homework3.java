package Homework.Homework3;


import Homework.IndexPagehw3;
import lessons.pageObjects.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Homework3 {

    WebDriver driver = new ChromeDriver();
    private IndexPagehw3 indexPage;

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        indexPage = PageFactory.initElements(driver, IndexPagehw3.class);
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
        Assert.assertEquals(driver.getTitle(), "Index Page");

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
        /*
        Assert.assertEquals(homeText.get(0).getText().replaceAll("\\w", ""),
                "To include good practices and ideas from successful EPAM projec");
        Assert.assertEquals(homeText.get(1).getText().replaceAll("\\w", ""),
                "To be flexible and customizable");
        Assert.assertEquals(homeText.get(2).getText().replaceAll("\\w", ""),
                "To be multiplatform");
        Assert.assertEquals(homeText.get(3).getText().replaceAll("\\w", ""),
                "Already have good base (about 20 internal and some external projects), wish to get more…");*/

        //8 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainText(driver);
    }
}
