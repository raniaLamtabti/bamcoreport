package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.UserContactInfoDto;
import com.example.bamcoreport.entities.UserContactInfo;

import java.util.List;

public interface IUserContactInfoService {

    List<UserContactInfoDto> getUsersContactInfo();
    void postUserContactInfo(UserContactInfo userContactInfo);
}
