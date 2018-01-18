package pageObject;

import enums.IndexPageTextEnum;
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

    @FindBy(css = ".profile-photo>span")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> homeImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderImages;

    @FindBy(css = ".main-title.text-center")
    private WebElement homeText1;

    @FindBy(css = ".main-txt.text-center")
    private WebElement homeText2;

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
        assertEquals(homeImages.size(), 4);
        for (WebElement image : homeImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    public void checkText(WebDriver driver) {
        assertEquals(textsUnderImages.size(), 4);
        for (WebElement text : textsUnderImages) {
            Assert.assertTrue(text.isDisplayed());
        }

        assertEquals(textsUnderImages.get(0).getText().replaceAll("\\n", " "),
                "To include good practices and ideas from successful EPAM projec");
        assertEquals(textsUnderImages.get(1).getText().replaceAll("\\n", " "),
                "To be flexible and customizable");
        assertEquals(textsUnderImages.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderImages.get(3).getText().replaceAll("\\n", " "),
                "Already have good base (about 20 internal and some external projects), wish to get more…");
    }

    public void checkMainText(WebDriver driver) {
        assertTrue(homeText1.isDisplayed());
        assertTrue(homeText2.isDisplayed());
    }

    public void checkTextUnderImages(IndexPageTextEnum[] text) {
        assertEquals("", text[0].text);
    }

    public void checkUserName(WebDriver driver) {
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }
}

