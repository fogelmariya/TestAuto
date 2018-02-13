package enums;


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
