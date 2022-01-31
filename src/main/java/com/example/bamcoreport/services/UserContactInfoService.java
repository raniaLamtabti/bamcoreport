package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.UserContactInfoDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.entities.UserContactInfo;
import com.example.bamcoreport.repositories.UserContactInfoRepository;
import com.example.bamcoreport.services.Impl.IUserContactInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactInfoService implements IUserContactInfoService {

    private static final Logger log = LoggerFactory.getLogger(UserContactInfoService.class);

    @Autowired
    UserContactInfoRepository userContactInfoRepository;

    @Autowired
    IMapClassWithDto<UserContactInfo, UserContactInfoDto> userMapping;

    @Override
    public List<UserContactInfoDto> getUsersContactInfo() {
        List<UserContactInfo> userContactInfos = userContactInfoRepository.findAll();
        return userMapping.convertListToListDto(userContactInfos,UserContactInfoDto.class);
    }
    public void postUserContactInfo(UserContactInfo userContactInfo) {
        userContactInfoRepository.save(userContactInfo);
    }
}
