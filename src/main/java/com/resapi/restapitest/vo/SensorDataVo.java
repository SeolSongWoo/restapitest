package com.resapi.restapitest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity(name="sensordata")
public class SensorDataVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "sensor_seq")
    private Integer sensorSeq;
    @Column(nullable = false,name = "turbidity")
    private Double turbidity;
    @Column(nullable = false,name = "temp")
    private Double temp;
    @Column(nullable = false,name = "ph")
    private Double ph;
    @Column(nullable = false,name = "reg_date")
    private LocalDateTime regDate;

    public SensorDataVo(Double turbidity, Double temp, Double ph) {
        this.turbidity = turbidity;
        this.temp = temp;
        this.ph = ph;
    }


    public SensorDataVo() {
        this.turbidity = null;
        this.regDate = null;
        this.temp = null;
        this.sensorSeq = null;
        this.ph = null;
    }
}
