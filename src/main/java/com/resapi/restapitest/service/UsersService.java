package com.resapi.restapitest.service;


import com.resapi.restapitest.repository.UsersRepository;
import com.resapi.restapitest.vo.SensorDataVo;
import com.resapi.restapitest.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;




    public UsersVo save(UsersVo usersVo) {
        usersVo.hashPassword(passwordEncoder);
        usersRepository.save(usersVo);
        return usersVo;
    }

    public String check(String id,String password) {
        UsersVo usersVo = usersRepository.findByUsersId(id);
        if(passwordEncoder.matches(password, usersVo.getUsersPassword())) {
            return "로그인성공";
        }
        else {
            return "로그인실패";
        }

    }
}
