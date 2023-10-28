package com.sajgure.furniture.service;

import java.util.List;

import com.sajgure.furniture.dto.UserCountDTO;
import com.sajgure.furniture.entity.User;

public interface UserService {
	
	public List<User> getAll();
	
	public User getUserById(int id);
	
	public void save(User entity);

	public User getUserByEmailId(String email);

	public void updateStatus(String email, boolean status);

	public void deleteUser(String email);

	UserCountDTO getUserCounts();

}
