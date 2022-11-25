package com.resapi.restapitest.repository;

import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataVo,Integer> {

    public List<SensorDataVo> findAll();

    public List<SensorDataVo> findAllBySensorName(String SensorName);

    public List<SensorDataVo> findAllByRegDateGreaterThanEqualAndRegDateLessThanEqual(LocalDateTime StartDate,LocalDateTime EndDate);

    public List<SensorDataVo> findAllBySensorNameAndRegDateGreaterThanEqualAndRegDateLessThanEqual(String SensorName, LocalDateTime StartDate, LocalDateTime EndDate);


}
