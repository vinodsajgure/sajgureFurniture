package com.sajgure.furniture.dao;

import java.util.List;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dto.CountsDTO;
import com.sajgure.furniture.entity.Carousel;

public interface CarouselDao extends Dao<Carousel>{
	
	Carousel findById(int id);

	List<Carousel> findByStatus(Status status);

	void updateStatus(int id, Status status);

	void delete(int id);

	CountsDTO findAllStatusCounts();

}
