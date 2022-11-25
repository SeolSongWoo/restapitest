package com.resapi.restapitest.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="sensordata")
public class SensorDataVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "sensor_seq")
    private Integer sensorSeq;

    @Column(nullable = true,name = "sensor_name")
    private String sensorName;
    @Column(nullable = true,name = "sensor_value")
    private Float sensorValue;

    @Column(nullable = true,name = "reg_date")
    private LocalDateTime regDate;

}
