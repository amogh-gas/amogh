package org.mahesh.samples.mvc.domain.security;

public final class ApplicationSecurityConstants {

	/**
	 * String literal for context level data reference key.
	 */
	public static final String CONTEXT_LEVEL_SECURITY_DATA_KEY = "contextLevelSecurityDataKey";

	/**
	 * String literal for context level database data reference key.
	 */
	public static final String CONTEXT_LEVEL_SECURITY_DB_DATA_KEY = "contextLevelSecurityDBDataKey";

	/**
	 * String literal for context level data reference key.
	 */
	public static final String CURRENT_ROLES_OF_USER_DB_ENTITIES = "currentUserRolesInDB";

	/**
	 * String literal for User Privileges.
	 */
	public static final String CURRENT_PRIVILEGES_OF_LOGGED_IN_USER = "currentPrivilegesOfLoggedInUser";

	/**
	 * String literal for Exception message.
	 */
	public static final String SECURITY_SCHEMA_VIOLATION_EXCEPTION = "XML provided violates XSD definition. "
			+ "Please validate the XML against XSD in development editor tool before using it in application";

	/**
	 * Role prefix.
	 */
	public static final String AUTHORIZATION_PREFIX = "ROLE_";

	/**
	 * String literal for XML tag element.
	 */
	public static final String ELEMENT_PREV_TO_ROLE = "PrivilegeToRole";

	/**
	 * String literal for XML tag element.
	 */
	public static final String ELEMENT_PREV_DTLS = "PrivilegeDetails";

	/**
	 * String literal for XML tag element.
	 */
	public static final String ELEMENT_PREV_CODE = "PrivilegeCode";

	/**
	 * String literal for XML tag element.
	 */
	public static final String ELEMENT_ROLE_DTLS = "RoleDetails";

	/**
	 * String literal for XML tag element.
	 */
	public static final String ELEMENT_ROLE_CODE = "RoleCode";

	/**
	 * Private Constructor.
	 */
	private ApplicationSecurityConstants() {

	}

}
