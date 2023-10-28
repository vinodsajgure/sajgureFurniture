package com.sajgure.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sajgure.furniture.service.CarouselService;
import com.sajgure.furniture.service.EnquiryService;
import com.sajgure.furniture.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private CarouselService carouselService;
	
	@Autowired
	private EnquiryService enquiryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	public ModelAndView getAdminPage() {
		ModelAndView view = new ModelAndView("admin-pages/admin");
		// carousels total count & active count
		view.addObject("carouselCounts", carouselService.getCarouselCounts());
		view.addObject("enquiryCounts", enquiryService.getEnquiryCounts());
		view.addObject("userCounts", userService.getUserCounts());
		// enquiries count total - new/incomplete/complete
		// users total count, enabled and Disabled
		return view;
	}

}
