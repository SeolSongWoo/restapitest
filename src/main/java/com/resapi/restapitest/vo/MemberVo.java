package com.resapi.restapitest.vo;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberVo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer mbrNo;

    private String id;

    private String name;

    @Builder
    public MemberVo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}