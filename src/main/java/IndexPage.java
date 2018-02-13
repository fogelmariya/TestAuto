import enums.IndexPageTextEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

        @FindBy(xpath = "//*[contains(@class, 'fa-user')]")
        private WebElement loginForm;

        @FindBy(xpath = "//*[@id='Login']")
        private WebElement username;

        @FindBy(xpath = "//*[@id='Password']")
        private WebElement password;

        @FindBy(xpath = "//*[contains(@class, 'fa-sign-in')]")
        private WebElement submit;



        public void login(String user, String pass) {
            loginForm.click();
            username.sendKeys(user);
            password.sendKeys(pass);
            submit.click();
        }
    public static void main(String[] args) {
        IndexPageTextEnum[] textEnums = new IndexPageTextEnum[4];
        System.out.println(textEnums[0].text);
    }
}
