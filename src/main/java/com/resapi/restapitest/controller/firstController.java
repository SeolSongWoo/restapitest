package com.resapi.restapitest.controller;

import com.resapi.restapitest.service.CustomerService;
import com.resapi.restapitest.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class firstController {

    @Autowired
    CustomerService customerService;



    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CustomerVo>> getAllcustomer() {
        List<CustomerVo> customers = customerService.findAll();

        return new ResponseEntity<List<CustomerVo>>(customers, HttpStatus.OK);
    }
}
