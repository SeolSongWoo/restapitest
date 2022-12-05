package com.resapi.restapitest.repository;

import com.resapi.restapitest.vo.DataRangeVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRangeRepository extends JpaRepository<DataRangeVo,Integer> {

    public DataRangeVo findTopBy();
}
