package enums;

/**
 * Created by User on 26.01.2018.
 */
public enum MetalEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String text;

    MetalEnum (String text) {
        this.text = text;
    }
}
