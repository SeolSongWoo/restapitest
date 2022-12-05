package com.resapi.restapitest.service;


import com.resapi.restapitest.repository.SensorDataRepository;
import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class SensorDataService {

    @Autowired
    SensorDataRepository sensorDataRepository;

    public SensorDataVo save(SensorDataVo sensorDataVo) {
        sensorDataVo.setRegDate(LocalDateTime.now());
        sensorDataRepository.save(sensorDataVo);

        return sensorDataVo;
    }

    public List<Object> findSensorData(String sensorName) {
        List<Object> sensorDataVo = null;
        if(sensorName.equals("ntu")) {
            sensorDataVo = sensorDataRepository.findNtuAll();
        }else if(sensorName.equals("ph")) {
            sensorDataVo = sensorDataRepository.findPhAll();
        }else if(sensorName.equals("temp")) {
            sensorDataVo = sensorDataRepository.findTempAll();
        }else {
            sensorDataVo = Collections.singletonList(sensorDataRepository.findAll());
        }
        return sensorDataVo;
    }

/*    public List<SensorDataVo> findAllBySensorName(String sensorName) {
        List<SensorDataVo> sensorDataVoList = null;
        if(sensorName.equals("all")) {
            sensorDataVoList = sensorDataRepository.findAll();
        } else{
            sensorDataVoList = sensorDataRepository.findAllBySensorNameOrderByRegDateDesc(sensorName);
        }

        return sensorDataVoList;
    }

    public List<SensorDataVo> findAllBySensorNameAndRegDate(String sensorName, LocalDateTime StartDate, LocalDateTime EndDate) {
        List<SensorDataVo> sensorDataVoList = null;
        if(sensorName.equals("all")) {
            sensorDataVoList = sensorDataRepository.findAllByRegDateGreaterThanEqualAndRegDateLessThanEqual(StartDate,EndDate);
        } else{
            sensorDataVoList = sensorDataRepository.findAllBySensorNameAndRegDateGreaterThanEqualAndRegDateLessThanEqual(sensorName,StartDate,EndDate);
        }

        return sensorDataVoList;
    }

    public SensorDataVo findTopBySensorNameOrderByRegDateDesc(String sensorName) {
        SensorDataVo sensorDataVo = sensorDataRepository.findTopBySensorNameOrderByRegDateDesc(sensorName);
        return sensorDataVo;
    }

    public SensorDataVo findTopBySensorNameOrderByRegDateDesc(String sensorName) {
        SensorDataVo sensorDataVo;
        sensorDataVo = sensorDataRepository.findTopBySensorNameOrderByRegDateDesc(sensorName);
        return sensorDataVo;
    }*/



}
