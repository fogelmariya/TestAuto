package homework.homework7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;
import site.JDISite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


public class TestInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
        logger.info("Run Tests");
    }
}
