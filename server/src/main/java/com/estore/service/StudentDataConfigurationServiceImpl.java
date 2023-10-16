package com.estore.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.domain.StudentDataConfiguration;
import com.estore.exception.StudentDataConfigurationException;
import com.estore.repository.StudentDataConfigurationRepository;

@Service
public class StudentDataConfigurationServiceImpl implements StudentDataConfigurationService{

	@Autowired
	StudentDataConfigurationRepository studentDataConfigurationRepository;
	
	@Override
	public StudentDataConfiguration getStudentDataConfiguration() {
		try {
			List<StudentDataConfiguration> studentDataConfigurations = studentDataConfigurationRepository.findAll();
			if(!studentDataConfigurations.isEmpty()) {
				StudentDataConfiguration studentDataConfiguration = studentDataConfigurations.get(0);
				if(Objects.nonNull(studentDataConfiguration)) {
					return studentDataConfiguration;
				}
			}
			else {
				throw new StudentDataConfigurationException("studentDataConfigurations can not be null");
			}
		}
		catch(Exception e) {
			throw new StudentDataConfigurationException(e.getMessage());
		}
		return null;
	}
}
