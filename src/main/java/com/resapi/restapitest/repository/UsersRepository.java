package com.resapi.restapitest.repository;


import com.resapi.restapitest.vo.UsersVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersVo, Integer> {

    public UsersVo findByUsersId(String id);

    public UsersVo findByUsersIdAndUsersEmailAndUsersName(String id,String email,String name);


}
