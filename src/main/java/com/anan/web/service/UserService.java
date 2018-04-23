package com.anan.web.service;

import java.util.ArrayList;

import com.anan.web.domain.User;
import com.anan.web.domain.UserAuthority;
import com.anan.web.rest.LoginResource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yanghaiyu
 * @date 2018/03/16
 **/
@Service
public class UserService implements UserDetailsService {
	/**
	 * 验证方法
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		String password = LoginResource.local.get();
		// 用户名123的时候 给他个没权限
		if ("123".equals(username)){
			return new User();
		}
		if ("456".equals(password)) {
			User user = new User(username, password);
			ArrayList<UserAuthority> list = new ArrayList<>();
			list.add(new UserAuthority("ROLE_ADMIN"));
			user.setAuthorites(list);
			return user;
		} else {
			throw new UsernameNotFoundException("密码错误");
		}
	}
}
