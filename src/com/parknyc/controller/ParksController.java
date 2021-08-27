package com.parknyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userLogin")
@RequestMapping("/ParkNYC/")
public class ParksController {
	
	@RequestMapping("/login")
	public String loginHandler() {
		return "login";
	}

}
