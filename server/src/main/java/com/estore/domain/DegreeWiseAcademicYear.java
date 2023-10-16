package com.estore.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "degreewiseacademicyear", parent = Object.class)
@Document(collection = "pms_degreewise_academic_year")
public class DegreeWiseAcademicYear {
	
	private String id;
	private String degreeId;
	private List<AdmissionAcademicYear> admissionAcademicYear;
	public DegreeWiseAcademicYear() {
		super();
	}
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
	public List<AdmissionAcademicYear> getAdmissionAcademicYear() {
		return admissionAcademicYear;
	}
	public void setAdmissionAcademicYear(List<AdmissionAcademicYear> admissionAcademicYear) {
		this.admissionAcademicYear = admissionAcademicYear;
	}
	
}
