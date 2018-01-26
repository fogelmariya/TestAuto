package pageObject;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DataPagehw4 {

    @FindBy(css = "uui-slider")
    private static SelenideElement slider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    public void checkRangeSlider(int left, int right){
        float step =((float) $(".uui-slider").getSize().width) / 100;
        System.out.println(step);
        rightSlider.isDisplayed();
        leftSlider.isDisplayed();
        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, (int) (step * right ), 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) (step * left), 0).build().perform();
        leftSlider.shouldHave(exactText(String.valueOf(left)));
        rightSlider.shouldHave(exactText(String.valueOf(right)));
    }

}

