package pageObject;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DataPagehw4 {

    public void checkRangeSlider(int left, int right){
        SelenideElement slider = $("uui-slider");
        SelenideElement leftSlider = slider.find("a:nth-child(1)");
        SelenideElement rightSlider = slider.find("a:last-child");
        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, (int) (274.167 / 100 * right - 1.5), 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) (274.167 / 100 * left - 1.5), 0).build().perform();
        leftSlider.shouldHave(exactText(String.valueOf(left)));
        rightSlider.shouldHave(exactText(String.valueOf(right)));

    }
}

