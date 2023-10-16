package com.estore.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.estore.domain.MasterTemplate;
import com.estore.dto.MasterTemplateDto;
import com.estore.repository.MasterTemplateRepository;

@Service
public class MasterTemplateServiceImpl implements MasterTemplateService {

	public static final Logger LOG = LoggerFactory.getLogger(MasterTemplateServiceImpl.class);
	
	@Autowired
	MasterTemplateRepository masterTemplateRepository;
	
	
	@Override
	public List<MasterTemplateDto> findAllMasterTemplates() {
		LOG.info("Enter: findAll() in MasterTemplate service implementation");
		List<MasterTemplate> masterTemplateList = masterTemplateRepository.findAll();
		List<MasterTemplateDto> masterTemplateDtoList = new ArrayList<>();
		if(Objects.nonNull(masterTemplateDtoList) && !masterTemplateList.isEmpty()) {
			try {
				masterTemplateList.stream()
				.filter(Objects::nonNull).forEachOrdered(action -> {
					MasterTemplateDto masterTempDto = new MasterTemplateDto();
					BeanUtils.copyProperties(action, masterTempDto);
					masterTemplateDtoList.add(masterTempDto);
				});
				
				if(Objects.nonNull(masterTemplateDtoList) && !masterTemplateDtoList.isEmpty()) {
					return masterTemplateDtoList;
				}
			}
			catch(Exception e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}
		return null;
	}
	
	
	@Override
	public MasterTemplate findById(String masterTemplateId) {
		if(Objects.nonNull(masterTemplateId)) {
			
			Optional<MasterTemplate> id = masterTemplateRepository.findById(masterTemplateId);
			if(Objects.nonNull(id.get())) {
				Optional<MasterTemplate> master = masterTemplateRepository.findById(masterTemplateId);
				return master.isPresent() ? master.get() : null;
			}
		}
		else {
			throw new IllegalArgumentException();
		}
		return null;
	}
	
	@Override
	public String deleteComponentById(String feeTemplateId, String feeComponent) {
		try {
			Assert.hasText(feeTemplateId, "Fee template Id is required");
			Assert.hasText(feeComponent, "Fee compoenent name is required");
			List<MasterTemplate> templates = masterTemplateRepository.findByIdIn(Arrays.asList(feeTemplateId));
			
			templates.stream();
			return "SUCCESS";
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
