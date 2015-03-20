package org.mahesh.samples.mvc.views;

public class MenuDetailsParams extends PaginationParams {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String menuDesc;
	private long parentId;
	private String menuUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Override
	public String toString() {
		return "MenuDetailsParams [id=" + id + ", menuDesc=" + menuDesc
				+ ", parentId=" + parentId + ", menuUrl=" + menuUrl + "]";
	}
	
	
}
