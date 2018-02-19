package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import entities.MetalsColorsData;
import enums.MetalsColorsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.web.matcher.testng.Assert.arrayEquals;


public class MetalsColorsResultSection extends Section {

    MetalsColorsData metalsColorsData;

    @FindBy(css = ".results li")
    private TextList actualResultLog;

    @Step
    public static Map<String, String[]> logToMap(TextList textList) {
        Map<String, String[]> resultLog = new HashMap<>();
        List<String> logList = textList.getTextList();

        for (String log : logList) {
            for (MetalsColorsEnum metalsColorsEnum : MetalsColorsEnum.values()) {
                if (log.startsWith(metalsColorsEnum.text)) {
                    resultLog.put(metalsColorsEnum.text, log.substring(metalsColorsEnum.text.length() + 2).split(", "));
                    break;
                }
            }
        }
        return resultLog;
    }

    public void checkResultLog(MetalsColorsData metalsColorsData) {
        Map<String, String[]> logExpected = metalsColorsData.makeLog();
        Map<String, String[]> actualLog = logToMap(actualResultLog);

        arrayEquals(actualLog.keySet().toArray(), logExpected.keySet().toArray());

        for (String metalsColors : logExpected.keySet()) {
            arrayEquals(actualLog.get(metalsColors), logExpected.get(metalsColors));
        }
    }
}
