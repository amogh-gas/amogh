package org.mahesh.samples.mvc.domain.security;

public class AMOGHApplicationException extends Exception {
   /**
    * Serial Version ID.
    */
   private static final long serialVersionUID = 1L;

   /** The Key for Localization. */
   private String key;

   /** The message for communication. */
   private String message;

   /**
    * Create WORKException instance with given key and description.
    * 
    * @param newKey
    *           key to access the message
    * @param newMessage
    *           description of the message
    * @param newThroweable
    *           Throwable original exception.
    */
   public AMOGHApplicationException(final String newKey, final String newMessage, final Throwable newThroweable)
   {
      super();
      this.key = newKey;
      this.message = newMessage;
      this.initCause(newThroweable);

   }

   /**
    * Create WORKException instance with a description.
    * 
    * @param newMessage
    *           description of the message
    * @param throwable
    *           Throwable.
    */
   public AMOGHApplicationException(final String newMessage, final Throwable throwable)
   {
      super();
      this.message = newMessage;
      this.initCause(throwable);

   }

   /**
    * Get the key.
    * 
    * @return key the key value as a string
    */
   public final String getKey()
   {
      return key;
   }

   /**
    * Sets the Key.
    * 
    * @param newKey
    *           the Key value as a string
    */
   public final void setKey(final String newKey)
   {
      this.key = newKey;
   }

   /**
    * Gets the message.
    * 
    * @return message the message
    */
   public final String getMessage()
   {
      return message;
   }

   /**
    * Set the new message.
    * 
    * @param newMessage
    *           the message
    */
   public final void setMessage(final String newMessage)
   {
      this.message = newMessage;
   }

}
