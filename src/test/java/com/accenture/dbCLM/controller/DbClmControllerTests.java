package com.accenture.dbCLM.controller;

import com.accenture.dbCLM.model.Nace;
import com.accenture.dbCLM.service.DbCLMService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DbCLMController.class)
public class DbClmControllerTests {

    @MockBean
    DbCLMService dbCLMService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testputNaceDetails() throws  Exception{
        Nace nace = new Nace(1L,2,"1","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","1");
        Nace nace1 = new Nace(2L,3,"11","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","A");

        Mockito.when(dbCLMService.putNaceDetails(nace1,1L)).thenReturn(ResponseEntity.ok(nace1));
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/dbclm/v1/updatenacedetails/1")
                        .content(asJsonString(new Nace(2L,3,"11","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","A")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testgetNaceDetails() throws  Exception{
        Nace nace = new Nace(1L,2,"1","A","Crop and animal production, hunting and related service activities","This division includes two basic activities, namely the production of crop products and production of animal products, covering also the forms of organic agriculture","This division also includes service activities incidental to agriculture, as well as hunting, trapping and related activities."," ","Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products))","1");
        Mockito.when(dbCLMService.getNaceDetails(1L)).thenReturn(ResponseEntity.ok(nace));
        mockMvc.perform(get("/dbclm/v1/findnacedetails/1"))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
