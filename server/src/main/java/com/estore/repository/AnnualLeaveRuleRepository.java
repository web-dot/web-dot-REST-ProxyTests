package com.estore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estore.domain.AnnualLeaveRule;

@Repository
public interface AnnualLeaveRuleRepository extends MongoRepository<AnnualLeaveRule, String> {

}
