package com.resapi.restapitest.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public class SensorDataVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "sensor_seq")
    private Integer sensorSeq;

    @Column(nullable = true,name = "sensor_ntu")
    private float ntu;
    @Column(nullable = true,name = "sensor_ph")
    private float ph;
    @Column(nullable = true,name = "sensor_temp")
    private float temp;
}
