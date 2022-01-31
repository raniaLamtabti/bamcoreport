package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.ProfileMemberDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.ProfileMember;
import com.example.bamcoreport.repositories.ProfileMemberRepository;
import com.example.bamcoreport.services.Impl.IProfileMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileMemberService implements IProfileMemberService {
    @Autowired
    ProfileMemberRepository profileMemberRepository;

    @Autowired
    IMapClassWithDto<ProfileMember, ProfileMemberDto> ProfileMemberMapping;

    @Override
    public List<ProfileMemberDto> getProfileMembers()  {
        List<ProfileMember> ProfileMembers = profileMemberRepository.findAll();
        return ProfileMemberMapping.convertListToListDto(ProfileMembers,ProfileMemberDto.class);
    }

    @Override
    public void postProfileMember(ProfileMember profileMember) {
        profileMemberRepository.save(profileMember);
    }
}
