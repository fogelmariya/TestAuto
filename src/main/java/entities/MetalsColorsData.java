package entities;


import com.epam.commons.DataClass;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsEnum.*;

public class MetalsColorsData extends DataClass {

    // String odds;
   // public String evens;
    public String[] numbers;
    public String[] elements;

    public String colors;

    public String metals;

    public String[] vegetables;

    public MetalsColorsData() {
        numbers[0] = "3";
        numbers[1] = "8";
        //odds = "3";
       // evens = "8";
        elements = new String[]{"Water", "Fire"};
        colors = "Red";
        metals = "Selen";
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public MetalsColorsData(String[] numbers, String[] elements, String colors, String metals, String[] vegetables) {
        this.numbers = numbers;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public MetalsColorsData(NewData newData) {
       // this.odds = newData.odds;
        //this.evens = newData.evens;
        this.numbers = newData.numbers;
        this.colors = newData.colors;
        this.metals = newData.metals;
        this.elements = newData.elements;
        this.vegetables = newData.vegetables;
    }

    public Map<String, String[]> makeLog() {

        Map<String, String[]> result = new HashMap<>();
        result.put(SUMMARY.text, new String[]{Integer.toString(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]))});
        result.put(ELEMENTS.text, elements);
        result.put(COLOR.text, new String[]{colors});
        result.put(METAL.text, new String[]{metals});
        result.put(VEGETABLES.text, vegetables);
        return result;
    }
}
