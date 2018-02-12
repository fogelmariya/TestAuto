package enums;


public enum Nature {
    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String text;

    Nature(String value) {
        this.text = value;
    }
}
