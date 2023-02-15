package com.accenture.dbCLM.service;

import com.accenture.dbCLM.DbClmApplication;
import com.accenture.dbCLM.exception.ResourceNotFoundException;
import com.accenture.dbCLM.model.Nace;
import com.accenture.dbCLM.repository.DbCLMRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DbCLMServiceImpl implements DbCLMService{

    private static final Logger logger = LoggerFactory.getLogger(DbClmApplication.class);

    @Autowired
    public DbCLMRepository dbCLMRepository;

    @Override
    public ResponseEntity<Nace> putNaceDetails(Nace nace, Long id) {
        logger.info("NACE id to update the details :: "+id);
        Nace naceDb = dbCLMRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("NACE details are not exist with order id:"+id));
        naceDb.setLevel(nace.getLevel());
        naceDb.setCode(nace.getCode());
        naceDb.setParent(nace.getParent());
        naceDb.setDescription(nace.getDescription());
        naceDb.setThisItemIncludes(nace.getThisItemIncludes());
        naceDb.setThisItemAlsoIncludes(nace.getThisItemAlsoIncludes());
        naceDb.setRulings(nace.getRulings());
        naceDb.setThisItemExcludes(nace.getThisItemExcludes());
        naceDb.setReferenceToISICRev(nace.getReferenceToISICRev());

        dbCLMRepository.save(naceDb);
        logger.info("Updated NACE details "+naceDb.toString());
        return ResponseEntity.ok(naceDb);
    }

    @Override
    public ResponseEntity<Nace> getNaceDetails(Long id) {
        logger.info("NACE id to find the NACE details :: "+id);
        Nace nace = dbCLMRepository.findById(id).get();
        logger.info("Nace details for id"+id+" are "+nace.toString());
        return  ResponseEntity.ok(nace);
    }
}
