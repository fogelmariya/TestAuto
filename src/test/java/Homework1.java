import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework1 {
    @Test
    public void testTitle() {

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

        //Close Browser
        driver.close();
    }

}
