package com.jokerstation.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageCtrl {

	@RequestMapping("/page")
	public String page(String name) {
		System.out.println("page in, name: " + name);
		return "page.html";
	}
}