package com.resapi.restapitest.repository;

import com.resapi.restapitest.vo.CustomerVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerVo, Integer> {

    public List<CustomerVo> findByCust_id(String id);

    public List<CustomerVo> findByCust_nameLike(String name);
}
