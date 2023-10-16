package com.estore.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.estore.domain.FeeComponent;

public class MasterTemplateDto {
	@Id
	private String id;
	private String name;
	private String degreeId;
	private double totalAmount;
	private List<FeeComponent> feeComponents;
	private LocalDateTime modifiedAt;
	private String modifiedBy;
	private boolean deleteDisable;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public boolean isDeleteDisable() {
		return deleteDisable;
	}
	public void setDeleteDisable(boolean deleteDisable) {
		this.deleteDisable = deleteDisable;
	}
	public List<FeeComponent> getFeeComponents() {
		return feeComponents;
	}
	public void setFeeComponents(List<FeeComponent> feeComponents) {
		this.feeComponents = feeComponents;
	}
}
