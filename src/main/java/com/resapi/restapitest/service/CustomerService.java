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

    public Optional<CustomerVo> findByCust_id(int cust_id){
        Optional<CustomerVo> customer = customerRepository.findById(cust_id);
        return customer;
    }

    public void deleteByCust_id(int cust_id) {
        customerRepository.deleteById(cust_id);
    }

    public CustomerVo save(CustomerVo customer) {
        customerRepository.save(customer);
        return customer;
    }

    public void updateByCust_id(int cust_id, CustomerVo customer) {
        Optional<CustomerVo> e = customerRepository.findById(cust_id);
        if(e.isPresent()) {
            if(customer.getCust_name() != null) e.get().setCust_name(customer.getCust_name());
            if(customer.getCust_email() != null) e.get().setCust_email(customer.getCust_email());
            if(customer.getCust_adress() != null) e.get().setCust_adress(customer.getCust_adress());
            if(customer.getCust_phone_number() != null) e.get().setCust_phone_number(customer.getCust_phone_number());
            customerRepository.save(customer);
        }
    }
}
