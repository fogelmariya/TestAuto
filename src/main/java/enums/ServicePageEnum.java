package enums;

import java.util.Arrays;
import java.util.List;

public enum ServicePageEnum {
    SERVICE_1("Support"),
    SERVICE_2("Dates"),
    SERVICE_3("Complex Table "),
    SERVICE_4("Simple Table"),
    SERVICE_5("Table with site.pages"),
    SERVICE_6("Different elements"),
    COLORS("Colors"),
    METAL("metal");

    public String text;

    ServicePageEnum(String text) {
        this.text = text;
    }
    public static List<String> getServices() {
        return Arrays.asList(SERVICE_1.text, SERVICE_2.text, SERVICE_3.text, SERVICE_4.text, SERVICE_5.text, SERVICE_6.text);
    }
}
