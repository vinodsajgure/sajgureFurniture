package com.sajgure.furniture.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dto.FurnitureWorkDto;
import com.sajgure.furniture.service.FurnitureWorkService;

@Controller
@RequestMapping("/furniture-work")
public class FurnitureWorkController {

	@Autowired
	private FurnitureWorkService furnitureService;

	@RequestMapping(method = RequestMethod.GET)
	public String getPage() {
		return "admin-pages/furniture-work";
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<FurnitureWorkDto> getAll() {
		return furnitureService.convertImages(furnitureService.getAll());
	}

	@PostMapping
	public String saveFurnitureWork(@RequestParam(name = "text", required = false) String text,
			@RequestParam(name = "file", required = false) MultipartFile part) throws IOException {
		furnitureService.saveFurnitureWork(text, part);
		return "redirect:furniture-work";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCarouselStatus(@PathVariable("id") int id, @RequestParam(name = "status") Status status) {
		furnitureService.updateStatus(id, status);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteCarousel(@PathVariable("id") int id) {
		furnitureService.deleteFurnitureWork(id);
	}

}
