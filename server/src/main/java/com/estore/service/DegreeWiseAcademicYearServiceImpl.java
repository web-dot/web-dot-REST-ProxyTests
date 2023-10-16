package com.estore.service;

import java.util.Comparator;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.domain.AdmissionAcademicYear;
import com.estore.domain.DegreeWiseAcademicYear;
import com.estore.exception.DegreeWiseAcademicYearException;
import com.estore.repository.DegreeWiseAcademicYearRepository;

@Service
public class DegreeWiseAcademicYearServiceImpl implements DegreeWiseAcademicYearService {
	
	@Autowired
	DegreeWiseAcademicYearRepository degreeWiseAcademicYearRepository;
	
	
	@Override
	public DegreeWiseAcademicYear findDegreeWiseAcademicYear(String degreeId) {
		Objects.requireNonNull(degreeId, "DEGREE ID CANNOT BE NULL");
		DegreeWiseAcademicYear degreeWiseAcademicYear = new DegreeWiseAcademicYear();
		degreeWiseAcademicYear =  degreeWiseAcademicYearRepository.findByDegreeId(degreeId);
		if(Objects.nonNull(degreeWiseAcademicYear) 
				&& Objects.nonNull(degreeWiseAcademicYear.getAdmissionAcademicYear())
						&& !degreeWiseAcademicYear.getAdmissionAcademicYear().isEmpty()) {
			degreeWiseAcademicYear.getAdmissionAcademicYear().sort(Comparator.comparing(
					AdmissionAcademicYear::getAcademicYear, Comparator.nullsLast(Comparator.reverseOrder())));
			return degreeWiseAcademicYear;
		}
		else {
			throw new DegreeWiseAcademicYearException("DEGREE WISE ACADEMIC YEAR NOT FOUND");
		}
	}
	
	
}
