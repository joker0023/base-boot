package com.jokerstation.boot.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.jokerstation.boot.response.ItemExcelResp;

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
	
	@GetMapping("/download")
	public void download(HttpServletResponse response) throws Exception {
		List<ItemExcelResp> list = new ArrayList<>();
		ItemExcelResp item = new ItemExcelResp();
		list.add(item);
		
		String fileName = URLEncoder.encode("test", "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
		ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), ItemExcelResp.class).build();
		// 同一个sheet，只需要创建1次
		WriteSheet writerSheet = EasyExcel.writerSheet("奖励发放").build();
		excelWriter.write(list, writerSheet);
		excelWriter.finish();
	}
}
