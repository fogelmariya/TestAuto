package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPagehw3 {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".uui-profile-menu .fa fa-user .span")
    public WebElement name;

    @FindBy(css = ".benefit-icon")
    public WebElement homeImage;

    @FindBy(css = "main-content .h3")
    public WebElement mainText1;

    @FindBy(css = ". main-txt text-center")
    public WebElement mainText2;

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkImageIsDisplayed(WebDriver driver) {
        List<WebElement> homeImage = driver.findElements(By.className("benefit-icon"));
        assertEquals(homeImage.size(), 4);
        for (WebElement image : homeImage) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkText(WebDriver driver) {
        List<WebElement> homeText = driver.findElements(By.className("benefit-txt"));
        assertEquals(homeText.size(), 4);
        for (WebElement text : homeText) {
            Assert.assertTrue(text.isDisplayed());
        }

        assertEquals(homeText.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" + "EPAM projec");
        assertEquals(homeText.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(homeText.get(2).getText(), "To be multiplatform");
        assertEquals(homeText.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    }

    public void checkMainText(WebDriver driver) {
        WebElement element;
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/h3"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/p"));
        assertTrue(element.isDisplayed());
    }

    public void checkUserName(WebDriver driver) {
        assertEquals(name.getText(), "PITER CHAILOVSKII");
    }
}

