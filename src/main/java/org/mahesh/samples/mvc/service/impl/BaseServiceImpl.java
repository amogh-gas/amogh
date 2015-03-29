package org.mahesh.samples.mvc.service.impl;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.mahesh.samples.mvc.service.BaseService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseServiceImpl implements BaseService {

   private static final String LOGGING_CLASS_NAME = BaseServiceImpl.class.getName();

   /**
    * Logger for this class.
    */
   private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);


   /**
    * Return the current HTTP session.
    * 
    * @return HTTP session.
    */
   public HttpSession getCurrentHTTPSession()
   {
      LOGGER.entering(LOGGING_CLASS_NAME, ": getCurrentHTTPSession");
      ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
      LOGGER.exiting(LOGGING_CLASS_NAME, ": getCurrentHTTPSession");
      return attr.getRequest().getSession(false);

   }

}
