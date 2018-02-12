package enums;

/**
 * Created by User on 30.01.2018.
 */
public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad"),
    ONION("Onion");

    public String text;

    Vegetables(String text) {
        this.text = text;
    }
}
