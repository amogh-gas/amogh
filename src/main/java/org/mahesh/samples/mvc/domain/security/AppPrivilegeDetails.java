package org.mahesh.samples.mvc.domain.security;

import java.io.Serializable;

public class AppPrivilegeDetails implements Serializable {

   /**
    * Serial Version ID.
    */
   private static final long serialVersionUID = 1L;

   /**
    * Unique Surrogate Key.
    */
   private Long id;

   /**
    * unique right code.
    */
   private String rightCode;

   /**
    * right name.
    */
   private String rightName;

   /**
    * right description.
    */
   private String rightDesc;

   /**
    * Returns surrogate key.
    * 
    * @return the id.
    */
   public final Long getId()
   {
      return id;
   }

   /**
    * Sets the surrogate key.
    * 
    * @param pId
    *           identifier value.
    */
   public final void setId(final Long pId)
   {
      this.id = pId;
   }

   /**
    * Returns the right code.
    * 
    * @return the right code.
    */
   public final String getRightCode()
   {
      return rightCode;
   }

   /**
    * Sets the right code.
    * 
    * @param pRightCode
    *           right code value.
    */
   public final void setRightCode(final String pRightCode)
   {
      this.rightCode = pRightCode;
   }

   /**
    * Returns the right name.
    * 
    * @return the right name.
    */
   public final String getRightName()
   {
      return rightName;
   }

   /**
    * Sets the right name.
    * 
    * @param pRightName
    *           right name.
    */
   public final void setRightName(final String pRightName)
   {
      this.rightName = pRightName;
   }

   /**
    * Returns the right description.
    * 
    * @return the right description.
    */
   public final String getRightDesc()
   {
      return rightDesc;
   }

   /**
    * Sets the rights description.
    * 
    * @param pRightDesc
    *           right Description.
    */
   public final void setRightDesc(final String pRightDesc)
   {
      this.rightDesc = pRightDesc;
   }

}
