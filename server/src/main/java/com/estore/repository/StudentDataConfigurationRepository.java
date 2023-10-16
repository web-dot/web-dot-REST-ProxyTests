package com.estore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estore.domain.StudentDataConfiguration;

@Repository
public interface StudentDataConfigurationRepository extends MongoRepository<StudentDataConfiguration, String> {

}
