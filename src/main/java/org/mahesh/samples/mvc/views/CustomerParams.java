package org.mahesh.samples.mvc.views;

import java.io.Serializable;

public class CustomerParams extends PaginationParams implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String address;
	private String area;
	private String state;
	private String email;
	private String phone;
	private String primobile;
	private String secmobile;
	private String contactPerson1;
	private String contactPerson2;
	private String tinNum;
	private String cstNum;
	private String panNum;
	private String eCCNum;
	private String holdingAdvice;
	private int creditDays;
	private int maxCylinder;
	private int minCylinder;
	private String second;
	private String saveType;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrimobile() {
		return primobile;
	}
	public void setPrimobile(String primobile) {
		this.primobile = primobile;
	}
	public String getSecmobile() {
		return secmobile;
	}
	public void setSecmobile(String secmobile) {
		this.secmobile = secmobile;
	}
	public String getContactPerson1() {
		return contactPerson1;
	}
	public void setContactPerson1(String contactPerson1) {
		this.contactPerson1 = contactPerson1;
	}
	public String getContactPerson2() {
		return contactPerson2;
	}
	public void setContactPerson2(String contactPerson2) {
		this.contactPerson2 = contactPerson2;
	}
	public String getTinNum() {
		return tinNum;
	}
	public void setTinNum(String tinNum) {
		this.tinNum = tinNum;
	}
	public String getCstNum() {
		return cstNum;
	}
	public void setCstNum(String cstNum) {
		this.cstNum = cstNum;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String geteCCNum() {
		return eCCNum;
	}
	public void seteCCNum(String eCCNum) {
		this.eCCNum = eCCNum;
	}
	public String getHoldingAdvice() {
		return holdingAdvice;
	}
	public void setHoldingAdvice(String holdingAdvice) {
		this.holdingAdvice = holdingAdvice;
	}
	public int getCreditDays() {
		return creditDays;
	}
	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}
	public int getMaxCylinder() {
		return maxCylinder;
	}
	public void setMaxCylinder(int maxCylinder) {
		this.maxCylinder = maxCylinder;
	}
	public int getMinCylinder() {
		return minCylinder;
	}
	public void setMinCylinder(int minCylinder) {
		this.minCylinder = minCylinder;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	@Override
	public String toString() {
		return "CustomerParams [id=" + id + ", name=" + name + ", address="
				+ address + ", area=" + area + ", state=" + state + ", email="
				+ email + ", phone=" + phone + ", primobile=" + primobile
				+ ", secmobile=" + secmobile + ", contactPerson1="
				+ contactPerson1 + ", contactPerson2=" + contactPerson2
				+ ", tinNum=" + tinNum + ", cstNum=" + cstNum + ", panNum="
				+ panNum + ", eCCNum=" + eCCNum + ", holdingAdvice="
				+ holdingAdvice + ", creditDays=" + creditDays
				+ ", maxCylinder=" + maxCylinder + ", minCylinder="
				+ minCylinder + ", second=" + second + "]";
	}
	
}
