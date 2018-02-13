package entities;


import com.epam.commons.DataClass;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsEnum.*;

public class MetalsColorsData extends DataClass {

    public String odds;
    public String evens;

    public String[] elements;

    public String colors;

    public String metals;

    public String[] vegetables;

    public MetalsColorsData() {
        odds = "3";
        evens = "8";
        elements = new String[]{"Water", "Fire"};
        colors = "Red";
        metals = "Selen";
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public MetalsColorsData(NewData newData) {
        this.odds = newData.odds;
        this.evens = newData.evens;
        this.colors = newData.colors;
        this.metals = newData.metals;
        this.elements = newData.elements;
        this.vegetables = newData.vegetables;
    }

    public String listOfElements(String... elements) {
        String result = "";
        for (String line : elements) {
            result += line + ", ";
        }
        return result;
    }

    public Map<String, String[]> makeLog() {

        Map<String, String[]> result = new HashMap<>();
        result.put(SUMMARY.text, new String[]{Integer.toString(Integer.parseInt(odds) + Integer.parseInt(evens))});
        result.put(ELEMENTS.text, elements);
        result.put(COLOR.text, new String[]{colors});
        result.put(METAL.text, new String[]{metals});
        result.put(VEGETABLES.text, vegetables);
        return result;
    }
}
