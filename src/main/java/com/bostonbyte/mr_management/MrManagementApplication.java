package com.bostonbyte.mr_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MrManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrManagementApplication.class, args);
	}




}
