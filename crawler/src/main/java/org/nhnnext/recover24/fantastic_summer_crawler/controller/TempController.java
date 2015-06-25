package org.nhnnext.recover24.fantastic_summer_crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TempController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String hello() {
		System.out.println("hello crawler");
		return "index";
	}
}
