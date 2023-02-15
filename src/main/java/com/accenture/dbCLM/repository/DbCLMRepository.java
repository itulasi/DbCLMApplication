package com.accenture.dbCLM.repository;

import com.accenture.dbCLM.model.Nace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbCLMRepository extends CrudRepository<Nace, Long> {
}
