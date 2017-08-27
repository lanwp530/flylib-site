package org.flylib.site.model;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月27日 上午11:15:52 
* 类说明 
*/
public class LoginResult {
	private Long userId;
	private String token;
	private String username;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
