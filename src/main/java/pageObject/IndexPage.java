package pageObject;


import enums.IndexPageTextEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class IndexPage {
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkTextUnderImages(IndexPageTextEnum text){
        assertEquals("", text.text);
    }

    public static void main(String[] args) {
        String string = "To be flexible and\n" + "customizable";
        System.out.println(string.replaceAll("\\n", " "));
    }
}
