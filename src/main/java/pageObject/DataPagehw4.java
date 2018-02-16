package pageObject;


import com.codeborne.selenide.SelenideElement;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DataPagehw4 {

    //    @FindBy(css = "uui-slider")
//    private static SelenideElement slider;
//
//    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
//    private SelenideElement leftSlider;
//
//    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
//    private SelenideElement rightSlider;

    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> nodes;

    @Step
    public void setAndCheckSliders(int left, int right) {
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();

        double scrollPanelLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
        double step = scrollPanelLength / 100;

        actions().dragAndDropBy(nodes.get(0), (int) (left * step - ((left > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(nodes.get(1), (int) (-((100 - right) * step + step)), 0).build().perform();

        Assert.assertEquals(Integer.parseInt(nodes.get(0).getText()), left);
        Assert.assertEquals(Integer.parseInt(nodes.get(1).getText()), right);
    }
//    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
//    private List<SelenideElement> nodes;
//
//    @Step
//    public void checkDragAndDrop(int left, int right) {
//        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
//        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();
//
//        double scrollPanelLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
//        double step = scrollPanelLength / 100;
//
//        actions().dragAndDropBy(nodes.get(0), (int) (left * step - ((left > 0) ? 0.5 * step : step)), 0).build()
//                .perform();
//        actions().dragAndDropBy(nodes.get(1), (int) (-((100 - right) * step + step)), 0).build().perform();
//
//        Assert.assertEquals(Integer.parseInt(nodes.get(0).getText()), left);
//        Assert.assertEquals(Integer.parseInt(nodes.get(1).getText()), right);
//    }

    public void checkRangeSlider(int left, int right) {

        SelenideElement slider = $(".uui-slider");
        SelenideElement leftSlider = slider.find("a:nth-child(1)");
        SelenideElement rightSlider = slider.find("a:last-child");
        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, (int) (274.167 / 100 * right - 1.5), 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) (274.167 / 100 * left - 1.5), 0).build().perform();
        leftSlider.shouldHave(exactText(String.valueOf(left)));
        rightSlider.shouldHave(exactText(String.valueOf(right)));

//        float step =((float) $(".uui-slider").getSize().width) / 100;
//        System.out.println(step);
//        rightSlider.isDisplayed();
//        leftSlider.isDisplayed();
//        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
//        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
//        actions().dragAndDropBy(rightSlider, (int) (274.167 / 100 * right - 1.5), 0).build().perform();
//        actions().dragAndDropBy(leftSlider, (int) (274.167 / 100 * left - 1.5), 0).build().perform();
//       // actions().dragAndDropBy(rightSlider, (int) (step * right ), 0).build().perform();
//        //actions().dragAndDropBy(leftSlider, (int) (step * left), 0).build().perform();
//        leftSlider.shouldHave(exactText(String.valueOf(left)));
//        rightSlider.shouldHave(exactText(String.valueOf(right)));
    }


}

