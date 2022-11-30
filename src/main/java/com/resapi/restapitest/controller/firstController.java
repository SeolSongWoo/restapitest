package com.resapi.restapitest.controller;

import com.resapi.restapitest.Respon.Message;
import com.resapi.restapitest.Respon.StatusEnum;
import com.resapi.restapitest.repository.CustomRepository;
import com.resapi.restapitest.repository.SensorDataRepository;
import com.resapi.restapitest.service.SensorDataService;
import com.resapi.restapitest.service.UsersService;
import com.resapi.restapitest.vo.SensorDataVo;
import com.resapi.restapitest.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
public class firstController {


    @Autowired
    SensorDataService sensorDataService;

    @Autowired
    CustomRepository customRepository;

    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    UsersService usersService;


    /*
    // 모든 회원 조회
    @RequestMapping("users")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> getAllmembers() {
        List<CustomerVo> customers = customRepository.SearchAll();

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(customers);

        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> getMember(@PathVariable("mbrNo") Integer mbrNo) {
        Optional<MemberVo> member = memberService.findById(mbrNo);
        return new ResponseEntity<MemberVo>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Integer mbrNo) {
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
    @PutMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> updateMember(@PathVariable("mbrNo") Integer mbrNo, MemberVo member) {
        memberService.updateById(mbrNo, member);
        return new ResponseEntity<MemberVo>(member, HttpStatus.OK);
    }

     */

    @RequestMapping("data")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> getAllmembers() {
        List<SensorDataVo> sensorDataVoList = sensorDataRepository.findAll();
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(sensorDataVoList);

        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    @GetMapping( value = "/data/{sensorName}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> getAllmembersbySensorName(@PathVariable("sensorName") String sensorName, String regdate) {
        List<SensorDataVo> sensorDataVoList = null;
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        if(regdate == null) {
            sensorDataVoList = sensorDataService.findAllBySensorName(sensorName);
            if (sensorDataVoList.size() == 0) {
                message.setStatus(StatusEnum.NOT_FOUND);
                message.setMessage("400");
            } else {
                message.setStatus(StatusEnum.OK);
                message.setMessage("200");
            }
            message.setData(sensorDataVoList);
        }
        else {
            LocalDateTime StartDate = null;
            LocalDateTime EndDate = null;
            try {
            StartDate = (LocalDate.parse(regdate, DateTimeFormatter.BASIC_ISO_DATE)).atStartOfDay();
            EndDate = (LocalDate.parse(regdate, DateTimeFormatter.BASIC_ISO_DATE)).atTime(LocalTime.MAX);
            }catch (DateTimeParseException e) {
                message.setMessage("날짜형식을 제대로 입력해주세요.");
                System.out.println(e.getLocalizedMessage());
                return new ResponseEntity<>(message,headers, HttpStatus.OK);
            }
            sensorDataVoList = sensorDataService.findAllBySensorNameAndRegDate(sensorName,StartDate,EndDate);
            if (sensorDataVoList.size() == 0) {
                message.setStatus(StatusEnum.NOT_FOUND);
                message.setMessage("400");
            } else {
                message.setStatus(StatusEnum.OK);
                message.setMessage("200");
            }
            message.setData(sensorDataVoList);
        }
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    @GetMapping( value = "/data/{sensorName}/lastdata",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> lastdata(@PathVariable("sensorName") String sensorName) {
        SensorDataVo sensorDataVoList = null;
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            sensorDataVoList = sensorDataService.findTopBySensorNameOrderByRegDateDesc(sensorName);
            message.setStatus(StatusEnum.OK);
            message.setMessage("200");
            message.setData(sensorDataVoList);
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping(value = "/save", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> save(SensorDataVo sensorDataVo) {
        sensorDataService.save(sensorDataVo);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData("성공");
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    @PostMapping(value = "/user/signup", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> UserSignup(UsersVo usersVo) {
        String result = usersService.save(usersVo);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(result);
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    @PostMapping(value="/user/check", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Message> userCheck(String id,String password) {
        String check = usersService.check(id,password);
        System.out.println(id+password);
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(check);

        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

}
