package com.resapi.restapitest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepository {
    @Autowired
    JPAQueryFactory factory;

    /*
    public CustomerVo SearchId(Integer no) {
        QCustomerVo qCustomerVo = QCustomerVo.customerVo;

        CustomerVo customerVos = factory.from(qCustomerVo).where(qCustomerVo.cusId.eq(no)).select(qCustomerVo).fetchFirst();

        return customerVos;
    }

    public List<CustomerVo> SearchAll() {
        QCustomerVo qCustomerVo = QCustomerVo.customerVo;

        List<CustomerVo> customerVos = factory.from(qCustomerVo).from(qCustomerVo).select(qCustomerVo).fetch();

        return customerVos;
    }

     */

}
