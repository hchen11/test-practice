package com.example.demo.dao;

import com.example.demo.entity.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUserDao extends JpaRepository<ClientUser, Integer> {
    ClientUser findClientUserByNameAndCompanyAndAndEmailAndAndComment(String name,String company,String email,String comment);
}
