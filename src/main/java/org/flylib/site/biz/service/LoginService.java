package org.flylib.site.biz.service;

import org.flylib.passport.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午11:35:32 
* 类说明 
*/
@Service
public class LoginService {
	@Autowired
	private UserDAO userDAO;
	
	public void register(String username, String password, Integer accountType) {
		
	}
}
