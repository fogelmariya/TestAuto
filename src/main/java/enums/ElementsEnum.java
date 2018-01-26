package enums;

/**
 * Created by User on 26.01.2018.
 */
public enum ElementsEnum {
    WATER("Water"),
    WIND("Wind"),
    EARTH("Earth"),
    FIRE("Fire");

    public String text;

    ElementsEnum (String text) {
        this.text = text;
    }
}
