package pageObject;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class HomePagehw4 {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private SelenideElement user;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> homeImages;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> textsUnderImages;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement homeText1;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement homeText2;

    @FindBy(css = ".sidebar-menu .sub-menu")
    private SelenideElement serviceMenuLeft;

    @FindBy(css = ".dropdown")
    private SelenideElement serviceMenuHead;

    @FindBy(css = ".sub-menu [href = 'page8.htm']")
    private SelenideElement serviceItem6;

    @FindBy(css = ".sub li")
    private List<SelenideElement> servicesLeft;

    @FindBy(css = ".dropdown-menu li")
    private List<SelenideElement> servicesHeader;

    @FindBy(css = "a[href='page4.htm']")
    private SelenideElement dataPageHeader;


    public void openSite() {
        open("https://jdi-framework.github.io/tests");
    }

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        // $("#Password").sendKeys(password);
        passwordInput.sendKeys(password);
        //$(".form-horizontal [type='submit']").click();
        submitButton.click();
    }

    public void checkUserName(String userName) {
        // $(".profile-photo>span").shouldHave(text("PITER CHAILOVSKII"));
        user.shouldHave(text(userName));
    }

    public void checkImageIsDisplayed() {
        Assert.assertTrue(homeImages.size() == 4);
        for (SelenideElement element : homeImages) {
            Assert.assertTrue(element.isDisplayed());
        }
        //Assert.assertTrue($(".benefit-icon").isDisplayed());
    }

    public void checkTextUnderImages() {
        for (SelenideElement element : textsUnderImages) {
            element.isDisplayed();
        }
        //$(".benefit-txt").isDisplayed();
    }

    public void checkMainText() {
        homeText1.isDisplayed();
        homeText2.isDisplayed();
    }

    public void checkServicesLeft(List<String> services) {
        serviceMenuLeft.click();
        List<String> servicesString = new ArrayList<String>();

        for (SelenideElement selenideElement : servicesLeft) {
            servicesString.add(selenideElement.getText());
        }

        for (String service : services) {
            Assert.assertTrue(servicesString.contains(service));
        }
    }

    public void checkServicesHeader(List<String> services) {
        serviceMenuHead.click();
        List<String> servicesString = new ArrayList<String>();

        for (SelenideElement selenideElement : servicesHeader) {
            servicesString.add(selenideElement.getText().toLowerCase());
        }

        for (String service : services) {
            Assert.assertTrue(servicesString.contains(service.toLowerCase()));
        }
    }

    public void openServiceDifferentElements() {
        serviceItem6.click();
    }
}
