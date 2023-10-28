package com.sajgure.furniture.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dao.CarouselDao;
import com.sajgure.furniture.dto.CarouselDto;
import com.sajgure.furniture.dto.CountsDTO;
import com.sajgure.furniture.entity.Carousel;
import com.sajgure.furniture.service.CarouselService;
import com.sajgure.furniture.util.Utility;

@Service
public class CarouselServiceImpl implements CarouselService {

	@Autowired
	private CarouselDao carouselDao;

	@Override
	public List<Carousel> getAll() {
		return carouselDao.findAll();
	}

	@Override
	public void saveCarousele(String text, MultipartFile part) throws IOException {
		String fileName = StringUtils.cleanPath(part.getOriginalFilename());
		Carousel carousel = new Carousel();
		carousel.setText(text);
		carousel.setImage(part.getBytes());
		carousel.setFileName(fileName);
		carousel.setType(part.getContentType());
		carousel.setStatus(Status.Inactive);
		carouselDao.save(carousel);
	}

	@Override
	public List<CarouselDto> convertImages(List<Carousel> all) {
		List<CarouselDto> items = new ArrayList<>();
		for (Carousel carousel : all) {

			byte[] blob = carousel.getImage();
			String base64Image = Base64.getEncoder().encodeToString(blob);

			CarouselDto dto = new CarouselDto(carousel.getId(), base64Image, carousel.getText(), carousel.getFileName(),
					carousel.getType(), carousel.getStatus());

			items.add(dto);
		}
		return items;
	}
	
	@Override
	public List<CarouselDto> getActiveImages(Status status) {
		List<Carousel> carousels = carouselDao.findByStatus(status);
		return convertImages(carousels);
	}

	@Override
	public void updateCarouseleStatus(int id, Status status) {
		carouselDao.updateStatus(id, status);
	}

	@Override
	public void deleteCarousele(int id) {
		carouselDao.delete(id);		
	}

	@Override
	public CountsDTO getCarouselCounts() {
		CountsDTO counts = carouselDao.findAllStatusCounts();
		counts.setActivePerc(Utility.percent(counts.getActive(), counts.getTotal()));
		counts.setInactivePerc(Utility.percent(counts.getInactive(), counts.getTotal()));
		return counts;
	}
}
