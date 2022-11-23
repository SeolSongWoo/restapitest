package com.resapi.restapitest.vo;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer")
public class CustomerVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "cus_id")
    private Integer cusId;

    @Column(nullable = true,name = "cus_name")
    private String cusName;
    @Column(nullable = true,name = "cus_adress")
    private String cusAdress;
    @Column(nullable = true,name = "cus_phonenumber")
    private String cusPhonenumber;

    @Builder

    public CustomerVo(String cusName, String cusAdress, String cusPhonenumber) {
        this.cusName = cusName;
        this.cusAdress = cusAdress;
        this.cusPhonenumber = cusPhonenumber;
    }
}
