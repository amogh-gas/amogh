package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.mahesh.samples.mvc.domain.security.LovNode;
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

   /**
    * Retrieves node Id for the given description text.
    * 
    * @param descriptionTxt
    *           Description text
    * @return List<LovDescription> holds node Id, description text.
    */
   public final List<LovNode> getLovNodeByDescription(final String descriptionTxt)
   {
      /* @Transactional(propagation=Propagation.REQUIRED, readOnly=true) */
      
      LOGGER.entering(LOGGING_CLASS_NAME, ": getLovNodeByDescription");
      Map<String, String> params = new HashMap<String, String>();
      params.put("V_DESC_TEXT", descriptionTxt);
      List<LovNode> list = new ArrayList<LovNode>();

      LOGGER.exiting(LOGGING_CLASS_NAME, ": getLovNodeByDescription");
      return list;

   }
}
