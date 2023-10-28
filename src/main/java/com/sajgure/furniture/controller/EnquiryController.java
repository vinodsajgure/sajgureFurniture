package com.sajgure.furniture.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sajgure.furniture.constant.EnquiryStatus;
import com.sajgure.furniture.entity.Enquiry;
import com.sajgure.furniture.service.EnquiryService;

@Controller
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("admin-pages/enquiry");
		view.addObject("enquiries", enquiryService.getAllEnquiries());
		return view;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Enquiry> getEnquiries() {
		return enquiryService.getAllEnquiries();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addEnquiry(@Valid @RequestBody Enquiry enquiry, BindingResult result) {
		enquiryService.saveEnquiry(enquiry);

	}

	@RequestMapping(value = "{enquiryId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateEnquiryStatus(@Valid @RequestParam("status") EnquiryStatus enquiryStatus,
			@PathVariable("enquiryId") int enquiryId) {
		enquiryService.updateEnquiryStatus(enquiryId, enquiryStatus);
	}

}
