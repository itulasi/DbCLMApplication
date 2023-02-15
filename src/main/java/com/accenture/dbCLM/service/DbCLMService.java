package com.accenture.dbCLM.service;

import com.accenture.dbCLM.model.Nace;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DbCLMService {

    public ResponseEntity<Nace> putNaceDetails(Nace nace, Long id);
    public ResponseEntity<Nace> getNaceDetails(Long id);

}
