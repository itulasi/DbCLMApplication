package com.accenture.dbCLM;

import com.accenture.dbCLM.controller.DbCLMController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DbClmApplicationTests {

	@Autowired
	DbCLMController dbCLMController;

	@Test
	void contextLoads() {
		Assertions.assertThat(dbCLMController).isNot(null);
	}

}
