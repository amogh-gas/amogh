package org.mahesh.samples.mvc.domain.security;

public class SecuritySchemaViolationException extends AMOGHApplicationException {
   /**
    * The Serial version number.
    */
   private static final long serialVersionUID = 1L;

   /**
    * Create SecuritySchemaViolationException instance with given key and description.
    * 
    * @param newKey
    *           key to access the message
    * @param newMessage
    *           description of the message
    * @param newThroweable
    *           Throwable original exception.
    */
   public SecuritySchemaViolationException(final String newKey, final String newMessage, final Throwable newThroweable)
   {
      super(newKey, newMessage, newThroweable);
   }

   /**
    * Create SecuritySchemaViolationException instance with a description.
    * 
    * @param newMessage
    *           description of the message
    * @param throwable
    *           Throwable.
    */
   public SecuritySchemaViolationException(final String newMessage, final Throwable throwable)
   {
      super(newMessage, throwable);

   }
}
