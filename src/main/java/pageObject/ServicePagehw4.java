package pageObject;


import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ServicePagehw4 {

    public void openSite() {
        open(" https://jdi-framework.github.io/tests/page8.htm");
    }

    public void checkInterfaces() {
        $(".dropdown").click();
        $(".sub-menu a[href^='page8']").click();
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$("[value~='Button']").shouldHaveSize(2);
        $(".uui-pagination a[href^='page7']").shouldBe(visible);
        $(".uui-pagination a[href^='page2']").shouldBe(visible);
    }

    public void checkWaterAndWindCheckboxes() {
        SelenideElement waterCheckbox = $$(".label-checkbox").get(0);
        waterCheckbox.shouldHave(text("Water"));
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldBe(checked);

        SelenideElement windCheckbox = $$(".label-checkbox").get(2);
        windCheckbox.shouldHave(text("Wind"));
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldBe(checked);
    }

    public void checkSelenRadio() {
        SelenideElement selenRadio = $$(".label-radio").get(3);
        selenRadio.find("input").click();
        selenRadio.find("input").shouldBe(checked);
    }

    public void checkYellowDropdown() {
        SelenideElement yellowDropdown = $(".colors");
        yellowDropdown.click();
        $$(".colors option").get(3).click();
        yellowDropdown.shouldHave(text("Yellow"));
    }

    public void checkLog(int index, String string) {
        List<SelenideElement> log = $$(".info-panel-body-log li");
        log.get(index).shouldHave(text(string));
    }

    public void checkLogValue(int index, String element, String value) {
        checkLog(index, element + ": value changed to " + value);
    }

    public void checkLogCondition(int index, String element, boolean condition) {
        checkLog(index, element + ": condition changed to " + condition);
    }

    public void checkUnselect() {
        SelenideElement waterCheckbox = $$(".label-checkbox").get(0);
        waterCheckbox.shouldHave(text("Water"));
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldNotBe(checked);

        SelenideElement windCheckbox = $$(".label-checkbox").get(2);
        windCheckbox.shouldHave(text("Wind"));
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldNotBe(checked);
    }

}
