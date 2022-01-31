package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.ProfileMemberDto;
import com.example.bamcoreport.entities.ProfileMember;

import java.util.List;

public interface IProfileMemberService {
    List<ProfileMemberDto> getProfileMembers();
    void postProfileMember(ProfileMember profileMember);
}
