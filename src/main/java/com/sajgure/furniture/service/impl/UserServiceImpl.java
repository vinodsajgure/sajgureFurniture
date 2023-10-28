package com.sajgure.furniture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sajgure.furniture.dao.UserDAO;
import com.sajgure.furniture.dto.UserCountDTO;
import com.sajgure.furniture.entity.User;
import com.sajgure.furniture.service.UserService;
import com.sajgure.furniture.util.Utility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public User getUserByEmailId(String email) {
		return userDao.findByEmailId(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User entity) {
		// business logic
		if(!entity.getPassword().isEmpty()) {
			entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
		}
		userDao.save(entity);
	}

	@Override
	public void updateStatus(String email, boolean status) {
		userDao.updateEnabledStatus(email, status);
	}

	@Override
	public void deleteUser(String email) {
		userDao.deleteUserByEmail(email);
	}
	
	@Override
	public UserCountDTO getUserCounts() {
		UserCountDTO counts =userDao.findAllStatusCounts();
		counts.setEnabledPerc(Utility.percent(counts.getEnabled(), counts.getTotal()));
		counts.setDisabledPerc(Utility.percent(counts.getDisabled(), counts.getTotal()));
		return userDao.findAllStatusCounts();
	}
}
