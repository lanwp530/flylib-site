package org.flylib.site.account.controller;

import org.flylib.passport.annotation.Auth;
import org.flylib.passport.controller.Authed;
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
@Auth
public class AccountController implements Authed {
	@RequestMapping("login")
	@ResponseBody
	public String login(String userId, String token) {
		return "login success.";
	}
}
