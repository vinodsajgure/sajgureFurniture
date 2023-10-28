package com.sajgure.furniture.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dto.FurnitureWorkDto;
import com.sajgure.furniture.entity.FurnitureWork;

public interface FurnitureWorkService {

	List<FurnitureWork> getAll();

	void saveFurnitureWork(String text, MultipartFile part) throws IOException;

	void updateStatus(int id, Status status);

	void deleteFurnitureWork(int id);

	List<FurnitureWorkDto> convertImages(List<FurnitureWork> all);

	List<FurnitureWorkDto> getActiveImages(Status active);

}
