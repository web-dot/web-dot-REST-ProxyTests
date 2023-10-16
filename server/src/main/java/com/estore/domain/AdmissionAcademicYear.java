package com.estore.domain;

import org.bson.types.ObjectId;

public class AdmissionAcademicYear {

	private String id;
	private String academicYear;
	private boolean currentAcademicYear;
	
	public AdmissionAcademicYear() {
		super();
		this.id=ObjectId.get().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public boolean isCurrentAcademicYear() {
		return currentAcademicYear;
	}

	public void setCurrentAcademicYear(boolean currentAcademicYear) {
		this.currentAcademicYear = currentAcademicYear;
	}
	
}
