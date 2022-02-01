package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.ProfileDto;
import com.example.bamcoreport.entities.Profile;
import com.example.bamcoreport.entities.Role;

import java.util.List;

public interface IProfileService {
    List<ProfileDto> getProfiles();
    void postProfile(Profile profile);
    void deleteProfile(Long profileId);
}
