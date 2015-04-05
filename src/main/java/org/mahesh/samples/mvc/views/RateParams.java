package org.mahesh.samples.mvc.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class RateParams extends PaginationParams implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private long custId;
	private long prodId;
	private BigDecimal ratePerNo;
	private BigDecimal ratePerLtr;
	private BigDecimal ratePerCubMtr;
	private BigDecimal ratePerKg;
	private BigDecimal exciseRate;
	private BigDecimal cessExcise;
	private BigDecimal eduCess;
	private BigDecimal frieght;
	private BigDecimal loading_chrgs;
	private BigDecimal unloadingChrgs;
	private String withoutExcise;
	private String srvcTaxFlag;
	private BigDecimal srvcTax;
	private String supplementryInvoic;
	private BigDecimal vat;
	private BigDecimal cstWithCForm;
	private BigDecimal cstWithoutCForm;
	private String saveType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public BigDecimal getRatePerNo() {
		return ratePerNo;
	}
	public void setRatePerNo(BigDecimal ratePerNo) {
		this.ratePerNo = ratePerNo;
	}
	public BigDecimal getRatePerLtr() {
		return ratePerLtr;
	}
	public void setRatePerLtr(BigDecimal ratePerLtr) {
		this.ratePerLtr = ratePerLtr;
	}
	public BigDecimal getRatePerCubMtr() {
		return ratePerCubMtr;
	}
	public void setRatePerCubMtr(BigDecimal ratePerCubMtr) {
		this.ratePerCubMtr = ratePerCubMtr;
	}
	public BigDecimal getRatePerKg() {
		return ratePerKg;
	}
	public void setRatePerKg(BigDecimal ratePerKg) {
		this.ratePerKg = ratePerKg;
	}
	public BigDecimal getExciseRate() {
		return exciseRate;
	}
	public void setExciseRate(BigDecimal exciseRate) {
		this.exciseRate = exciseRate;
	}
	public BigDecimal getCessExcise() {
		return cessExcise;
	}
	public void setCessExcise(BigDecimal cessExcise) {
		this.cessExcise = cessExcise;
	}
	public BigDecimal getEduCess() {
		return eduCess;
	}
	public void setEduCess(BigDecimal eduCess) {
		this.eduCess = eduCess;
	}
	public BigDecimal getFrieght() {
		return frieght;
	}
	public void setFrieght(BigDecimal frieght) {
		this.frieght = frieght;
	}
	public BigDecimal getLoading_chrgs() {
		return loading_chrgs;
	}
	public void setLoading_chrgs(BigDecimal loading_chrgs) {
		this.loading_chrgs = loading_chrgs;
	}
	public BigDecimal getUnloadingChrgs() {
		return unloadingChrgs;
	}
	public void setUnloadingChrgs(BigDecimal unloadingChrgs) {
		this.unloadingChrgs = unloadingChrgs;
	}
	public String getWithoutExcise() {
		return withoutExcise;
	}
	public void setWithoutExcise(String withoutExcise) {
		this.withoutExcise = withoutExcise;
	}
	public String getSrvcTaxFlag() {
		return srvcTaxFlag;
	}
	public void setSrvcTaxFlag(String srvcTaxFlag) {
		this.srvcTaxFlag = srvcTaxFlag;
	}
	public BigDecimal getSrvcTax() {
		return srvcTax;
	}
	public void setSrvcTax(BigDecimal srvcTax) {
		this.srvcTax = srvcTax;
	}
	public String getSupplementryInvoic() {
		return supplementryInvoic;
	}
	public void setSupplementryInvoic(String supplementryInvoic) {
		this.supplementryInvoic = supplementryInvoic;
	}
	public BigDecimal getVat() {
		return vat;
	}
	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}
	public BigDecimal getCstWithCForm() {
		return cstWithCForm;
	}
	public void setCstWithCForm(BigDecimal cstWithCForm) {
		this.cstWithCForm = cstWithCForm;
	}
	public BigDecimal getCstWithoutCForm() {
		return cstWithoutCForm;
	}
	public void setCstWithoutCForm(BigDecimal cstWithoutCForm) {
		this.cstWithoutCForm = cstWithoutCForm;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	@Override
	public String toString() {
		return "RateParams [id=" + id + ", custId=" + custId + ", prodId="
				+ prodId + ", ratePerNo=" + ratePerNo + ", ratePerLtr="
				+ ratePerLtr + ", ratePerCubMtr=" + ratePerCubMtr
				+ ", ratePerKg=" + ratePerKg + ", exciseRate=" + exciseRate
				+ ", cessExcise=" + cessExcise + ", eduCess=" + eduCess
				+ ", frieght=" + frieght + ", loading_chrgs=" + loading_chrgs
				+ ", unloadingChrgs=" + unloadingChrgs + ", withoutExcise="
				+ withoutExcise + ", srvcTaxFlag=" + srvcTaxFlag + ", srvcTax="
				+ srvcTax + ", supplementryInvoic=" + supplementryInvoic
				+ ", vat=" + vat + ", cstWithCForm=" + cstWithCForm
				+ ", cstWithoutCForm=" + cstWithoutCForm + ", saveType="
				+ saveType + "]";
	}
	
}
