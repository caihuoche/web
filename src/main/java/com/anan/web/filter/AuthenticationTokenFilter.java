package com.anan.web.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anan.web.domain.User;
import com.anan.web.domain.UserAuthority;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author yanghaiyu
 * @date 2018/03/17
 **/
public class AuthenticationTokenFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		String authToken = request.getHeader("Authorization");
		// 从请求头出解析出token  然后那token解析出用户, 然后把用户放在security里,这样用户就有了权限

		if ("789".equals(authToken) && SecurityContextHolder.getContext().getAuthentication() == null) {

			User user = new User("1234", "456");
			ArrayList<UserAuthority> list = new ArrayList<>();
			list.add(new UserAuthority("ROLE_ADMIN"));
			user.setAuthorites(list);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, (Object)null, user.getAuthorities());
			authentication.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request,httpServletResponse);
	}
}
