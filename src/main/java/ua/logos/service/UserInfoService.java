package ua.logos.service;

import ua.logos.entity.UserInfo;

public interface UserInfoService {

	void saveUserInfo(UserInfo userInfo);
	
	UserInfo findOneUserInfo(int id);
}
