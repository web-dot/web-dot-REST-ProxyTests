package com.estore.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dhi_student_data_configuration")
public class StudentDataConfiguration {
	
	private String id;
	private String degreeId;
	private List<String> verificationBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public List<String> getVerificationBy() {
		return verificationBy;
	}
	public void setVerificationBy(List<String> verificationBy) {
		this.verificationBy = verificationBy;
	}
}
