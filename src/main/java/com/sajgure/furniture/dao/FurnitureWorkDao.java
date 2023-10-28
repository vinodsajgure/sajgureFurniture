package com.sajgure.furniture.dao;

import java.util.List;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.entity.FurnitureWork;

public interface FurnitureWorkDao extends Dao<FurnitureWork>{
	
	FurnitureWork findById(int id);

	void delete(int id);

	void updateStatus(int id, Status status);

	List<FurnitureWork> findByStatus(Status active);
	
}
