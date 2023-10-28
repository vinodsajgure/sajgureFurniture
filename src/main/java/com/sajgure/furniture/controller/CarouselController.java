package com.sajgure.furniture.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dto.CarouselDto;
import com.sajgure.furniture.service.CarouselService;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselService carouselService;

	@GetMapping
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("admin-pages/carousel");
		//view.addObject("carousels", carouselService.convertImages(carouselService.getAll()));
		return view;
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CarouselDto> get() {
		return carouselService.convertImages(carouselService.getAll());
	}

    @PostMapping
	public String saveCarousel(@RequestParam(name = "text", required = false) String text, @RequestParam(name = "file", required = false) MultipartFile part) throws IOException {
		carouselService.saveCarousele(text, part);
		return "redirect:carousel";
	}
	
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCarouselStatus(@PathVariable("id") int id, @RequestParam(name = "status") Status status){
		carouselService.updateCarouseleStatus(id, status);
	}

    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteCarousel(@PathVariable("id") int id){
		carouselService.deleteCarousele(id);
	}
}
