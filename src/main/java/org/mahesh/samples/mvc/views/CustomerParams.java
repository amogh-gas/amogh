package org.mahesh.samples.mvc.views;

import java.io.Serializable;

public class CustomerParams implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String customerName;
	private String customerAddress;
	private String customerArea;
	private String customerState;
	private String customerEmail;
	private String customerPhone;
	private String customerMobile;
	private String customerContactPerson;
	private String customerTinNo;
	private String customerCstNo;
	private String customerPanNo;
	private String customerECCNo;
	private String customerHoldingAdvice;
	private int customerCreditDays;
	private int customerMaxCylinder;
	private int customerMinCylinder;
	private String customerSecond;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerArea() {
		return customerArea;
	}
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerContactPerson() {
		return customerContactPerson;
	}
	public void setCustomerContactPerson(String customerContactPerson) {
		this.customerContactPerson = customerContactPerson;
	}
	public String getCustomerTinNo() {
		return customerTinNo;
	}
	public void setCustomerTinNo(String customerTinNo) {
		this.customerTinNo = customerTinNo;
	}
	public String getCustomerCstNo() {
		return customerCstNo;
	}
	public void setCustomerCstNo(String customerCstNo) {
		this.customerCstNo = customerCstNo;
	}
	public String getCustomerPanNo() {
		return customerPanNo;
	}
	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}
	public String getCustomerECCNo() {
		return customerECCNo;
	}
	public void setCustomerECCNo(String customerECCNo) {
		this.customerECCNo = customerECCNo;
	}
	public String getCustomerHoldingAdvice() {
		return customerHoldingAdvice;
	}
	public void setCustomerHoldingAdvice(String customerHoldingAdvice) {
		this.customerHoldingAdvice = customerHoldingAdvice;
	}
	public int getCustomerCreditDays() {
		return customerCreditDays;
	}
	public void setCustomerCreditDays(int customerCreditDays) {
		this.customerCreditDays = customerCreditDays;
	}
	public int getCustomerMaxCylinder() {
		return customerMaxCylinder;
	}
	public void setCustomerMaxCylinder(int customerMaxCylinder) {
		this.customerMaxCylinder = customerMaxCylinder;
	}
	public int getCustomerMinCylinder() {
		return customerMinCylinder;
	}
	public void setCustomerMinCylinder(int customerMinCylinder) {
		this.customerMinCylinder = customerMinCylinder;
	}
	public String getCustomerSecond() {
		return customerSecond;
	}
	public void setCustomerSecond(String customerSecond) {
		this.customerSecond = customerSecond;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result
				+ ((customerArea == null) ? 0 : customerArea.hashCode());
		result = prime
				* result
				+ ((customerContactPerson == null) ? 0 : customerContactPerson
						.hashCode());
		result = prime * result + customerCreditDays;
		result = prime * result
				+ ((customerCstNo == null) ? 0 : customerCstNo.hashCode());
		result = prime * result
				+ ((customerECCNo == null) ? 0 : customerECCNo.hashCode());
		result = prime * result
				+ ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime
				* result
				+ ((customerHoldingAdvice == null) ? 0 : customerHoldingAdvice
						.hashCode());
		result = prime * result + customerMaxCylinder;
		result = prime * result + customerMinCylinder;
		result = prime * result
				+ ((customerMobile == null) ? 0 : customerMobile.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((customerPanNo == null) ? 0 : customerPanNo.hashCode());
		result = prime * result
				+ ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result
				+ ((customerSecond == null) ? 0 : customerSecond.hashCode());
		result = prime * result
				+ ((customerState == null) ? 0 : customerState.hashCode());
		result = prime * result
				+ ((customerTinNo == null) ? 0 : customerTinNo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CustomerParams))
			return false;
		CustomerParams other = (CustomerParams) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerArea == null) {
			if (other.customerArea != null)
				return false;
		} else if (!customerArea.equals(other.customerArea))
			return false;
		if (customerContactPerson == null) {
			if (other.customerContactPerson != null)
				return false;
		} else if (!customerContactPerson.equals(other.customerContactPerson))
			return false;
		if (customerCreditDays != other.customerCreditDays)
			return false;
		if (customerCstNo == null) {
			if (other.customerCstNo != null)
				return false;
		} else if (!customerCstNo.equals(other.customerCstNo))
			return false;
		if (customerECCNo == null) {
			if (other.customerECCNo != null)
				return false;
		} else if (!customerECCNo.equals(other.customerECCNo))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerHoldingAdvice == null) {
			if (other.customerHoldingAdvice != null)
				return false;
		} else if (!customerHoldingAdvice.equals(other.customerHoldingAdvice))
			return false;
		if (customerMaxCylinder != other.customerMaxCylinder)
			return false;
		if (customerMinCylinder != other.customerMinCylinder)
			return false;
		if (customerMobile == null) {
			if (other.customerMobile != null)
				return false;
		} else if (!customerMobile.equals(other.customerMobile))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPanNo == null) {
			if (other.customerPanNo != null)
				return false;
		} else if (!customerPanNo.equals(other.customerPanNo))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (customerSecond == null) {
			if (other.customerSecond != null)
				return false;
		} else if (!customerSecond.equals(other.customerSecond))
			return false;
		if (customerState == null) {
			if (other.customerState != null)
				return false;
		} else if (!customerState.equals(other.customerState))
			return false;
		if (customerTinNo == null) {
			if (other.customerTinNo != null)
				return false;
		} else if (!customerTinNo.equals(other.customerTinNo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerParams [id=" + id + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", customerArea="
				+ customerArea + ", customerState=" + customerState
				+ ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", customerMobile=" + customerMobile
				+ ", customerContactPerson=" + customerContactPerson
				+ ", customerTinNo=" + customerTinNo + ", customerCstNo="
				+ customerCstNo + ", customerPanNo=" + customerPanNo
				+ ", customerECCNo=" + customerECCNo
				+ ", customerHoldingAdvice=" + customerHoldingAdvice
				+ ", customerCreditDays=" + customerCreditDays
				+ ", customerMaxCylinder=" + customerMaxCylinder
				+ ", customerMinCylinder=" + customerMinCylinder
				+ ", customerSecond=" + customerSecond + "]";
	}
		
}
