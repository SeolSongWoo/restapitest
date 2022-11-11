package com.resapi.restapitest.vo;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="customer")
public class CustomerVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id;

    private String cust_name;
    private String cust_adress;
    private String cust_phone_number;
    private String cust_email;
    private int root;

}
