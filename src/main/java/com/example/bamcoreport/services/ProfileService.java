package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.ProfileDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.repositories.ProfileRepository;
import com.example.bamcoreport.services.Impl.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements IProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    IMapClassWithDto<Profile, ProfileDto> ProfileMapping;

    @Override
    public List<ProfileDto> getProfiles() {
        List<Profile> Profiles = profileRepository.findAll();
        return ProfileMapping.convertListToListDto(Profiles,ProfileDto.class);
    }

    @Override
    public void postProfile(Profile profile) {
        profileRepository.save(profile);
    }
}
