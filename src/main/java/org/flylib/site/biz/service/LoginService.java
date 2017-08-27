package org.flylib.site.biz.service;

import org.flylib.passport.model.User;
import org.flylib.passport.service.TokenService;
import org.flylib.site.biz.dao.UserDAO;
import org.flylib.site.constant.AccountType;
import org.flylib.site.constant.UserStatus;
import org.flylib.site.model.LoginResult;
import org.flylib.site.util.DateTool;
import org.flylib.site.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.flylib.passport.constant.MobResponseCode;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午11:35:32 
* 类说明 
*/
@Service
public class LoginService {
	public static final Long tokenExpire = 1000000000L;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private TokenService tokenService;
	
	public LoginResult register(String username, String password, Integer accountType) {
		User user = new User();
		String encodedPassword = MD5Util.md5(password).toLowerCase();
		user.setPassword(encodedPassword);
		setUsername(username, accountType, user);
		user.setStatus(UserStatus.active);
		int insertedCount = userDAO.insert(user);
		Long userId = user.getId();
		LoginResult loginResult = new LoginResult();
		if (insertedCount == 1) {
			// 产生token并存入数据库
			String token = MD5Util.md5(DateTool.getTime() + password).toLowerCase();
			Integer count = tokenService.insert(userId, token, tokenExpire);
			
			loginResult.setUserId(userId);
			loginResult.setToken(token);
			loginResult.setUsername(username);
			loginResult.setCode(MobResponseCode.SUCCESS);
		} else {
			loginResult.setUserId(userId);
			loginResult.setToken("");
			loginResult.setUsername(username);
			loginResult.setCode(MobResponseCode.USERCENTER_ERROR);
		}
		return loginResult;
	}
	
	public LoginResult login(String username, String password, Integer accountType) {
		String encodedPassword = MD5Util.md5(password).toLowerCase();
		String passwordInDB = "";
		User user = new User();
		switch (accountType) {
		case AccountType.MOBILE :
			if (username.length() == 11 && username.charAt(0) == '1') {
				user = userDAO.getUserByMobile(username);
			}
			break;
		case AccountType.EMAIL : 
			if (username.contains("@")) {
				user = userDAO.getUserByEmail(username);
			}
			break;
		}
		passwordInDB = user.getPassword();
		Long userId = user.getId();
		String code = MobResponseCode.USERCENTER_ERROR;
		String token = "";
		if (encodedPassword.equals(passwordInDB)) {
			token = tokenService.getToken(userId);
			code = MobResponseCode.SUCCESS;
		} 
		LoginResult loginResult = new LoginResult();
		loginResult.setUserId(userId);
		loginResult.setToken(token);
		loginResult.setUsername(username);
		loginResult.setCode(code);
		return loginResult;
	}
	
	private void setUsername(String username, Integer accountType, User user) {
		switch (accountType) {
		case AccountType.MOBILE :
			if (username.length() == 11 && username.charAt(0) == '1') {
				user.setMobile(username);
			}
			break;
		case AccountType.EMAIL : 
			if (username.contains("@")) {
				user.setEmail(username);	
			}
			break;
		case AccountType.WECHAT :
			user.setOpenid(username);
			break;
		}
	}
}
