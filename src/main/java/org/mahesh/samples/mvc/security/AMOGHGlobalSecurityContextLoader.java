package org.mahesh.samples.mvc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.mahesh.samples.mvc.domain.security.AppPrivilegeDetails;
import org.mahesh.samples.mvc.domain.security.AppRoleDetails;
import org.mahesh.samples.mvc.domain.security.ApplicationSecurityConstants;
import org.mahesh.samples.mvc.domain.security.LovNode;
import org.mahesh.samples.mvc.domain.security.SecuritySchemaViolationException;
import org.mahesh.samples.mvc.service.AMOGHGlobalContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ServletContextAware;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AMOGHGlobalSecurityContextLoader implements ServletContextAware {

	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = AMOGHGlobalSecurityContextLoader.class
			.getName();
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);
	/**
	 * Holds reference to ServletContext.
	 */
	private ServletContext servletContext;

	/**
	 * Holds reference to security XML resource.
	 */
	private ClassPathResource amoghSecurityInstance;

	/**
	 * Holds reference to security XSD resource.
	 */
	private ClassPathResource amoghSecuritySchema;

	@Autowired
	private AMOGHGlobalContextService amoghGlobalContextService;

	/**
	 * Default Constructor.
	 */
	public AMOGHGlobalSecurityContextLoader() {
		// Default constructor.
	}

	/**
	 * Custom constructor for spring injection.
	 * 
	 * @param pAmoghSecurityInstance
	 *            XML resource.
	 * @param pAmoghSecuritySchema
	 *            XSD resource.
	 */
	public AMOGHGlobalSecurityContextLoader(
			final ClassPathResource pAmoghSecurityInstance,
			final ClassPathResource pAmoghSecuritySchema) {
		this.amoghSecurityInstance = pAmoghSecurityInstance;
		this.amoghSecuritySchema = pAmoghSecuritySchema;

	}

	/**
	 * Invoked by Spring Core Container while loading the bean into
	 * applicationContext.
	 * 
	 */
	public final void init() {

		servletContext.setAttribute(
				ApplicationSecurityConstants.CONTEXT_LEVEL_SECURITY_DATA_KEY,
				loadGlobalAuthoritiesMapping());
		servletContext
				.setAttribute(
						ApplicationSecurityConstants.CONTEXT_LEVEL_SECURITY_DB_DATA_KEY,
						loadAuthoritiesFromDB());
	}

	/**
	 * Sets the servletContext.
	 * 
	 * @param pServletContext
	 *            ServletContext
	 */
	@Override
	public final void setServletContext(final ServletContext pServletContext) {
		this.servletContext = pServletContext;

	}

	/**
	 * Loads the master mapping data between role and privileges and caches at
	 * context level.
	 * 
	 * @return Map of role entity to List of privileges.
	 */
	private Map<AppRoleDetails, List<AppPrivilegeDetails>> loadGlobalAuthoritiesMapping() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": loadGlobalAuthoritiesMapping");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;

		Map<AppRoleDetails, List<AppPrivilegeDetails>> result = new LinkedHashMap<AppRoleDetails, List<AppPrivilegeDetails>>();

		if (null != amoghSecurityInstance) {
			try {
				if (validateXMLagainstXSD()) {
					dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(amoghSecurityInstance
							.getInputStream());
					doc.getDocumentElement().normalize();

					NodeList nList = doc
							.getElementsByTagName(ApplicationSecurityConstants.ELEMENT_PREV_TO_ROLE);
					if (null != nList) {
						LOGGER.info(nList.getLength()
								+ "<PrivilegeToRole> tags are present in XML ");
						for (int parentTemp = 0; parentTemp < nList.getLength(); parentTemp++) {
							final Node prNode = nList.item(parentTemp);
							if (null != prNode) {

								final AppRoleDetails roleDetails = new AppRoleDetails();
								final List<AppPrivilegeDetails> privilegeDetails = new ArrayList<AppPrivilegeDetails>();

								final NodeList children = prNode
										.getChildNodes();
								for (int child = 0; child < children
										.getLength(); child++) {
									final Node chrNode = children.item(child);
									if (null != chrNode) {

										if (chrNode
												.getNodeName()
												.equalsIgnoreCase(
														ApplicationSecurityConstants.ELEMENT_PREV_DTLS)) {
											final NodeList privilegeCodeList = chrNode
													.getChildNodes();
											if (null != privilegeCodeList
													&& privilegeCodeList
															.getLength() > 0) {
												for (int privilegeCodes = 0; privilegeCodes < privilegeCodeList
														.getLength(); privilegeCodes++) {
													final Node privilegeCode = privilegeCodeList
															.item(privilegeCodes);

													if (privilegeCode
															.getNodeName()
															.equalsIgnoreCase(
																	ApplicationSecurityConstants.ELEMENT_PREV_CODE)) {
														final AppPrivilegeDetails newPrivilegeDetails = new AppPrivilegeDetails();
														newPrivilegeDetails
																.setRightCode(ApplicationSecurityConstants.AUTHORIZATION_PREFIX
																		+ privilegeCode
																				.getTextContent()
																				.toUpperCase());
														privilegeDetails
																.add(newPrivilegeDetails);
													}
												}
											}
										} else if (chrNode
												.getNodeName()
												.equalsIgnoreCase(
														ApplicationSecurityConstants.ELEMENT_ROLE_DTLS)) {
											final NodeList roleDetailsList = chrNode
													.getChildNodes();
											if (null != roleDetailsList
													&& roleDetailsList
															.getLength() > 0) {
												for (int roles = 0; roles < roleDetailsList
														.getLength(); roles++) {
													final Node roleDetail = roleDetailsList
															.item(roles);

													if (roleDetail
															.getNodeName()
															.equalsIgnoreCase(
																	ApplicationSecurityConstants.ELEMENT_ROLE_CODE)) {
														roleDetails
																.setRoleCode(ApplicationSecurityConstants.AUTHORIZATION_PREFIX
																		+ roleDetail
																				.getTextContent()
																				.toUpperCase());
													}
												}
											}
										}
									}
								}
								result.put(roleDetails, privilegeDetails);

							}
						}
					}

				} else {
					LOGGER.log(Level.SEVERE, "SecuritySchemaViolationException");
					throw new SecuritySchemaViolationException(
							ApplicationSecurityConstants.SECURITY_SCHEMA_VIOLATION_EXCEPTION,
							null);
				}
			}

			catch (SAXException saxe) {
				LOGGER.log(Level.SEVERE,
						"SAXException while parsing security XML..." + saxe);
			} catch (IOException io) {
				LOGGER.log(Level.SEVERE,
						"IOException while parsing security XML..." + io);
			} catch (ParserConfigurationException pce) {
				LOGGER.log(Level.SEVERE,
						"ParserConfigurationException while parsing security XML..."
								+ pce);
			} catch (SecuritySchemaViolationException e) {
				LOGGER.log(Level.SEVERE,
						"Custom Exception: SecuritySchemaViolationException...XML not as per XSD.");
			} finally {
				// nullify to ensure unnecessary usage of memory.
				amoghSecurityInstance = null;
				amoghSecuritySchema = null;
			}
		}
		LOGGER.info("Final Map Result Size: " + result.size());
		LOGGER.exiting(LOGGING_CLASS_NAME, ": loadGlobalAuthoritiesMapping");
		return result;

	}

	/**
	 * Validates the XML against XSD.
	 * 
	 * @return validation result.
	 */
	private boolean validateXMLagainstXSD() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": validateXMLagainstXSD");
		boolean isMatched = false;

		if (null != amoghSecuritySchema) {
			final SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema;
			try {
				schema = factory.newSchema(amoghSecuritySchema.getFile());
				final Validator validator = schema.newValidator();
				validator.validate(new StreamSource(amoghSecurityInstance
						.getFile()));
				isMatched = true;
				LOGGER.info("Security XML defined is as per schema definition");
			} catch (SAXException e) {
				LOGGER.log(Level.SEVERE,
						"SAXException while validating XML against XSD ", e);
			} catch (IOException io) {
				LOGGER.log(Level.SEVERE,
						"IOException while validating XML against XSD ", io);
			}
		}
		LOGGER.info("is Security XML defined is as per schema definition ? : "
				+ isMatched);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": validateXMLagainstXSD");
		return isMatched;

	}

	/**
	 * Loads the application roles defined in DB.
	 * 
	 * @return lovNodes.
	 */
	private List<LovNode> loadAuthoritiesFromDB() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": loadAuthoritiesFromDB");
		return amoghGlobalContextService.getAllauthoritiesOfAMOGH();

	}

}
