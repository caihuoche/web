package com.anan.web.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author yanghaiyu
 * @date 2018/03/16
 **/
public class User implements UserDetails {

	private String name;
	private String password;
	private List<UserAuthority> userAuthorites;

	public User() {
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setAuthorites(List<UserAuthority> userAuthorites) {
		this.userAuthorites = userAuthorites;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<UserAuthority> getAuthorities() {
		return userAuthorites;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
