package org.flylib.site.account.controller;

import org.flylib.passport.annotation.AuthController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月21日 下午10:28:35 
* 类说明 
*/
@RequestMapping("account")
@Controller
@AuthController
public class AccountController {
	@RequestMapping("login")
	@ResponseBody
	public String login(String userId, String token) {
		return "login success.";
	}
}
