package org.flylib.site.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月26日 下午11:21:36 
* 类说明 
*/
@RequestMapping("passport")
@Controller
public class PassportController {
	
	@RequestMapping("login")
	public String login(String username, String password, Integer accountType) {
		
		return "";
	}
	
	@RequestMapping("register")
	public String register(String username, String password, Integer accountType) {
		
		return "";
	}
}
