package site.sections;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColorsData;
import enums.ColorsEnum;
import enums.MetalsColorsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetalsColorsForm extends Form<MetalsColorsData> {

    MetalsColorsData metalsColorsData;

    @JFindBy(css = "#odds-selector .radio")
    public RadioButtons odds;

    @JFindBy(css = "#even-selector .radio")
    public RadioButtons evens;

    @FindBy(css = "#elements-checklist p")
    public CheckList elements;

//    @Css(".vertical-group label")
//    public static CheckList elements;

//    @JFindBy(css = "#elements-checklist .checkbox")
//    public CheckList<ElementsEnum> elements;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jexpand = @JFindBy(title = "Colors"),
            jlist = @JFindBy(tagName = "li"))
    public Dropdown<ColorsEnum> colors;

    @JComboBox(
            root = @FindBy(css = ".metals"),
            list = @FindBy(tagName = "li"),
            expand = @FindBy(css = ".caret")
    )
    public ComboBox metals;

    @FindBy(css = "#salad-dropdown button")
    private Label checkedVegetables;

    @FindBy(css = "#salad-dropdown label")
    private CheckList vegetables;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    @FindBy(css = ".results li")
    public TextList actualResultLog;

    @Step
    public void setMetalsColorsData(MetalsColorsData metalsColorsData) {
        odds.select(metalsColorsData.odds);
        evens.select(metalsColorsData.evens);
        metals.select(metalsColorsData.metals);
        elements.check(metalsColorsData.elements);
        colors.select(metalsColorsData.colors);
        // vegetables.select(metalsColorsData.vegetables);
        checkedVegetables.click();
        checkedVegetables.click();
        if (!checkedVegetables.getText().equals("")) {
            String[] chosenVegetables = checkedVegetables.getText().split(", ");
            for (String vegetable : chosenVegetables) {
                vegetables.check(vegetable);
            }
        }
        vegetables.check(metalsColorsData.vegetables);

    }

    @Step
    public static Map<String, String[]> prepareLog(TextList textList) {
        Map<String, String[]> resultLog = new HashMap<>();

        List<String> logList = textList.getTextList();

        for (String log : logList) {
            for (MetalsColorsEnum key : MetalsColorsEnum.values()) {
                if (log.startsWith(key.text)) {
                    resultLog.put(key.text, log.substring(key.text.length() + 2).split(", "));
                    break;
                }
            }
        }
        return resultLog;
    }

    public void checkResultLog(MetalsColorsData metalsColorsData) {
//        Map<String, String[]> expectedLogMap = metalsColorsData.makeLog1();
//        Map<String, String[]> actualLogMap =prepareLog(actualResultLog);
//
//        Assert.arrayEquals(actualLogMap.keySet().toArray(), expectedLogMap.keySet().toArray());
//
//        for (String key : expectedLogMap.keySet()) {
//            Assert.arrayEquals(actualLogMap.get(key), expectedLogMap.get(key), "Wrong " + key);
//        }
    }

}
