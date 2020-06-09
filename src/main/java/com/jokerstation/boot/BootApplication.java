package com.jokerstation.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

//import tk.mybatis.spring.annotation.MapperScan;

@EnableAsync
//@EnableTransactionManagement
//@EnableEurekaClient
@SpringBootApplication
//@MapperScan("com.jokerstation.common.mapper")
@ComponentScan("com.jokerstation")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
