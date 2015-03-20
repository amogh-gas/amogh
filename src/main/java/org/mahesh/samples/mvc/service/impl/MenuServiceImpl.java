package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.MenuMapper;
import org.mahesh.samples.mvc.service.MenuService;
import org.mahesh.samples.mvc.views.MenuDetailsParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = MenuServiceImpl.class
			.getName();

	@Autowired
	public MenuMapper menuMapper;
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Override
	public List<MenuDetailsParams> getMenuDetails(MenuDetailsParams resource) {
		List<MenuDetailsParams> resources = new ArrayList<MenuDetailsParams>();
		LOGGER.entering(LOGGING_CLASS_NAME, ": getMenuDetails");
		Long currentPage = resource.getPagenum() * resource.getPagesize();
		resource.setFirstRow(currentPage);
		resource.setLastRow(currentPage + resource.getPagesize()-1);

		List<MenuDetailsParams> resourcesResult = menuMapper
				.getMenuDetails(resource);
		if (resourcesResult != null && resourcesResult.size() > 0) {
			resources = resourcesResult;
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getMenuDetails");
		return resources;
	}

	@Override
	public void insertMenuDetails(MenuDetailsParams resources) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": insertMenuDetails");
		menuMapper.insertMenuDetails(resources);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": insertMenuDetails");
	}

	@Override
	public void updateMenu(MenuDetailsParams resource) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": updateMenu");
		menuMapper.updateMenu(resource);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": updateMenu");
	}

	@Override
	public Long countTotalMenus(MenuDetailsParams resource) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": countTotalMenus");
		Long count = menuMapper.countTotalMenus(resource);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": countTotalMenus");
		return count;
	}

	@Override
	public List<MenuDetailsParams> getMenus() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": getMenus");
		List<MenuDetailsParams> menus = menuMapper.getMenus();
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getMenus");
		return menus;
	}
}
