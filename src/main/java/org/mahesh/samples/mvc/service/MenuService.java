package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.MenuDetailsParams;

public interface MenuService {

	List<MenuDetailsParams> getMenuDetails(MenuDetailsParams menuParams);

	Long countTotalMenus(MenuDetailsParams menuParams);

	void insertMenuDetails(MenuDetailsParams menuParams);

	void updateMenu(MenuDetailsParams menuParams);

	List<MenuDetailsParams> getMenus();

}
