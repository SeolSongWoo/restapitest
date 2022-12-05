package com.resapi.restapitest.schedule;

import com.resapi.restapitest.repository.CustomRepository;
import com.resapi.restapitest.repository.SensorDataRepository;
import com.resapi.restapitest.service.SensorDataService;
import com.resapi.restapitest.service.UsersService;
import com.resapi.restapitest.vo.SensorDataVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
@EnableAsync
public class Schedule {
    @Autowired
    SensorDataService sensorDataService;

    @Autowired
    CustomRepository customRepository;

    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    UsersService usersService;


    @Scheduled(fixedDelay = 3600000)
    public void scheduleFixedRateTask() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity("http://192.168.0.2/", String.class);
        StringBuilder sb = new StringBuilder(response.getBody());
        sb.deleteCharAt(sb.length()-2);
        JSONObject jsonObject = new JSONObject(sb.toString());
        BigDecimal turbidity = jsonObject.getBigDecimal("turbidity");
        BigDecimal ph = jsonObject.getBigDecimal("PH");
        BigDecimal temp = jsonObject.getBigDecimal("temp");
        SensorDataVo sensorDataVo = new SensorDataVo(turbidity.doubleValue(),temp.doubleValue(),ph.doubleValue());
        sensorDataService.save(sensorDataVo);
    }
}
