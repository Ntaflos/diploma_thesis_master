package com.diploma.thesis.services;

import com.diploma.thesis.data.Queries;
import com.diploma.thesis.data.data_handlers.CsvHandler;
import com.diploma.thesis.models.LocationInfos;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

@Service
public class MapService {

    List<LocationInfos> infos = new ArrayList<>();


    public List<LocationInfos> getAllInfos() {
        CsvHandler.readCsv();
        infos = CsvHandler.getList();
        return infos;
    }

//    public List<LocationInfos> getResultFromQuery(int x){
//        return Queries.scoreQuery(x);
//    }
}
