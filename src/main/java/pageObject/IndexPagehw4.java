package pageObject;


import com.codeborne.selenide.SelenideElement;
import enums.ServicePageEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class IndexPagehw4 {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private SelenideElement user;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> homeImages;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> textsUnderImages;

    @FindBy(css = ".main-title.text-center")
    private WebElement homeText1;

    @FindBy(css = ".main-txt.text-center")
    private WebElement homeText2;

    public void openSite() {
        open("https://jdi-framework.github.io/tests");
    }

    public void login(String name, String password) {
        $(".uui-profile-menu .dropdown-toggle").click();
        //loginFormButton.click();
        $("#Login").sendKeys(name);
        //loginInput.sendKeys(name);
        $("#Password").sendKeys(password);
        //passwordInput.sendKeys(password);
        $(".form-horizontal [type='submit']").click();
        //submitButton.click();
    }

    public void checkUserName(String userName) {
        $(".profile-photo>span").shouldHave(text(userName));
       // user.shouldHave(text(userName));
    }

    public void checkImageIsDisplayed() {
        for (SelenideElement element: homeImages) {
            Assert.assertTrue(element.isDisplayed());
        }
       // Assert.assertTrue($(".benefit-icon").isDisplayed());
    }

    public void checkTextUnderImages() {
        for (SelenideElement element: textsUnderImages) {
           element.isDisplayed();
        }
        //$(".benefit-txt").isDisplayed();
    }

    public void checkMainText() {
        $(".main-title.text-center").isDisplayed();
        $(".main-txt.text-center").isDisplayed();
    }

    public void checkServicesLeft(ServicePageEnum[] services) {
        $(".sidebar-menu .sub-menu").click();
        $(".sub-menu [href = 'page3.htm']").shouldHave(text(services[0].text));
        $(".sub-menu [href = 'page4.htm']").shouldHave(text(services[1].text));
        $(".sub-menu [href = 'page5.htm']").shouldHave(text(services[2].text));
        $(".sub-menu [href = 'page6.htm']").shouldHave(text(services[3].text));
        $(".sub-menu [href = 'page7.htm']").shouldHave(text(services[4].text));
        $(".sub-menu [href = 'page8.htm']").shouldHave(text(services[5].text));
    }

    public void checkServicesHeader(ServicePageEnum[] services) {
        $(".dropdown").click();
        $(".dropdown [href = 'page3.htm']").shouldHave(text(services[0].text));
        $(".dropdown [href = 'page4.htm']").shouldHave(text(services[1].text));
        $(".dropdown [href = 'page5.htm']").shouldHave(text(services[2].text));
        $(".dropdown [href = 'page6.htm']").shouldHave(text(services[3].text));
        $(".dropdown [href = 'page7.htm']").shouldHave(text(services[4].text));
        $(".dropdown [href = 'page8.htm']").shouldHave(text(services[5].text));
    }

    public void openServiceDates() {
        $(".dropdown").click();
        $(".dropdown [href = 'page4.htm']").click();
        assertEquals(getWebDriver().getTitle(), "Dates");
    }
}
