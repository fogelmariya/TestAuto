package entities;


import com.epam.commons.DataClass;

import java.util.ArrayList;
import java.util.List;

import static enums.MetalsColorsEnum.*;


public class MetalsColorsData extends DataClass {

    public String[] summary;
    public String[] elements;

    public String colors;

    public String metals;

    public String[] vegetables;

    public MetalsColorsData() {
        summary = new String[]{"3", "8"};
        elements = new String[]{"Water", "Fire"};
        colors = "Red";
        metals = "Selen";
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public MetalsColorsData(String[] summary, String[] elements, String colors, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public String elementsToString(MetalsColorsData metalsColorsData){
        String result = "";
        for (int i = 0; i < metalsColorsData.elements.length; i++) {
            result += metalsColorsData.elements[i];
            if (i != metalsColorsData.elements.length - 1)
                result += ", ";
        }
        return result;
    }

    public String vegetablesToString(MetalsColorsData metalsColorsData){
        String result = "";
        for (int i = 0; i < metalsColorsData.vegetables.length; i++) {
            result += metalsColorsData.vegetables[i];
            if (i != metalsColorsData.vegetables.length - 1)
                result += ", ";
        }
        return result;
    }


    public List<String> dataToString(MetalsColorsData metalsColorsData){
        List<String> result = new ArrayList<>();
        result.add(SUMMARY.text + ": " + Integer.toString(Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])));
        result.add(ELEMENTS.text + ": " + elementsToString(metalsColorsData));
        result.add(COLOR.text + ": " + colors);
        result.add(METAL.text + ": " + metals);
        result.add(VEGETABLES.text + ": " + vegetablesToString(metalsColorsData));
        return result;
    }

}
