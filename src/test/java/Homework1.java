import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework1 {
    @Test
    public void testIndexPage() {

        //Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        WebElement element = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li"));
        element.click();
        element = driver.findElement(By.id("Login"));
        element.sendKeys("epam");
        element = driver.findElement(By.id("Password"));
        element.sendKeys("1234");
        element = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button"));
        element.click();

        //Assert User name in the left-top side of screen that user is loggined
        element = driver.findElement(By.xpath
                ("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        Assert.assertEquals(element.getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> homeimage = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(homeimage.size(), 4);
        for (WebElement image: homeimage) {
            Assert.assertTrue(image.isDisplayed());
        }

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> hometext = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(hometext.size(), 4);
        for (WebElement text: hometext) {
            Assert.assertTrue(text.isDisplayed());
        }
        Assert.assertEquals(hometext.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" + "EPAM projec");
        Assert.assertEquals(hometext.get(1).getText(), "To be flexible and\n" +
                "customizable");
        Assert.assertEquals(hometext.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(hometext.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //Assert that there are the main header and the text below it on the Home Page
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/h3"));
        Assert.assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/p"));
        Assert.assertTrue(element.isDisplayed());

        //Close Browser
        driver.close();
    }

}
