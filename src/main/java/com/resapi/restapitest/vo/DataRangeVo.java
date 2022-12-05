package com.resapi.restapitest.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="datarange")
public class DataRangeVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "range_id")
    private Integer rangeId;

    @Column(nullable = false,name = "range_temp1")
    private Float rangeTemp1;
    @Column(nullable = false,name = "range_temp2")
    private Float rangeTemp2;

    @Column(nullable = false,name = "range_ph1")
    private Float rangePh1;

    @Column(nullable = false,name = "range_ph2")
    private Float rangePh2;
}
