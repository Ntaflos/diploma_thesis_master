package com.diploma.thesis.data.data_handlers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonHandler {
    private static String adminsJson = "src/main/resources/static/files/admin.json";

    public static List<String> getQueriesNames() {
        List<String> queries = new ArrayList<>();
        Iterator<JSONObject> iterator = readAdminsJson().iterator();
        while (iterator.hasNext()) {
            queries.add((String) iterator.next().get("name"));
        }

        return queries;

    }

    public static JSONObject setCurrentQInputs(String currentQInputs) {
        List<String> queries = new ArrayList<>();
        Iterator<JSONObject> iterator = readAdminsJson().iterator();
        while (iterator.hasNext()) {
            JSONObject it = iterator.next();
            if (it.get("name").equals(currentQInputs)) {
                System.out.println(it.get("parameters"));
                return (JSONObject) it.get("parameters");

            }
        }
        return null;
    }

    private static JSONArray readAdminsJson() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        JSONArray queriesList = null;
        try {
            obj = parser.parse(new FileReader(adminsJson));
            JSONObject jsonObject = (JSONObject) obj;
            queriesList = (JSONArray) jsonObject.get("queries");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return queriesList;
    }

}
