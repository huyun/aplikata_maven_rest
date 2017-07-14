package com.aplikata.service;

import com.aplikata.bo.User;

public interface UserService extends PublicService{

	User updateLogin(String userName, String userPwd) throws Exception;

}
