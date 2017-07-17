package com.aplikata.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.aplikata.Constants;
import com.aplikata.HibernateProxyTypeAdapter;
import com.aplikata.bo.Node;
import com.aplikata.bo.NodeItem;
import com.aplikata.bo.User;
import com.aplikata.encoder.MD5PasswordEncoder;
import com.aplikata.encoder.PasswordEncoder;
import com.aplikata.rest.RESTUtil;
import com.aplikata.util.YunDateUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
		user.setUserMenus(getUserMenus(user.getId()));
		user.setFirstUrl(node.getUrl());
		return user;
	}

	@SuppressWarnings("unchecked")
	private String getUserMenus(Long userId){
		if(userId == null || userId <= 0)
			return null;
		
		List<Node> userNodeList = getPublicDao().findByNamedQuery(Node.QY_FIND_USER_NODES, new Object[] { Constants.NODE_TYPE_MENU, userId });
		if(userNodeList == null || userNodeList.isEmpty())
			return null;

		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = gb.create();
		
		Map<Long, Node> map = new HashMap<Long, Node>();
		Type listType = new TypeToken<List<Node>>() {}.getType();
		for (Node node : userNodeList) {
			Node parentNode = node.getParent();
			if(parentNode == null){
				map.put(node.getId(), node);
			}else{
				parentNode = map.get(parentNode.getId());
				List<NodeItem> list = parentNode.getItems();
				if(list == null){
					list = new ArrayList<NodeItem>();
				}
				NodeItem nodeItem = new NodeItem(node.getLabel(), new Gson().toJson(node));
				nodeItem.setRouterLink(new String[]{node.getUrl()});
				list.add(nodeItem);
				parentNode.setItems(list);
				map.put(parentNode.getId(), parentNode);
			}
		}
		
		List<Node> list = new ArrayList<Node>(map.values());
		String json = gson.toJson(list, listType);
		return json;
	}
}
