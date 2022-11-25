package com.resapi.restapitest.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="users")
public class UsersVo{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "users_seq")
    private Integer usersSeq;

    @Column(nullable = false,name = "users_id")
    private String usersId;
    @Column(nullable = false,name = "users_Password")
    private String usersPassword;

    @Column(nullable = false,name = "users_name")
    private String usersName;

    @Column(nullable = false,name = "users_email")
    private String usersEmail;

    public void hashPassword(PasswordEncoder passwordEncoder) {
        this.usersPassword = passwordEncoder.encode(this.usersPassword);
    }
}
