package com.accenture.dbCLM.integration;

import com.accenture.dbCLM.DbClmApplication;
import com.accenture.dbCLM.model.Nace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.ws.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DbClmApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DbCLMIntegrationTests {

    @LocalServerPort
    private  int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public  void testGetNaceDetails(){

        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> naceResponse = restTemplate.exchange(createURLWithPort("/dbclm/v1/updatenacedetails/1"), HttpMethod.GET, entity,String.class);

    }

    private String createURLWithPort(String uri){
        return "http://localhost:"+port+uri;
    }
}
