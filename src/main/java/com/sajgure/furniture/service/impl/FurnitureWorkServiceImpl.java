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
import com.sajgure.furniture.dao.FurnitureWorkDao;
import com.sajgure.furniture.dto.FurnitureWorkDto;
import com.sajgure.furniture.entity.FurnitureWork;
import com.sajgure.furniture.service.FurnitureWorkService;

@Service
public class FurnitureWorkServiceImpl implements FurnitureWorkService{
	
	@Autowired
	private FurnitureWorkDao furnitureWorkDao;

	@Override
	public List<FurnitureWork> getAll() {
		return furnitureWorkDao.findAll();
	}

	@Override
	public void saveFurnitureWork(String text, MultipartFile part) throws IOException {
		String fileName = StringUtils.cleanPath(part.getOriginalFilename());
		FurnitureWork furnitureWork = new FurnitureWork();
		furnitureWork.setText(text);
		furnitureWork.setImage(part.getBytes());
		furnitureWork.setFileName(fileName);
		furnitureWork.setType(part.getContentType());
		furnitureWork.setStatus(Status.Inactive);
		furnitureWorkDao.save(furnitureWork);
	}

	@Override
	public void updateStatus(int id, Status status) {
		furnitureWorkDao.updateStatus(id, status);
	}

	@Override
	public void deleteFurnitureWork(int id) {
		furnitureWorkDao.delete(id);		
	}
	
	@Override
	public List<FurnitureWorkDto> convertImages(List<FurnitureWork> all) {
		List<FurnitureWorkDto> items = new ArrayList<>();
		for (FurnitureWork carousel : all) {

			byte[] blob = carousel.getImage();
			String base64Image = Base64.getEncoder().encodeToString(blob);

			FurnitureWorkDto dto = new FurnitureWorkDto(carousel.getId(), base64Image, carousel.getText(), carousel.getFileName(),
					carousel.getType(), carousel.getStatus());

			items.add(dto);
		}
		return items;
	}

	@Override
	public List<FurnitureWorkDto> getActiveImages(Status active) {
		return convertImages(furnitureWorkDao.findByStatus(active));
	}

}
