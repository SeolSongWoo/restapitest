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




    public String save(UsersVo usersVo) {
        usersVo.hashPassword(passwordEncoder);
        Object nullcheck = usersRepository.saveAndFlush(usersVo);
        if(nullcheck == null) {
            return "회원가입실패";
        }else {
            return "회원가입성공";
        }
    }

    public String check(String id,String password) {
        UsersVo usersVo = usersRepository.findByUsersId(id);
        if(usersVo == null) {
            return "계정없음";
        }
        if(passwordEncoder.matches(password, usersVo.getUsersPassword())) {
            return "로그인성공";
        }
        else {
            return "비밀번호틀림";
        }

    }
}
