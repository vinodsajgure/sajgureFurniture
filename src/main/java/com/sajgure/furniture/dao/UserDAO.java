package com.sajgure.furniture.dao;

import com.sajgure.furniture.dto.UserCountDTO;
import com.sajgure.furniture.entity.User;

public interface UserDAO extends Dao<User>{
	
	User findById(int emailId);

	User findByEmailId(String email);

	void updateEnabledStatus(String email, boolean status);

	void deleteUserByEmail(String email);

	UserCountDTO findAllStatusCounts();

}
