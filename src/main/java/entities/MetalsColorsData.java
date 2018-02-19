package entities;


import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsEnum.*;

@AllArgsConstructor
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

//    public MetalsColorsData(String[] summary, String[] elements, String colors, String metals, String[] vegetables) {
//        this.summary = summary;
//        this.elements = elements;
//        this.colors = colors;
//        this.metals = metals;
//        this.vegetables = vegetables;
//    }


    public Map<String, String[]> makeLog() {

        Map<String, String[]> result = new HashMap<>();
        result.put(SUMMARY.text, new String[]{Integer.toString(Integer.parseInt(summary[0]) + Integer.parseInt(summary[1]))});
        result.put(ELEMENTS.text, elements);
        result.put(COLOR.text, new String[]{colors});
        result.put(METAL.text, new String[]{metals});
        result.put(VEGETABLES.text, vegetables);
        return result;
    }
}
