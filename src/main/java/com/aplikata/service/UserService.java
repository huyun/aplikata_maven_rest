package com.aplikata.service;

import java.util.List;

import com.aplikata.bo.User;

public interface UserService extends PublicService {

	User updateLogin(String userName, String userPwd) ;

	List<User> getAllUsers();

	User updateUser(User user) throws Exception;

	User deleteUser(long id) throws Exception;

}
