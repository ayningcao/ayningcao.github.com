package com.timebank.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {

	@RequestMapping(value = "/index.action", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String userAgent = request.getHeader("User-Agent");
		mav.addObject("userAgent", userAgent);
		mav.setViewName("index");

		return mav;
	}
}
