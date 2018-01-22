package enums;

public enum ServicePageEnum {
    SERVICE_1("Support"),
    SERVICE_2("Dates"),
    SERVICE_3("Complex Table "),
    SERVICE_4("Simple Table"),
    SERVICE_5("Table with pages"),
    SERVICE_6("Different elements");

    public String text;

    ServicePageEnum(String text) {
        this.text = text;
    }
}
