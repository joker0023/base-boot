package com.jokerstation.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jokerstation.common.mapper.ItemMapper;
import com.jokerstation.common.pojo.Item;
import com.jokerstation.common.util.JsonUtils;

@RestController
public class CommonCtrl {
	
	private static Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	
//	@Autowired
//	private ItemMapper itemMapper;
//
	@RequestMapping("/test")
	public String test() {
//		logger.debug("debug log test");
//		logger.info("info log test");
//		logger.warn("warn log test");
//		logger.error("error log test");
		return "success";
	}
}
