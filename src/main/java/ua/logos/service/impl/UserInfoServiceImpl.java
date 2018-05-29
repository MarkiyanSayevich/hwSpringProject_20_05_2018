package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.UserInfo;
import ua.logos.repository.UserInfoRepository;
import ua.logos.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired UserInfoRepository userInforepository;
	
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		userInforepository.save(userInfo);
	}

	@Override
	public UserInfo findOneUserInfo(int id) {
		return userInforepository.getOne(id);
	}

}
