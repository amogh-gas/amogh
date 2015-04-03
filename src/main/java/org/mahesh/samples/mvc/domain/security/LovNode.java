package org.mahesh.samples.mvc.domain.security;

import java.io.Serializable;
import java.util.Date;

public class LovNode implements Serializable {

	/**
	 * Default Serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/** The hierarchy tree node id. **/
	private Long id;

	/** The hierarchy tree node description id. **/
	private Long nodeDescId;

	/** The hierarchy tree node description. **/
	private String nodeDesc;

	/** The hierarchy tree node default description. **/
	private String nodeDefaultDesc;

	/** The hierarchy tree node description locale. **/
	private String locale;

	/** The hierarchy tree node default description locale. **/
	private String defaultLocale;

	/** The hierarchy tree node type id. **/
	private Long typeId;

	/** The hierarchy tree node type code. **/
	private String typeCode;

	/** The hierarchy tree node flat list. **/
	private Long isFlatList;

	/** The hierarchy tree node type description id. **/
	private Long typeDescId;

	/** The hierarchy tree node type description code. **/
	private String typeDesc;

	/** The hierarchy tree node valid from date. **/
	private Date validFromDate;

	/** The hierarchy tree node valid to date. **/
	private Date validToDate;

	/** The hierarchy tree node external system code. **/
	private String externalSystemCode;

	/** The hierarchy tree node level. **/
	private int level;

	/** The display status. **/
	private boolean display;
	/**
	 * Read Group Name.
	 */
	private String readGroup;

	/**
	 * Write Group Name.
	 */
	private String writeGroup;

	/**  For UI use only *. */
	private boolean isReadPrivileges;
	
	/**  For UI use only *. */
	private boolean isWritePrivileges;
	
	/** external System Code In numeric. */
	private Object externalSystemCodeInNumeric;
	
	
	/** The external system id. 
	 * This variable is used in IMI Queries and will hold the id .
	 * As the ID is string in few cases for IMI , 
	 * we will have to use this  */
	private String externalSystemId;

	/**
	 * Checks if is read privileges.
	 *
	 * @return true, if is read privileges
	 */
	public boolean isReadPrivileges() {
		return isReadPrivileges;
	}

	/**
	 * Sets the read privileges.
	 *
	 * @param isReadPrivileges the new read privileges
	 */
	public void setReadPrivileges(boolean isReadPrivileges) {
		this.isReadPrivileges = isReadPrivileges;
	}

	/**
	 * Checks if is write privileges.
	 *
	 * @return true, if is write privileges
	 */
	public boolean isWritePrivileges() {
		return isWritePrivileges;
	}

	/**
	 * Sets the write privileges.
	 *
	 * @param isWritePrivileges the new write privileges
	 */
	public void setWritePrivileges(boolean isWritePrivileges) {
		this.isWritePrivileges = isWritePrivileges;
	}

	/**
	 * Checks if is display.
	 *
	 * @return true, if is display
	 */
	public boolean isDisplay() {
		return display;
	}

	/**
	 * Sets the display.
	 *
	 * @param display the new display
	 */
	public void setDisplay(boolean display) {
		this.display = display;
	}

	/**
	 * Gets the read group.
	 *
	 * @return the read group
	 */
	public String getReadGroup() {
		return readGroup;
	}

	/**
	 * Sets the read group.
	 *
	 * @param readGroup the new read group
	 */
	public void setReadGroup(String readGroup) {
		this.readGroup = readGroup;
	}

	/**
	 * Gets the write group.
	 *
	 * @return the write group
	 */
	public String getWriteGroup() {
		return writeGroup;
	}

	/**
	 * Sets the write group.
	 *
	 * @param writeGroup the new write group
	 */
	public void setWriteGroup(String writeGroup) {
		this.writeGroup = writeGroup;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the node desc id.
	 *
	 * @return the nodeDescId
	 */
	public Long getNodeDescId() {
		return nodeDescId;
	}

	/**
	 * Sets the node desc id.
	 *
	 * @param nodeDescId            the nodeDescId to set
	 */
	public void setNodeDescId(Long nodeDescId) {
		this.nodeDescId = nodeDescId;
	}

	/**
	 * Gets the node desc.
	 *
	 * @return the nodeDesc
	 */
	public String getNodeDesc() {
		return nodeDesc;
	}

	/**
	 * Sets the node desc.
	 *
	 * @param nodeDesc            the nodeDesc to set
	 */
	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc;
	}

	/**
	 * Gets the node default desc.
	 *
	 * @return the nodeDefaultDesc
	 */
	public String getNodeDefaultDesc() {
		return nodeDefaultDesc;
	}

	/**
	 * Sets the node default desc.
	 *
	 * @param nodeDefaultDesc            the nodeDefaultDesc to set
	 */
	public void setNodeDefaultDesc(String nodeDefaultDesc) {
		this.nodeDefaultDesc = nodeDefaultDesc;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Gets the type id.
	 *
	 * @return the typeId
	 */
	public Long getTypeId() {
		return typeId;
	}

	/**
	 * Sets the type id.
	 *
	 * @param typeId            the typeId to set
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * Gets the type code.
	 *
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * Sets the type code.
	 *
	 * @param typeCode            the typeCode to set
	 */
	public void settypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * Gets the default locale.
	 *
	 * @return the defaultLocale
	 */
	public String getDefaultLocale() {
		return defaultLocale;
	}

	/**
	 * Sets the default locale.
	 *
	 * @param defaultLocale            the defaultLocale to set
	 */
	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	/**
	 * Gets the type desc id.
	 *
	 * @return the typeDescId
	 */
	public Long getTypeDescId() {
		return typeDescId;
	}

	/**
	 * Sets the type desc id.
	 *
	 * @param typeDescId            the typeDescId to set
	 */
	public void setTypeDescId(Long typeDescId) {
		this.typeDescId = typeDescId;
	}

	/**
	 * Gets the type desc.
	 *
	 * @return the typeDesc
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Sets the type desc.
	 *
	 * @param typeDesc            the typeDesc to set
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	/**
	 * Gets the valid from date.
	 *
	 * @return the validFromDate
	 */
	public Date getValidFromDate() {
		return validFromDate;
	}

	/**
	 * Sets the valid from date.
	 *
	 * @param validFromDate            the validFromDate to set
	 */
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	/**
	 * Gets the valid to date.
	 *
	 * @return the validToDate
	 */
	public Date getValidToDate() {
		return validToDate;
	}

	/**
	 * Sets the valid to date.
	 *
	 * @param validToDate            the validToDate to set
	 */
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets the external system code.
	 *
	 * @return the externalSystemCode
	 */
	public String getExternalSystemCode() {
		return externalSystemCode;
	}

	/**
	 * Sets the external system code.
	 *
	 * @param externalSystemCode            the externalSystemCode to set
	 */
	public void setExternalSystemCode(String externalSystemCode) {
		this.externalSystemCode = externalSystemCode;
	}

	/**
	 * Gets the checks if is flat list.
	 *
	 * @return the checks if is flat list
	 */
	public Long getIsFlatList() {
		return isFlatList;
	}

	/**
	 * Sets the checks if is flat list.
	 *
	 * @param isFlatList the new checks if is flat list
	 */
	public void setIsFlatList(Long isFlatList) {
		this.isFlatList = isFlatList;
	}

	/**
	 * Gets the external system code in numeric.
	 *
	 * @return the external system code in numeric
	 */
	public Object getExternalSystemCodeInNumeric() {
		return externalSystemCodeInNumeric;
	}

	/**
	 * Sets the external system code in numeric.
	 *
	 * @param externalSystemCodeInNumeric the new external system code in numeric
	 */
	public void setExternalSystemCodeInNumeric(
			Object externalSystemCodeInNumeric) {
		this.externalSystemCodeInNumeric = externalSystemCodeInNumeric;
	}

	/**
	 * Gets the external system id.
	 *
	 * @return the external system id
	 */
	public String getExternalSystemId() {
		return externalSystemId;
	}

	/**
	 * Sets the external system id.
	 *
	 * @param externalSystemId the new external system id
	 */
	public void setExternalSystemId(String externalSystemId) {
		this.externalSystemId = externalSystemId;
	}

}
