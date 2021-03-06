package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Homework1 {

    List<String> textUnderImageExpected = Arrays.asList(
            "To include good practices and ideas from successful EPAM projec",
            "To be flexible and customizable", "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");

    @Test
    public void testIndexPage() {

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        WebElement element;
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Perform login
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        element = driver.findElement(By.xpath
                ("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> homeImage = driver.findElements(By.className("benefit-icon"));
        assertEquals(homeImage.size(), 4);
        for (WebElement image : homeImage) {
            assertTrue(image.isDisplayed());
        }

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> homeText = driver.findElements(By.className("benefit-txt"));
        assertEquals(homeText.size(), 4);

        for (WebElement text : homeText) {
            assertTrue(text.isDisplayed());
            assertTrue(textUnderImageExpected.contains(text.getText().replaceAll("\\n", " ")));
        }

        //8 Assert that there are the main header and the text below it on the Home Page
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/h3"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/p"));
        assertTrue(element.isDisplayed());

        //9 Close Browser
        driver.close();
    }

}
