package com.sajgure.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.service.CarouselService;
import com.sajgure.furniture.service.FurnitureWorkService;

@Controller
public class IndexController {
	
	@Autowired
	private CarouselService carouselService;
	
	@Autowired
	private FurnitureWorkService fwService;
	
	@GetMapping("/")
	public ModelAndView getIndexPage() {
		ModelAndView view = new ModelAndView("index");
		view.addObject("carousels", carouselService.getActiveImages(Status.Active));
		view.addObject("furnitureWorks", fwService.getActiveImages(Status.Active));
		return view;
	}
}
