package com.accenture.dbCLM.controller;

import com.accenture.dbCLM.DbClmApplication;
import com.accenture.dbCLM.model.Nace;
import com.accenture.dbCLM.service.DbCLMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dbclm/v1")
public class DbCLMController {

    private static final Logger logger = LoggerFactory.getLogger(DbClmApplication.class);

    @Autowired
    public DbCLMService dbCLMService;
    @PutMapping(value = "/updatenacedetails/{id}")
    public ResponseEntity<Nace> putNaceDetails(@RequestBody Nace nace, @PathVariable("id") Long id){
       return dbCLMService.putNaceDetails(nace,id);
    }

    @GetMapping(value = "/findnacedetails/{id}")
    public ResponseEntity<Nace> getNaceDetails(@PathVariable("id") Long id){
       return dbCLMService.getNaceDetails(id);

    }
}
