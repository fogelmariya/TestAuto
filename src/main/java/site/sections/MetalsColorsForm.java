package site.sections;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColorsData;
import enums.ColorsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class MetalsColorsForm extends Form<MetalsColorsData> {

    MetalsColorsData metalsColorsData;

    @JFindBy(css = "#odds-selector .radio")
    public RadioButtons odds;

    @JFindBy(css = "#even-selector .radio")
    public RadioButtons evens;

    @FindBy(css = "#elements-checklist p")
    public CheckList elements;

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

    @Step
    public void setMetalsColorsData(MetalsColorsData metalsColorsData) {
        odds.select(metalsColorsData.summary[0]);
        evens.select(metalsColorsData.summary[1]);
        metals.select(metalsColorsData.metals);
        elements.check(metalsColorsData.elements);
        colors.select(metalsColorsData.colors);
        // vegetables.select(metalsColorsData.vegetables);
        checkedVegetables.click();
       // checkedVegetables.click();
        if (!checkedVegetables.getText().equals("")) {
            String[] realVegetables = checkedVegetables.getText().split(", ");
            for (String vegetable : realVegetables) {
                vegetables.check(vegetable);
            }
        }
        vegetables.check(metalsColorsData.vegetables);
    }
}
