package pageObject;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DataPagehw4 {

    public void checkRangeSlider(int left, int right){
        SelenideElement slider = $("uui-slider");
        SelenideElement leftSlider = slider.find("a:nth-child(1)");
        SelenideElement rightSlider = slider.find("a:last-child");
    }
}

