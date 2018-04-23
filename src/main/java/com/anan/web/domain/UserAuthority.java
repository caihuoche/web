package com.anan.web.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * @author yanghaiyu
 * @date 2018/03/16
 **/
public class UserAuthority implements GrantedAuthority {

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	private String authority;

	public UserAuthority(String authority) {
		Assert.hasText(authority, "权限不能为空");
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
