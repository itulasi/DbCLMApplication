package com.accenture.dbCLM.service;

import com.accenture.dbCLM.model.Nace;
import com.accenture.dbCLM.repository.DbCLMRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbClmServiceTests {

    @InjectMocks
    DbCLMServiceImpl dbCLMService;

    @Mock
    DbCLMRepository dbCLMRepository;

    @Test
    public void testputNaceDetails(){
        Nace nace = new Nace(1L,2,"1","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","1");
        Nace nace1 = new Nace(2L,3,"11","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","A");
        when(dbCLMRepository.findById(1L)).thenReturn(Optional.of(nace1));

        ResponseEntity<Nace> naceDb = dbCLMService.putNaceDetails(nace1,1L);
        assertEquals(nace1.getLevel(),naceDb.getBody().getLevel());
        assertEquals(nace1.getCode(),naceDb.getBody().getCode());
        verify(dbCLMRepository,times(1)).findById(1L);
    }

    @Test
    public void testgetNaceDetails(){
        Nace nace = new Nace(1L,2,"1","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","1");
        when(dbCLMRepository.findById(1L)).thenReturn(Optional.of(nace));

        ResponseEntity<Nace> naceDb = dbCLMService.getNaceDetails(1L);

    }

}
