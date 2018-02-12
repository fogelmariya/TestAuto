package entities;


import com.epam.commons.DataClass;
import enums.ColorsEnum;
import enums.Metals;
import enums.Nature;
import enums.Vegetables;

public class MetalsColorsData extends DataClass{

    public int odd = 3;
    public int even = 8;

    public String elements = Nature.WATER.text + ", " + Nature.FIRE.text;

    public String colors = ColorsEnum.RED.text;

    public Metals metals = Metals.SELEN;

    public String[] vegetables = {Vegetables.CUCUMBER.text, Vegetables.TOMATO.text};
}
