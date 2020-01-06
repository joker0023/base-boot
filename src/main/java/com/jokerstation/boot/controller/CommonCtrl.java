package com.jokerstation.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jokerstation.common.mapper.ItemMapper;
import com.jokerstation.common.pojo.Item;
import com.jokerstation.common.util.JsonUtils;

@RestController
public class CommonCtrl {
	
	@Autowired
	private ItemMapper itemMapper;

	@RequestMapping("/test")
	public String test() {
		
		return "success";
	}
}
