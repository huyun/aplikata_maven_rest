package com.aplikata.rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aplikata.Constants;
import com.aplikata.HibernateProxyTypeAdapter;
import com.aplikata.bo.User;
import com.aplikata.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UserResource {
	private static final String TOKEN_SECRET = "aliceinwonderland";
	@Autowired
	UserService userService;

	@POST
	@Path("login")
	public Response submitLogin(User user) {
		try {
			user = userService.updateLogin(user.getUserName(), user.getUserPwd());
			user.setUserPwd(null);
			GsonBuilder gb = new GsonBuilder();
			gb.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
			Gson gson = gb.create();

			String token = Jwts.builder().setSubject(gson.toJson(user))
					.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();

			if (StringUtils.isBlank(user.getUserPwdOld())) {
				user.setFirstUrl("/loginpwd");
				user.setToken(null);
			} else if (user.getUserName().equals(Constants.SUPER_ADMIN)) {
				user.setToken(token);
			}

			return Response.ok(user).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@GET
	public List<User> getAllUsers() {
		try {
			List<User> list = userService.getAllUsers();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@POST
	public User saveUser(User user){
		try {
			return userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public User updateUser(User user){
		try {
			return userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/{userId}")
	public User removeUser(@PathParam("userId") long id) {
		try {
			return userService.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
