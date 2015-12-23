package com.star.redis;

import com.star.redis.annotation.RedisObjectField;
import com.star.redis.annotation.RedisObjectFieldId;
import com.star.redis.annotation.RedisObjectKey;

/**
 *
 * @author: 王明星(WangMingXing)
 * @En_Name: Star.Wang
 * @E-mail: hiwangmx@gmail.com
 * @version: normal
 * @Created Time: 2015年12月23日 上午9:51:33
 * @Description: 用于例子
 **/

@RedisObjectKey("user")
public class User{

	@RedisObjectFieldId
	@RedisObjectField("user_name")
	private String userName;
	private String password;
	private String mail;
	private String qq;
	private String mobile;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
