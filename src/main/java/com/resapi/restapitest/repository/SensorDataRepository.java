package com.resapi.restapitest.repository;

import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataVo,Integer> {

    public List<SensorDataVo> findAll();


    @Query(value = "SELECT turbidity,reg_date FROM sensordata ORDER BY reg_date DESC LIMIT 170",nativeQuery = true)
    public List<Object> findNtuAll();
    @Query(value = "SELECT ph,reg_date FROM sensordata ORDER BY reg_date DESC LIMIT 170",nativeQuery = true)
    public List<Object> findPhAll();
    @Query(value = "SELECT temp,reg_date FROM sensordata ORDER BY reg_date DESC LIMIT 170",nativeQuery = true)
    public List<Object> findTempAll();

    /*
    public List<SensorDataVo> findAllBySensorNameOrderByRegDateDesc(String SensorName);

    public List<SensorDataVo> findAllByRegDateGreaterThanEqualAndRegDateLessThanEqual(LocalDateTime StartDate,LocalDateTime EndDate);

    public List<SensorDataVo> findAllBySensorNameAndRegDateGreaterThanEqualAndRegDateLessThanEqual(String SensorName, LocalDateTime StartDate, LocalDateTime EndDate);

    public SensorDataVo findTopBySensorNameOrderByRegDateDesc(String SensorName);

    public SensorDataVo findTopBySensorNameOrderByRegDateDesc(String SensorName);*/


}
