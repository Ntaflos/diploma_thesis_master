package com.diploma.thesis.data;

import com.diploma.thesis.data.data_handlers.CsvHandler;
import com.diploma.thesis.data.data_handlers.JsonHandler;
import com.diploma.thesis.models.LocationInfos;
import org.json.simple.JSONObject;


import java.io.IOException;
import java.util.*;

public class Queries {
    private String currentQ;
    private Map<String, String> currentQInputs;
    private List<String> queriesNames;
    private List<String> inputResults;

    public Queries() {
        queriesNames = JsonHandler.getQueriesNames();
        inputResults = new ArrayList<>();
    }

    public static List<LocationInfos> scoreQuery(ArrayList<String> inputs) {
        List<LocationInfos> list, list2;
        list2 = new ArrayList<>();
        CsvHandler.readCsv();
        list = CsvHandler.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getScore() > Integer.parseInt(inputs.get(0))) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }

    public static List<LocationInfos> countryQuery(ArrayList<String> inputs) {
        List<LocationInfos> list, list2;
        list2 = new ArrayList<>();
        CsvHandler.readCsv();
        list = CsvHandler.getList();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getCountry().replaceAll("\\s", "").equals(inputs.get(0))) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }

    public void setCurrentQInputs(JSONObject jsonObject) {
        currentQInputs = new HashMap<>();
        Iterator keySet = jsonObject.keySet().iterator();
        while (keySet.hasNext()) {
            String key = (String) keySet.next();
            String value = (String) jsonObject.get(key);
            currentQInputs.put(key, value);
        }


    }

    public String getCurrentQ() {
        return currentQ;
    }

    public void setCurrentQ(String currentQ) {
        this.currentQ = currentQ;
    }

    public List<String> getQueriesNames() {
        return queriesNames;
    }

    public Map<String, String> getCurrentQInputs() {
        return currentQInputs;
    }

    public List<String> getInputResults() {
        return inputResults;
    }

    public void setInputResults(List<String> inputResults) {
        this.inputResults = inputResults;
    }
}
