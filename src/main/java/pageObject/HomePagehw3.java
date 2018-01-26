package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePagehw3 {

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

    public void checkImageIsDisplayed() {
        assertEquals(homeImages.size(), 4);
        for (WebElement image : homeImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    public void checkTexts(List<String> texts) {
        assertEquals(textsUnderImages.size(), 4);
        for (WebElement text : textsUnderImages) {
            Assert.assertTrue(text.isDisplayed());
            Assert.assertTrue(texts.contains(text.getText().replaceAll("\\n", " ")));
        }

    }

    public void checkMainText() {
        assertTrue(homeText1.isDisplayed());
        assertTrue(homeText2.isDisplayed());
    }

    public void checkUserName() {
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }
}

