package entities;

import static utils.SetterValuesMetalsColors.*;

public class NewData {
   // public static String odds;
    //public static String evens;
    public String[] numbers;
    public static String metals;
    public static String colors;
    public static String[] elements;
    public static String[] vegetables;

    public NewData(String[] newData) {
       // odds = newData[0].substring(0,1);
        //evens = newData[0].substring(1,2);
        numbers[0] = newData[0].substring(0,1);
        numbers[1] = newData[0].substring(1,2);
        colors = setColor(newData[2]);
        metals = setMetal(newData[3]);
        elements = setEvenElementsValue(newData[1]);
        vegetables = setVegetables(newData[4]);
    }
}
