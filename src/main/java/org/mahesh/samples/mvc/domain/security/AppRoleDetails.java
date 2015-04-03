package org.mahesh.samples.mvc.domain.security;

import java.io.Serializable;
import java.util.List;

public class AppRoleDetails implements Serializable {

   /**
    * Serial Version ID.
    */
   private static final long serialVersionUID = 1L;

   /**
    * Unique Surrogate Key.
    */
   private Long id;

   /**
    * unique role code.
    */
   private String roleCode;

   /**
    * Name of the user role.
    */
   private String roleName;

   /**
    * Description of the user role.
    */
   private String roleDesc;

   /**
    * Holds resource privilege details.
    * 
    */
   private List<AppPrivilegeDetails> privilegeDetails;

   /**
    * Default constructor.
    */
   public AppRoleDetails()
   {
      // instantiate object and do nothing
   }

   /**
    * Constructor.
    * 
    * @param pId
    *           identifier using Surrogate key.
    * @param pRoleCode
    *           role code.
    * @param pRoleName
    *           role name.
    * @param pRoleDesc
    *           role description.
    * @param pPrivilegeDetails
    *           resource privilege details.
    */
   public AppRoleDetails(final Long pId, final String pRoleCode, final String pRoleName, final String pRoleDesc,
         final List<AppPrivilegeDetails> pPrivilegeDetails)
   {
      super();
      this.id = pId;
      this.roleCode = pRoleCode;
      this.roleName = pRoleName;
      this.roleDesc = pRoleDesc;
      this.privilegeDetails = pPrivilegeDetails;
   }

   /**
    * Constructor.
    * 
    * @param pRoleCode
    *           role code.
    */
   public AppRoleDetails(final String pRoleCode)
   {
      super();
      this.roleCode = pRoleCode;
   }

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
    * Returns the role code.
    * 
    * @return the role code.
    */
   public final String getRoleCode()
   {
      return roleCode;
   }

   /**
    * Sets the role code.
    * 
    * @param pRoleCode
    *           role code value.
    */
   public final void setRoleCode(final String pRoleCode)
   {
      this.roleCode = pRoleCode;
   }

   /**
    * Returns the role name.
    * 
    * @return the role name.
    */
   public final String getRoleName()
   {
      return roleName;
   }

   /**
    * Sets the role name.
    * 
    * @param pRoleName
    *           role name value.
    */
   public final void setRoleName(final String pRoleName)
   {
      this.roleName = pRoleName;
   }

   /**
    * Returns the role description.
    * 
    * @return the role description.
    */
   public final String getRoleDesc()
   {
      return roleDesc;
   }

   /**
    * Sets the role description.
    * 
    * @param pRoleDesc
    *           role description.
    */
   public final void setRoleDesc(final String pRoleDesc)
   {
      this.roleDesc = pRoleDesc;
   }

   /**
    * Gets the resource Privilege Details.
    * 
    * @return privilegeDetails.
    */
   public final List<AppPrivilegeDetails> getPrivilegeDetails()
   {
      return privilegeDetails;
   }

   /**
    * Sets the resource Privilege Details.
    * 
    * @param pPrivilegeDetails
    *           resource Privilege value.
    */
   public final void setPrivilegeDetails(final List<AppPrivilegeDetails> pPrivilegeDetails)
   {
      this.privilegeDetails = pPrivilegeDetails;
   }

   /**
    * Equals implementation based on unique role code.
    * 
    * Note :PMD Violation is ignored for multiple returns
    * 
    * @param obj
    *           to be compared
    * 
    * @return boolean
    */
   @Override
   public final boolean equals(final Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (obj == null)
      {
         return false;
      }
      if (getClass() != obj.getClass())
      {
         return false;
      }
      final AppRoleDetails other = (AppRoleDetails) obj;
      if (roleCode == null)
      {
         if (other.roleCode != null)
         {
            return false;
         }
      }
      else if (!roleCode.equals(other.roleCode))
      {
         return false;
      }
      return true;
   }

   /**
    * HashCode implementation based on unique role code.
    * 
    * @return int
    */

   @Override
   public final int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
      return result;
   }

}
