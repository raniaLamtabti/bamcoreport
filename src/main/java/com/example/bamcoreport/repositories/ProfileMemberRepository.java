package com.example.bamcoreport.repositories;

import com.example.bamcoreport.entities.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileMemberRepository extends JpaRepository<ProfileMember, Long> {

    List<ProfileMember> findAllBy();

}
