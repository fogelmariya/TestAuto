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
    public TextList actualResultLog;

    @Step
    public static Map<String, String[]> log(TextList textList) {
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
        Map<String, String[]> logExpected = metalsColorsData.makeLog();
        Map<String, String[]> actualLog = log(actualResultLog);

        arrayEquals(actualLog.keySet().toArray(), logExpected.keySet().toArray());

        for (String key : logExpected.keySet()) {
            arrayEquals(actualLog.get(key), logExpected.get(key));
        }
    }
}
