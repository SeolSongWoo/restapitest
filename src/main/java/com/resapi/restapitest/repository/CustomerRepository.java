package com.resapi.restapitest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.resapi.restapitest.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerVo, Integer> {

    public List<CustomerVo> findByCusId(String cus_id);

    public List<CustomerVo> findByCusName(String cus_name);

}
