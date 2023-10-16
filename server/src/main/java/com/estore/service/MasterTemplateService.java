package com.estore.service;

import java.util.List;

import com.estore.domain.MasterTemplate;
import com.estore.dto.MasterTemplateDto;

public interface MasterTemplateService {
	List<MasterTemplateDto> findAllMasterTemplates();
	MasterTemplate findById(String masterTemplateId);
	String deleteComponentById(String feeTemplateId, String feeComponent);
}
