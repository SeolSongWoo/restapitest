package com.resapi.restapitest.service;


import com.resapi.restapitest.repository.SensorDataRepository;
import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<SensorDataVo> findAllBySensorName(String sensorName) {
        List<SensorDataVo> sensorDataVoList = null;
        if(sensorName.equals("all")) {
            sensorDataVoList = sensorDataRepository.findAll();
        } else{
            sensorDataVoList = sensorDataRepository.findAllBySensorName(sensorName);
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



}
