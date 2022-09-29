package com.diploma.thesis.data.data_handlers;

import com.diploma.thesis.models.LocationInfos;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvHandler {

    private static String csvFile = "src/main/resources/static/files/hotels.csv";
    private static BufferedReader br = null;
    private static String line = "";
    private static String cvsSplitBy = ",";
    private static ArrayList<LocationInfos> list = new ArrayList<>();

    public static void readCsv() {

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                String[] hotel = line.split(cvsSplitBy);
                String des = "Address: " + hotel[0] + "_Score: " + hotel[2] + "_Name: " + hotel[3];
                LocationInfos infos = new LocationInfos(Double.valueOf(hotel[4]), Double.valueOf(hotel[5]), des);
                infos.setName(hotel[3]);
                infos.setScore(Float.parseFloat(hotel[2]));
                infos.setAddress(hotel[0]);
                infos.setCountry(hotel[1]);
                list.add(infos);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static List readCsvToMap() throws IOException {
        CsvListReader csvReader = new CsvListReader(new InputStreamReader(new FileInputStream(csvFile)), CsvPreference.STANDARD_PREFERENCE);
        List<String> header;

        header = new ArrayList<String>(csvReader.read());

        List<String> rowAsTokens;
        List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;

        while ((rowAsTokens = csvReader.read()) != null) {
            //Create Map for each row in CSV
            row = new HashMap<String, String>();

            for (int i = 0; i < header.size(); i++) {
                row.put(header.get(i).replaceAll("\\s", ""), rowAsTokens.get(i).replaceAll("\\s", ""));
            }

            //add Row map to list of rows
            rows.add(row);
        }

    //Iterate
        for (Map<String, String> rowMap : rows) {
            System.out.println(rowMap);
        }
        return rows;
    }

    public static ArrayList<LocationInfos> getList() {
        return list;
    }

}


