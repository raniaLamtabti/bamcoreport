package com.example.bamcoreport.repositories;

import com.example.bamcoreport.entities.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContactInfoRepository extends JpaRepository<UserContactInfo, Long> {

    List<UserContactInfo> findAllBy();








}
