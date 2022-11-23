package com.resapi.restapitest.service;


import com.resapi.restapitest.repository.CustomerRepository;
import com.resapi.restapitest.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerVo> findAll() {
        List<CustomerVo> customers = new ArrayList<>();
        customerRepository.findAll().forEach(e -> customers.add(e));
        return customers;
    }

    public Optional<CustomerVo> findById(Integer cus_id) {
        Optional<CustomerVo> customers = customerRepository.findById(cus_id);
        return customers;
    }

    public void deleteById(Integer cus_id) {
        customerRepository.deleteById(cus_id);
    }

    public CustomerVo save(CustomerVo customer) {
        customerRepository.save(customer);
        return customer;
    }

    public void updateById(Integer mbrNo, CustomerVo customer) {
        Optional<CustomerVo> e = customerRepository.findById(mbrNo);

        if (e.isPresent()) {
            e.get().setCusName(customer.getCusName());
            e.get().setCusAdress(customer.getCusAdress());
            e.get().setCusPhonenumber(customer.getCusPhonenumber());
            customerRepository.save(customer);
        }
    }
}
