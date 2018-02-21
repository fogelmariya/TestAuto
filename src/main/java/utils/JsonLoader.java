package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.MetalsColorsData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;


public class JsonLoader {
    public Object[][] data;


    public JsonLoader() throws FileNotFoundException {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/main/resources/ex8_jdi_metalsColorsDataSet.json")).getAsJsonObject();
        Map<String, MetalsColorsData> metalsColorsData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, MetalsColorsData>>() {
        }.getType());

        data = new Object[metalsColorsData.size()][];
        Object[] values = metalsColorsData.values().toArray();
        for (int i = 0; i < values.length; i++) {
            data[i] = new Object[]{values[i]};
        }
    }
}
