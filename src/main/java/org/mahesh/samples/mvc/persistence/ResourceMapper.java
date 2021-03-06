package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.MenuDetailsParams;

public interface ResourceMapper {

	List<MenuDetailsParams> getMenuDetails(MenuDetailsParams menuParams);

	Long countTotalMenus(MenuDetailsParams menuParams);

	void insertMenuDetails(MenuDetailsParams menuParams);

	void updateMenu(MenuDetailsParams menuParams);
}
