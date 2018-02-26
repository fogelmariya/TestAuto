package pageObject;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class ServicePagehw4 {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "[value~='Button']")
    private ElementsCollection buttons;

    @FindBy(css = ".uui-pagination a[href^='page7']")
    private SelenideElement left;

    @FindBy(css = ".uui-pagination a[href^='page2']")
    private SelenideElement right;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropDown;

    @FindBy(css = ".colors option")
    private ElementsCollection colorsList;

    @FindBy(css = ".info-panel-body-log li")
    private List<SelenideElement> log;

    public void checkInterfaces() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        left.shouldBe(visible);
        right.shouldBe(visible);
    }

    public void checkCheckbox(String element) {

        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.getText().equals(element)) {
                checkbox.find("input").click();
                checkbox.find("input").shouldBe(checked);
            }
        }
    }

    public void checkMetalRadio(String expectedMetal) {
        for (SelenideElement radio : radios) {
            if (radio.getText().equals(expectedMetal)) {
                radio.click();
                radio.find("input").shouldBe(checked);
            }
        }
    }

    public void checkDropdown(String expectedColor) {
        colorsDropDown.click();
        for (SelenideElement color : colorsList) {
            if (color.getText().equals(expectedColor)) {
                color.click();
                colorsDropDown.shouldHave(text(expectedColor));
            }
        }
    }

    public void checkLog(String string) {
        log.contains(string);
    }

    public void checkLogValue(String element, String value) {
        checkLog(element + ": value changed to " + value);
    }

    public void checkLogCondition(String element, boolean condition) {
        checkLog(element + ": condition changed to " + condition);
    }

    public void checkUnselect(String element) {
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.getText().equals(element)) {
                checkbox.find("input").click();
                checkbox.find("input").shouldNotBe(checked);
            }
        }

//        SelenideElement windCheckbox = checkboxes.get(2);
//        windCheckbox.shouldHave(text("Wind"));
//        windCheckbox.find("input").click();
//        windCheckbox.find("input").shouldNotBe(checked);
    }

}
