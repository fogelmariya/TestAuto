package pageObject;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DataPagehw4 {

    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> nodes;

    @FindBy(css = "div:nth-child(2) > div > a:nth-child(1)")
    private SelenideElement sliderLeft;

    @FindBy(css = "div:nth-child(2) > div > a:nth-child(3)")
    private SelenideElement sliderRight;

    @FindBy(css = ".dropdown")
    private SelenideElement serviceMenuHead;

    @FindBy(css = "a[href='page4.htm']")
    private SelenideElement dataPageHeader;

    public void setSlidersRange(int left, int right) {
        actions().dragAndDropBy(sliderLeft, -1000, 0).build().perform();
        actions().dragAndDropBy(sliderRight, 1000, 0).build().perform();

        double scrollPanelLength = sliderRight.getLocation().getX() - sliderLeft.getLocation().getX();
        double step = scrollPanelLength / 100;

        System.out.println(step);

        actions().dragAndDropBy(sliderLeft, (int) (left * step - ((left > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(sliderRight, (int) (-((100 - right) * step + step)), 0).build().perform();

        sliderLeft.shouldHave(Condition.matchText(Integer.toString(left)));
        sliderRight.shouldHave(text(String.valueOf(right)));
    }

    public void openServiceDates() {
        serviceMenuHead.click();
        dataPageHeader.click();
        assertEquals(getWebDriver().getTitle(), "Dates");
    }
}

