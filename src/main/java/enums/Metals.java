package enums;

/**
 * Created by User on 26.01.2018.
 */
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
