package org.mahesh.samples.mvc.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.domain.security.LovNode;
import org.mahesh.samples.mvc.service.AMOGHGlobalContextService;
import org.springframework.stereotype.Service;

/**
 * The Class AMOGHGlobalContextServiceImpl.
 */
@Service("amoghGlobalContextService")
public class AMOGHGlobalContextServiceImpl extends BaseServiceImpl implements AMOGHGlobalContextService {

   /**
    * Logger Name for this class.
    */
   private static final String LOGGING_CLASS_NAME = AMOGHGlobalContextServiceImpl.class.getName();
   /**
    * Logger for this class.
    */
   private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

   /**
    * String Literal for groups flat list.
    */
   private static final String GROUP_LIST = "Business Area Groups";

   @Override
   public List<LovNode> getAllauthoritiesOfAMOGH()
   {
      List<LovNode> nodes = null;
      LOGGER.entering(LOGGING_CLASS_NAME, ": getAllauthoritiesOfXLIO");
      nodes = getLovNodeByDescription(GROUP_LIST);
      return nodes;
   }
}
