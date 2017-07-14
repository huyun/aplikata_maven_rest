package com.aplikata.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.aplikata.Constants;
import com.aplikata.bo.Node;
import com.aplikata.bo.User;
import com.aplikata.encoder.MD5PasswordEncoder;
import com.aplikata.encoder.PasswordEncoder;
import com.aplikata.rest.RESTUtil;
import com.aplikata.util.YunDateUtil;

@Service("userService")
public class UserServiceImpl extends PublicServiceImpl implements UserService{

	@Autowired
	MessageSource messageSource;
	
	@SuppressWarnings("unchecked")
	@Override
	public User updateLogin(String userName, String userPwd) throws Exception{
		User user = null;
		if (StringUtils.isBlank(userName)) {
			throw new Exception(RESTUtil.getRequiredMsg(messageSource, User.LB_USER_NAME));
		}
		if (StringUtils.isBlank(userPwd)) {
			throw new Exception(RESTUtil.getRequiredMsg(messageSource, User.LB_USER_PWD));
		}
		user = (User) getPublicDao().getUniqueByProperty(User.class, User.USER_NAME, userName);
		if (user == null) {
			throw new Exception(RESTUtil.getMsg(messageSource, Constants.MSG_LOGIN_BAD_NAME_PWD));
		}

		PasswordEncoder encoder = new MD5PasswordEncoder();
		if (!encoder.encode(userPwd).equals(user.getUserPwd())) {
			throw new Exception(RESTUtil.getMsg(messageSource, Constants.MSG_LOGIN_BAD_NAME_PWD));
		}

		if (user.isBlocked()) {
			throw new Exception(RESTUtil.getMsg(messageSource, Constants.MSG_LOGIN_STATUSNOTNORMAL));
		}

		if (user.getDomain() != null && user.getDomain().isBlocked()) {
			throw new Exception(RESTUtil.getMsg(messageSource, Constants.MSG_LOGIN_STATUSNOTNORMAL));
		}
		Node node = (Node)getPublicDao().findByNamedQuery("Node.getUserFirstMenu",
				new Object[] { user.getId() }).get(0);
		
		user.setLastLoginTime(YunDateUtil.getDateTime().toString());
		getPublicDao().update(user);
		//user.setUserMenus(getUserMenus(user.getId()));
		user.setFirstUrl(node.getUrl());
		return user;
	}

}
