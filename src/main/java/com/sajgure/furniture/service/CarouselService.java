package com.sajgure.furniture.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dto.CarouselDto;
import com.sajgure.furniture.dto.CountsDTO;
import com.sajgure.furniture.entity.Carousel;

public interface CarouselService {
	
	List<Carousel> getAll();

	void saveCarousele(String text, MultipartFile part) throws IOException;

	List<CarouselDto> convertImages(List<Carousel> all);

	List<CarouselDto> getActiveImages(Status status);

	void updateCarouseleStatus(int id, Status status);

	void deleteCarousele(int id);

	CountsDTO getCarouselCounts();
}
