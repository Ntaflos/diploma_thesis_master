package com.diploma.thesis.controllers;

import com.diploma.thesis.data.Queries;
import com.diploma.thesis.data.data_handlers.CsvHandler;
import com.diploma.thesis.data.data_handlers.JsonHandler;
import com.diploma.thesis.models.LocationInfos;
import com.diploma.thesis.services.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MapController {

    @Autowired
    MapService service;
    private static String curQ;

    @GetMapping("/")
    public String index(Model model) throws IOException {
        Queries queries = new Queries();
        CsvHandler.readCsvToMap();
        model.addAttribute("queriesNames", queries.getQueriesNames());
        model.addAttribute("queries", queries);

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchInit(@ModelAttribute(value = "queries") Queries queries, Model model) {
        queries.setCurrentQInputs(JsonHandler.setCurrentQInputs(queries.getCurrentQ()));
        System.out.println(queries.getCurrentQ());
        curQ = queries.getCurrentQ();
        model.addAttribute("infos", queries.getCurrentQInputs());
        model.addAttribute("queries", queries);
        return "search";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String search(@ModelAttribute(value = "queries") Queries queries, Model model) {
        System.out.println(curQ);

        try {
            Class<?> clazz = Class.forName("com.diploma.thesis.data.Queries");
            Method method = clazz.getMethod(getCurQ(), ArrayList.class);
            List<LocationInfos> list = (List<LocationInfos>) method.invoke(null, queries.getInputResults());
            model.addAttribute("loc", list);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "result";
    }

    public static String getCurQ() {
        return curQ;
    }
}
