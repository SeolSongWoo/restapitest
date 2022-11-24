package com.resapi.restapitest.service;


import com.resapi.restapitest.repository.SensorDataRepository;
import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    @Autowired
    SensorDataRepository sensorDataRepository;

    public SensorDataVo save(SensorDataVo sensorDataVo) {
        sensorDataRepository.save(sensorDataVo);

        return sensorDataVo;
    }

}
