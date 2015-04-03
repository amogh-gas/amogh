package org.mahesh.samples.mvc.security;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.security.domain.WebUserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;

public class AMOGHGrantedAuthoritiesUserDetailsService extends PreAuthenticatedGrantedAuthoritiesUserDetailsService
      implements ApplicationContextAware {

   /**
    * Holds references to applicationContext for loading prototype bean.
    */
   private ApplicationContext applicationContext;

   /**
    * prototype bean name for user details entity.
    */
   private static final String USER_DETAILS_ALIAS = "userDetails";

   /**
    * Logger Name for this class.
    */
   private static final String LOGGING_CLASS_NAME = AMOGHGrantedAuthoritiesUserDetailsService.class.getName();
   /**
    * Logger for this class.
    */
   private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

   /**
    * Call back method for creating user details.
    * 
    * @param token
    *           the token
    * 
    * @param pAuthorities
    *           the authoriities
    * 
    * @return UserDetails the user details
    */
   @Override
   public final UserDetails createuserDetails(final Authentication token,
         final Collection<? extends GrantedAuthority> pAuthorities)
   {
      LOGGER.entering(LOGGING_CLASS_NAME, ": createuserDetails");
      final WebUserDetails userDetails = getUserDetails();
      if (null != token)
      {
         LOGGER.info("Autentication Token in not empty...proceeding..");
         printAuthorities(pAuthorities, token);
         userDetails.setUniqueUserId(token.getName());
         userDetails.setAuthorities(pAuthorities);

      }
      LOGGER.exiting(LOGGING_CLASS_NAME, ": createuserDetails");
      return userDetails;

   }

   /**
    * Sets applicationConext.
    * 
    * @param pApplicationContext
    *           the ApplicationContext
    * 
    * @see
    * 
    */
   @Override
   public final void setApplicationContext(final ApplicationContext pApplicationContext)
   {
      LOGGER.entering(LOGGING_CLASS_NAME, ": setApplicationContext");
      this.applicationContext = pApplicationContext;
      LOGGER.exiting(LOGGING_CLASS_NAME, ": setApplicationContext");

   }

   /**
    * Gets SpringUserDetails object.
    * 
    * @return SpringUserDetails.
    */
   public final WebUserDetails getUserDetails()
   {
      LOGGER.entering(LOGGING_CLASS_NAME, ": getUserDetails");
      return (WebUserDetails) applicationContext.getBean(USER_DETAILS_ALIAS);
   }

   /**
    * Logs authorities to log appender.
    * 
    * @param authorities
    *           authorities.
    * @param token
    *           token.
    */
   private void printAuthorities(final Collection<? extends GrantedAuthority> authorities, final Authentication token)
   {
      if (LOGGER.isLoggable(Level.INFO) && authorities != null && !authorities.isEmpty())
      {
         LOGGER.info("Size of authorities from source: " + authorities.size());
         for (final GrantedAuthority auth : authorities)
         {
            if (null != auth)
            {
               LOGGER.info("Authority for user " + token.getName() + " from source: " + auth.getAuthority());
            }

         }

      }
      else{
    	  LOGGER.info("Empty Authroties");
      }

   }

}
