package com.estore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estore.domain.MasterTemplate;

@Repository
public interface MasterTemplateRepository extends MongoRepository<MasterTemplate, String> {
	List<MasterTemplate> findByIdIn(List<String> masterTemplateId);
}
