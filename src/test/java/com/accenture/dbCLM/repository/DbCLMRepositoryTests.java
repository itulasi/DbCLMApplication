package com.accenture.dbCLM.repository;

import com.accenture.dbCLM.model.Nace;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DbCLMRepositoryTests {

    @Autowired
    DbCLMRepository dbCLMRepository;

    @Test
    public void testgetDetails(){

        Assertions.assertThat(dbCLMRepository.findById(1L)).isEmpty();
        Nace nace = new Nace(1L,2,"1","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","1");
        dbCLMRepository.save(nace);

        Optional<Nace> naceDb = dbCLMRepository.findById(1L);
        Assertions.assertThat(dbCLMRepository.findById(1L)).isNotEmpty();
    }
}
