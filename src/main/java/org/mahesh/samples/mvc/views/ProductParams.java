package org.mahesh.samples.mvc.views;

import java.io.Serializable;

import org.mahesh.samples.mvc.domain.security.LovNode;

public class ProductParams extends PaginationParams implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private long typeId;
	private String desc;
	private String shortDesc;
	private String unit;
	private String under;
	private String tariffCode;
	private String saveType;
	private LovNode productType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnder() {
		return under;
	}
	public void setUnder(String under) {
		this.under = under;
	}
	public String getTariffCode() {
		return tariffCode;
	}
	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}
	@Override
	public String toString() {
		return "ProductParams [id=" + id + ", name=" + name + ", typeId=" + typeId
				+ ", desc=" + desc + ", shortDesc=" + shortDesc + ", unit="
				+ unit + ", under=" + under + ", tariffCode=" + tariffCode
				+ "]";
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public LovNode getProductType() {
		return productType;
	}
	public void setProductType(LovNode productType) {
		this.productType = productType;
	}
	
	
}
