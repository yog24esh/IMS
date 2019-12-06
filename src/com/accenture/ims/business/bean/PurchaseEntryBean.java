package com.accenture.ims.business.bean;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseEntryBean {


	private Integer purchaseId;
	private String transactionId;
	
	@NotEmpty(message=" Please select the vendor ")
	private String vendorName;
	
	@NotEmpty(message=" Please select the MaterialCategory ")
	private String materialCategoryId;	
	
	@NotEmpty(message=" Please select the MaterialType ")
	private String materialTypeId;
	
	@NotEmpty(message="Please Enter the Brand Name")
	private String brandName;
	
	@NotEmpty(message=" Please select the Unit")
	private String unitId;
	
	
	@Range(min = 0l, message = "Please Enter only positive numbers  for Quantity")
	private Integer quantity;
	
	
	@Digits(integer = 20,fraction=2,message=" Please enter only numbers with two decimal places for purchase Amount" )
	private Double purchaseAmount;
	
	@NotNull(message="please Select the Purchase date")
	@NotEmpty(message="please Select the Purchase date")
	private Date purchaseDate;
	private String status;
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getMaterialCategoryId() {
		return materialCategoryId;
	}
	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}
	public String getMaterialTypeId() {
		return materialTypeId;
	}
	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PurchaseEntryBean [purchaseId=" + purchaseId + ", transactionId=" + transactionId + ", vendorName="
				+ vendorName + ", materialCategoryId=" + materialCategoryId + ", materialTypeId=" + materialTypeId
				+ ", brandName=" + brandName + ", unitId=" + unitId + ", quantity=" + quantity + ", purchaseAmount="
				+ purchaseAmount + ", purchaseDate=" + purchaseDate + ", status=" + status + "]";
	}
	
	
}
