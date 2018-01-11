import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework1 {

    private ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Assert Browser title
    @Test
    public void testTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        Assert.assertEquals(driver.getTitle(), "Index Page");
        driver.close();
    }

    @Test
    public void loginTest() {
        open("https://jdi-framework.github.io/tests/index.htm");
        login();
    }

    @Step
    public void login() {
        $(".fa-user").click();
        $("#Login").sendKeys("epam");
        $("#Password").sendKeys("1234");

        $(".fa-sign-in").shouldBe(visible);
        $(".fa-sign-in").click();
    }
}
