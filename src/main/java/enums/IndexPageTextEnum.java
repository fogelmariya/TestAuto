package enums;


public enum IndexPageTextEnum {
    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…"),
    NAME("PITER CHAILOVSKII"),
    PAGE_NAME("Index Page");

    public String text;

    IndexPageTextEnum(String text) {
        this.text = text;
    }

}
