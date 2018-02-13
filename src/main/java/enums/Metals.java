package enums;


public enum Metals {
    METALS("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String text;

    Metals(String text) {
        this.text = text;
    }
}
