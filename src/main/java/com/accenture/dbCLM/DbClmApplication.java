package com.accenture.dbCLM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DbClmApplication {

	private static final Logger logger = LoggerFactory.getLogger(DbClmApplication.class);
	public static void main(String[] args) {
		logger.info("Application starting");
		SpringApplication.run(DbClmApplication.class, args);
	}

}
