package org.mahesh.samples.mvc.service;

import javax.servlet.http.HttpSession;

public interface BaseService {

   /**
    * Return the current HTTP session.
    * 
    * @return HTTP session.
    */
   public HttpSession getCurrentHTTPSession();

}
