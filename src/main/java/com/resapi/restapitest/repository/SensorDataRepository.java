package com.resapi.restapitest.repository;

import com.resapi.restapitest.vo.SensorDataVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataVo,Integer> {




}
