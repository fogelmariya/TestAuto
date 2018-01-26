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
        // $(".dropdown").click();
        //$(".sub-menu a[href^='page8']").click();
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        left.shouldBe(visible);
        right.shouldBe(visible);
    }

    public void checkCheckbox(String element) {

        for (SelenideElement checkbox: checkboxes) {
            if (checkbox.getText().equals(element)) {
                checkbox.find("input").click();
                checkbox.find("input").shouldBe(checked);
            }
        }
//       SelenideElement waterCheckbox = checkboxes.get(0);
//        waterCheckbox.shouldHave(text("Water"));
//        waterCheckbox.find("input").click();
//        waterCheckbox.find("input").shouldBe(checked);
//
//        SelenideElement windCheckbox = checkboxes.get(2);
//        windCheckbox.shouldHave(text("Wind"));
//        windCheckbox.find("input").click();
//        windCheckbox.find("input").shouldBe(checked);
    }

    public void checkSelenRadio() {
        SelenideElement selenRadio = radios.get(3);
        selenRadio.find("input").click();
        selenRadio.find("input").shouldBe(checked);
    }

    public void checkYellowDropdown() {
        colorsDropDown.click();
        colorsList.get(3).click();
        colorsDropDown.shouldHave(text("Yellow"));
    }

    public void checkLog(int index, String string) {
        // List<SelenideElement> log = $$(".info-panel-body-log li");
        log.get(index).shouldHave(text(string));
    }

    public void checkLogValue(int index, String element, String value) {
        checkLog(index, element + ": value changed to " + value);
    }

    public void checkLogCondition(int index, String element, boolean condition) {
        checkLog(index, element + ": condition changed to " + condition);
    }

    public void checkUnselect(String element) {
        for (SelenideElement checkbox: checkboxes) {
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
