package com.sajgure.furniture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sajgure.furniture.dao.UserDAO;
import com.sajgure.furniture.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByEmailId(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new CustomUserDetails(user);
	}

}