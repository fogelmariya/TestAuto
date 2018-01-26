package enums;


import java.util.Arrays;
import java.util.List;

public enum IndexPageTextEnum {
    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…");

    public String text;

    IndexPageTextEnum(String text) {
        this.text = text;
    }

    public static List<String> getTexts() {
        return Arrays.asList(TEXT_1.text, TEXT_2.text, TEXT_3.text, TEXT_4.text);
    }
}
