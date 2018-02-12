package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import site.sections.MetalsColorsForm;

public class MetalsColorsPage extends WebPage {

    @JFindBy(css = ".form")
    public MetalsColorsForm metalsColorsForm;

}
