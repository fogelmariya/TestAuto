package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.MetalsColorsData;
import entities.User;
import enums.HeaderMenuItems;
import forms.LoginForm;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.HomePage;
import site.pages.MetalsColorsPage;
import site.sections.Header;


@JSite("https://epam.github.io/JDI")
public class JDISite extends WebSite {
    public static HomePage homePage;
    public static LoginForm loginForm;
    public static Header header;

    @JFindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @JFindBy(css = ".m-l8")
    public static Header headerMenu;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @JFindBy(css = ".logs li")
    public static TextList<Enum> actionsLog;

    @JFindBy(css = ".results")
    public static TextList<Enum> resultsLog;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }

    @Step
    public static void openMetalsColorsPage() {
        headerMenu.select(HeaderMenuItems.METALS_COLORS.item);
        metalsColorsPage.checkOpened();
    }

    @Step
    public static void fillMetalsColorsForm() {
        metalsColorsPage.metalsColorsForm.setMetalsColorsData(new MetalsColorsData());
    }
}
