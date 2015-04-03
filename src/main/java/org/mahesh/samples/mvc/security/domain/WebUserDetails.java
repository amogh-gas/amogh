package org.mahesh.samples.mvc.security.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.springframework.util.StringUtils;
import org.mahesh.samples.mvc.domain.security.AppPrivilegeDetails;
import org.mahesh.samples.mvc.domain.security.AppRoleDetails;
import org.mahesh.samples.mvc.domain.security.AppUserDetails;
import org.mahesh.samples.mvc.domain.security.ApplicationSecurityConstants;
import org.mahesh.samples.mvc.domain.security.LovNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebUserDetails extends AppUserDetails implements UserDetails,
		ServletContextAware {

	/**
	 * The serial version number.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds authorities.
	 */
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Holds reference to ServletContext.
	 */
	private ServletContext servletContext;

	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = WebUserDetails.class
			.getName();
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	/**
	 * Returns final granted authorities to be used across CPDI application.
	 * 
	 * @return final granted authorities
	 */
	@Override
	public final Collection<? extends GrantedAuthority> getAuthorities() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": getAuthorities");
		final List<GrantedAuthority> finalAuthrorities = new ArrayList<GrantedAuthority>();
		// This is used to get the roles LOVs for current user's roles.
		populateUserRolesInSession(authorities);
		GrantedAuthority grantedAuthority = null;
		if (authorities != null && !authorities.isEmpty()) {
			for (final GrantedAuthority authority : authorities) {
				if (null != authority) {
					final String auth = authority.getAuthority();
					if (!StringUtils.isEmpty(auth)) {
						final AppRoleDetails tempRoleDetails = new AppRoleDetails(
								auth);
						final Map<AppRoleDetails, List<AppPrivilegeDetails>> masterAuthorities = getCPDIGlobalSecurityContextData();
						if (masterAuthorities.containsKey(tempRoleDetails)) {
							final List<AppPrivilegeDetails> rights = masterAuthorities
									.get(tempRoleDetails);
							if (rights != null && !rights.isEmpty()) {
								for (final AppPrivilegeDetails privilegeDetails : rights) {

									grantedAuthority = new SimpleGrantedAuthority(
											privilegeDetails.getRightCode());
									// de-duplicate
									if (!(finalAuthrorities
											.contains(grantedAuthority))) {
										finalAuthrorities.add(grantedAuthority);
									}

								}
							}

						}

					}

				}

			}

			// In JavaScript since we can't use spring TAG libraries for
			// security, storing privileges in session.
			populateUserprivilegesInSession(finalAuthrorities);
		}
		printAuthorities(finalAuthrorities);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getAuthorities");
		return finalAuthrorities;
	}

	@SuppressWarnings("unchecked")
   private void populateUserRolesInSession(
			Collection<? extends GrantedAuthority> authoritiesList) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": populateSessionDetails");
		List<LovNode> userRolesLOV = new ArrayList<LovNode>();
		List<LovNode> globalRolesLOV = getCPDIGlobalSecurityContextDBData();
		if (authoritiesList != null && !authoritiesList.isEmpty())
			for (final GrantedAuthority auth : authoritiesList) {
				if (null != auth) {
					LOGGER.info("CPDI GROUP NAME FOR : " + getUsername()
							+ " IS: " + auth.getAuthority());
					for (LovNode lovNode : globalRolesLOV) {
						if (null != lovNode) {
							String desc = lovNode.getNodeDesc();
							if (!StringUtils.isEmpty(desc)) {
								desc = "ROLE_" + desc.toUpperCase();
								if (desc.equalsIgnoreCase(auth.getAuthority())) {
									userRolesLOV.add(lovNode);
								}
							}
						}
					}
				}

			}

		if (userRolesLOV != null && !userRolesLOV.isEmpty()) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			attr.getRequest()
					.getSession()
					.setAttribute(
							ApplicationSecurityConstants.CURRENT_ROLES_OF_USER_DB_ENTITIES,
							userRolesLOV);
			printUserRoleLOV((List<LovNode>) attr
					.getRequest()
					.getSession()
					.getAttribute(
							ApplicationSecurityConstants.CURRENT_ROLES_OF_USER_DB_ENTITIES));
		}

	}

	@SuppressWarnings("unchecked")
   private void populateUserprivilegesInSession(
			final List<GrantedAuthority> finalAuthrorities) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": populateUserprivilegesInSession");
		List<String> privileges = new ArrayList<String>();
		if (finalAuthrorities != null && !finalAuthrorities.isEmpty()) {
			for (GrantedAuthority grant : finalAuthrorities) {
				if (null != grant) {
					privileges.add(grant.getAuthority());
				}
			}
		}
		if (privileges != null && !privileges.isEmpty()) {

			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			attr.getRequest()
					.getSession()
					.setAttribute(
							ApplicationSecurityConstants.CURRENT_PRIVILEGES_OF_LOGGED_IN_USER,
							privileges);
			printUserPrivileges((List<String>) attr
					.getRequest()
					.getSession()
					.getAttribute(
							ApplicationSecurityConstants.CURRENT_PRIVILEGES_OF_LOGGED_IN_USER));
		}

		LOGGER.exiting(LOGGING_CLASS_NAME, ": populateUserprivilegesInSession");

	}

	/**
	 * Sets authorities.
	 * 
	 * @param pAuthorities
	 *            authorities.
	 */
	public final void setAuthorities(
			final Collection<? extends GrantedAuthority> pAuthorities) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": setAuthorities");
		this.authorities = pAuthorities;
		LOGGER.exiting(LOGGING_CLASS_NAME, ": setAuthorities");
	}

	/**
	 * Gets unique user name for user authentication and authorisation.
	 * 
	 * @return username String
	 */
	@Override
	public final String getUsername() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": getUsername");
		return this.getUniqueUserId();
	}

	/**
	 * Sets ServletContext reference.
	 * 
	 * @param pServletContext
	 *            servlet context
	 */
	@Override
	public final void setServletContext(final ServletContext pServletContext) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": setServletContext");
		this.servletContext = pServletContext;
		LOGGER.exiting(LOGGING_CLASS_NAME, ": setServletContext");

	}

	/**
	 * Gets global mapping defines at XML level.
	 * 
	 * @return Map of roles to rights.
	 */
	@SuppressWarnings("unchecked")
	private Map<AppRoleDetails, List<AppPrivilegeDetails>> getCPDIGlobalSecurityContextData() {
		LOGGER.entering(LOGGING_CLASS_NAME,
				": getCPDIGlobalSecurityContextData");
		return (Map<AppRoleDetails, List<AppPrivilegeDetails>>) servletContext
				.getAttribute(ApplicationSecurityConstants.CONTEXT_LEVEL_SECURITY_DATA_KEY);
	}

	/**
	 * Gets roles in database.
	 * 
	 * @return Map of roles to rights.
	 */
	@SuppressWarnings("unchecked")
	private List<LovNode> getCPDIGlobalSecurityContextDBData() {
		LOGGER.entering(LOGGING_CLASS_NAME,
				": getCPDIGlobalSecurityContextDBData");
		return (List<LovNode>) servletContext
				.getAttribute(ApplicationSecurityConstants.CONTEXT_LEVEL_SECURITY_DB_DATA_KEY);
	}

	/**
	 * Logs authorities to log appender.
	 * 
	 * @param pAuthorities
	 *            authorities. .
	 */
	private void printAuthorities(
			final Collection<? extends GrantedAuthority> pAuthorities) {
		if (LOGGER.isLoggable(Level.INFO)
				&& pAuthorities != null && !pAuthorities.isEmpty()) {
			LOGGER.info("Size of authorities from source : "
					+ pAuthorities.size());
			for (final GrantedAuthority auth : pAuthorities) {
				if (null != auth) {
					LOGGER.info("Authority for user " + getUsername()
							+ " from source: " + auth.getAuthority());
				}

			}

		}

	}

	/**
	 * Logs authorities to log appender.
	 * 
	 * @param pAuthorities
	 *            authorities. .
	 */
	private void printUserRoleLOV(List<LovNode> userLovNodes) {
		if (LOGGER.isLoggable(Level.INFO)
				&& userLovNodes != null && !userLovNodes.isEmpty()) {
			LOGGER.info("User Roles Stored in SESSION  : "
					+ userLovNodes.size());
			for (LovNode lovNode : userLovNodes) {
				if (null != lovNode) {
					LOGGER.info("LOV ID: " + lovNode.getId());
					LOGGER.info("LOV DESC: " + lovNode.getNodeDesc());
					LOGGER.info("LOV EXTERNAL SYSTEM  CODE: "
							+ lovNode.getExternalSystemCode());
				}

			}

		}

	}

	/**
	 * Prints User privileges.
	 * 
	 * @param privileges
	 *            privileges. .
	 */
	private void printUserPrivileges(List<String> privileges) {
		if (LOGGER.isLoggable(Level.INFO)
				&& authorities != null && !authorities.isEmpty()) {
			LOGGER.info("privileges Stored In SESSION : " + privileges.size());
			for (String privilege : privileges) {
				if (null != privilege) {
					LOGGER.info("PRIVILAGE NAME : " + privilege);

				}

			}

		}

	}

}
