package com.estore.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.consts.LOGConsts.AnnualLeaveRuleServiceLogConstant;
import com.estore.domain.AnnualLeaveDetail;
import com.estore.domain.AnnualLeaveRule;
import com.estore.domain.LeaveApprover;
import com.estore.domain.LeaveCategoryDetail;
import com.estore.exception.AnnualLeaveRuleException;
import com.estore.repository.AnnualLeaveRuleRepository;

@Service
public class AnnualLeaveRuleServiceImpl implements AnnualLeaveRuleService {
	
	@Autowired
	AnnualLeaveRuleRepository annualLeaveRuleRepository;
	
	public static final Logger LOG = LoggerFactory.getLogger(AnnualLeaveRuleServiceImpl.class);
	
	private static final String USER_TYPE_MUST_NOT_BE_NULL = "User type must not be null";
	private static final String EMPLOYMENT_TYPE_MUST_NOT_BE_NULL = "Employment type must not be null";
	private static final String LEAVE_CATEGORIES_NOT_FOUND_WITH_GIVEN_PARAMETERS = "LEAVE_CATEGORIES_NOT_FOUND_WITH_GIVEN_PARAMETER";
	private static final String LEAVE_RULES_NOT_DEFINED = "LEAVE_RULES_NOT_DEFINED"; 
	private static final String LEAVE_APPROVERS_MUST_NOT_BE_NULL = "LEAVE_APPROVERS_MUST_NOT_BE_NULL";

	
	
	@Override
	public List<LeaveCategoryDetail> fetchAllLeaveCategoryDetails(String userType, String employmentType) {
		LOG.info(AnnualLeaveRuleServiceLogConstant.ENTRY, "fetchAllLeaveCategoryDetails");
		AnnualLeaveRule annualLeaveRule = null;
		try {
			if(userType == null) {
				throw new AnnualLeaveRuleException(USER_TYPE_MUST_NOT_BE_NULL);
			}
			if(employmentType == null) {
				throw new AnnualLeaveRuleException(EMPLOYMENT_TYPE_MUST_NOT_BE_NULL);
			}
			LOG.info(AnnualLeaveRuleServiceLogConstant.PARAMETERS_ARE_VALID);
			List<AnnualLeaveRule> rules = annualLeaveRuleRepository.findAll();
			if(!rules.isEmpty()) {
				annualLeaveRule = rules.get(0);
			}
			
			if(Objects.nonNull(annualLeaveRule)) {
				LOG.info(AnnualLeaveRuleServiceLogConstant.ANNUAL_LEAVE_RULE_IS_FOUND);
				AnnualLeaveDetail matchedAnnualLeaveDetails =  annualLeaveRule.getAnnualLeaveDetails().stream()
				.filter(annualLeaveDetail -> annualLeaveDetail.getUserType().equals(userType)
						&& annualLeaveDetail.getEmploymentType().name().equals(employmentType))
				.findAny().orElse(null);
				
				if(Objects.nonNull(matchedAnnualLeaveDetails)) {
					LOG.info(AnnualLeaveRuleServiceLogConstant.ANNUAL_LEAVE_DETAIL_IS_FOUND, userType, employmentType);
					LOG.info(AnnualLeaveRuleServiceLogConstant.LEAVE_CATEGORIES_FETCHED);
					return matchedAnnualLeaveDetails.getLeaveCategoryDetails();
				}
				else {
					LOG.error(AnnualLeaveRuleServiceLogConstant.ANNUAL_LEAVE_DETAIL_IS_NOT_FOUND, userType, employmentType);
					throw new AnnualLeaveRuleException(LEAVE_CATEGORIES_NOT_FOUND_WITH_GIVEN_PARAMETERS);
				}
			}
			else {
				LOG.info(AnnualLeaveRuleServiceLogConstant.ANNUAL_LEAVE_RULE_IS_NOT_FOUND);
				throw new AnnualLeaveRuleException(LEAVE_RULES_NOT_DEFINED);
			}
		}
		catch(Exception e) {
			LOG.error(AnnualLeaveRuleServiceLogConstant.EXCEPTION_OCCURED);
			throw new AnnualLeaveRuleException(e.getMessage());
		}
	}
	
	
	@Override
	public List<LeaveApprover> saveLeaveApprovers(String userType, String employmentType,
			List<LeaveApprover> leaveApprovers) {
		LOG.info(AnnualLeaveRuleServiceLogConstant.ENTRY, "saveLeaveApprovers");
		AnnualLeaveRule annualLeaveRule = null;
		try {
			if(Objects.isNull(leaveApprovers)) {
				throw new AnnualLeaveRuleException(LEAVE_APPROVERS_MUST_NOT_BE_NULL);
			}
			if(Objects.isNull(userType)) {
				throw new AnnualLeaveRuleException(USER_TYPE_MUST_NOT_BE_NULL);
			}
			if(Objects.isNull(employmentType)) {
				throw new AnnualLeaveRuleException(EMPLOYMENT_TYPE_MUST_NOT_BE_NULL);
			}
			List<AnnualLeaveRule> tempRule = annualLeaveRuleRepository.findAll();
			if(!tempRule.isEmpty()) {
				annualLeaveRule = tempRule.get(0);
			}
			if(Objects.nonNull(annualLeaveRule)) {
				AnnualLeaveDetail matchedAnnualDetail = annualLeaveRule.getAnnualLeaveDetails().stream()
				.filter(annualLeaveDetail -> {
					if(annualLeaveDetail.getUserType().equals(userType) && annualLeaveDetail.getEmploymentType().equals(employmentType)) {
						annualLeaveDetail.setLeaveApprovers(leaveApprovers);
						return true;
					}
					return false;
				}).findAny().orElse(null);
				
				if(Objects.nonNull(matchedAnnualDetail)) {
					annualLeaveRule.getAnnualLeaveDetails()
					.removeIf(eachAnnualLeaveDetail -> eachAnnualLeaveDetail.equals(matchedAnnualDetail));
					
				}
				
			}
		}
		catch(Exception e) {
			
		}
		return null;
	}
}















