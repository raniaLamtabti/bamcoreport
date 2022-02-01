package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.ProfileMemberDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.ProfileMember;
import com.example.bamcoreport.repositories.ProfileMemberRepository;
import com.example.bamcoreport.services.Impl.IProfileMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileMemberService implements IProfileMemberService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

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

    @Override
    public void deleteProfileMember(Long profileMemberId) {
        boolean exists =  profileMemberRepository.existsById(profileMemberId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        profileMemberRepository.deleteById(profileMemberId);
    }
}
