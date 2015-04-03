package org.mahesh.samples.mvc.domain.security;

import java.util.List;

import org.mahesh.samples.mvc.views.PaginationParams;


public class AppUserDetails extends PaginationParams {

   /**
    * 
    */
   private static final long serialVersionUID = 4677520815578874093L;

   /**
    * Unique Surrogate Key.
    */
   private Long id;

   /**
    * Unique user id.
    */
   private String uniqueUserId;

   /**
    * user password.
    */
   private String password;

   /**
    * user first name.
    */
   private String firstName;

   /**
    * user last name.
    */
   private String lastName;

   /**
    * user email identifier.
    */
   private String emailId;

   /**
    * user employee identifier.
    */
   private String empId;

   /**
    * user designation in the corporate.
    */
   private String designation;

   /**
    * user phone number.
    */
   private String phone;

   /**
    * The role.
    */
   private String role;

   /**
    * user account status.
    */
   private boolean flagEnabled = Boolean.TRUE;

   /**
    * user account expire status.
    */
   private boolean flagAccountNonExpired = Boolean.TRUE;

   /**
    * user account lock status.
    */
   private boolean flagAccountNonLocked = Boolean.TRUE;

   /**
    * user password expire status.
    */
   private boolean flagCredentialsNonExpired = Boolean.TRUE;
   /**
    * user roles.
    */
   private List<AppRoleDetails> appRoleDetails;

   /** The status. */
   private Boolean status;

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
    * Returns unique user id.
    * 
    * @return the uniqueUserId.
    */
   public final String getUniqueUserId()
   {
      return uniqueUserId;
   }

   /**
    * Sets the unique user id.
    * 
    * @param pUniqueUserId
    *           unique user identifier.
    */
   public final void setUniqueUserId(final String pUniqueUserId)
   {
      this.uniqueUserId = pUniqueUserId;
   }

   /**
    * Returns the user password.
    * 
    * @return the password.
    */
   public final String getPassword()
   {
      return password;
   }

   /**
    * Sets the user password.
    * 
    * @param pPassword
    *           password of user.
    */
   public final void setPassword(final String pPassword)
   {
      this.password = pPassword;
   }

   /**
    * Returns first name of the user.
    * 
    * @return the first name.
    */
   public final String getFirstName()
   {
      return firstName;
   }

   /**
    * Sets the first name of the user.
    * 
    * @param pFirstName
    *           first name of user.
    */
   public final void setFirstName(final String pFirstName)
   {
      this.firstName = pFirstName;
   }

   /**
    * Returns last name of the user.
    * 
    * @return the last name.
    */
   public final String getLastName()
   {
      return lastName;
   }

   /**
    * Returns full name of the user.
    * 
    * @return the last name.
    */
   public final String getFullName()
   {
      return firstName + " " + lastName;
   }

   /**
    * Sets the last name of the user.
    * 
    * @param pLastName
    *           last name of user.
    */
   public final void setLastName(final String pLastName)
   {
      this.lastName = pLastName;
   }

   /**
    * Returns the email address of the user.
    * 
    * @return the email address.
    */
   public final String getEmailId()
   {
      return emailId;
   }

   /**
    * Sets the email address of the user.
    * 
    * @param pEmailId
    *           email address of the user.
    */
   public final void setEmailId(final String pEmailId)
   {
      this.emailId = pEmailId;
   }

   /**
    * Gets the employee identifier of the user.
    * 
    * @return the employee id.
    */
   public final String getEmpId()
   {
      return empId;
   }

   /**
    * Sets the employee identifier of the user.
    * 
    * @param pEmpId
    *           the employee Id
    */
   public final void setEmpId(final String pEmpId)
   {
      this.empId = pEmpId;
   }

   /**
    * Gets the designation of the user.
    * 
    * @return the designation.
    */
   public final String getDesignation()
   {
      return designation;
   }

   /**
    * Sets the designation of the user.
    * 
    * @param pDesignation
    *           designation of the user.
    */
   public final void setDesignation(final String pDesignation)
   {
      this.designation = pDesignation;
   }

   /**
    * Gets the phone number of the user.
    * 
    * @return the phone number.
    */
   public final String getPhone()
   {
      return phone;
   }

   /**
    * Sets the phone number of the user.
    * 
    * @param pPhone
    *           phone number of the user.
    */
   public final void setPhone(final String pPhone)
   {
      this.phone = pPhone;
   }

   /**
    * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
    * 
    * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
    */
   public final boolean isEnabled()
   {
      return flagEnabled;
   }

   /**
    * Sets the user account status.
    * 
    * @param pIsEnabled
    *           status of the user account.
    */
   public final void setEnabled(final boolean pIsEnabled)
   {
      this.flagEnabled = pIsEnabled;
   }

   public String getRole()
   {
      return role;
   }

   public void setRole(String role)
   {
      this.role = role;
   }

   /**
    * Indicates whether the user account is expired or active. An expired user account cannot be authenticated.
    * 
    * @return <code>true</code> if the user account is not expired, <code>false</code> otherwise
    */
   public final boolean isAccountNonExpired()
   {
      return flagAccountNonExpired;
   }

   /**
    * Sets the user account expire status..
    * 
    * @param pIsAccountNonExpired
    *           status of the user account expire.
    */
   public final void setAccountNonExpired(final boolean pIsAccountNonExpired)
   {
      this.flagAccountNonExpired = pIsAccountNonExpired;
   }

   /**
    * Indicates whether the user account is locked or active. A locked user account cannot be authenticated.
    * 
    * @return <code>true</code> if the user account is not locked, <code>false</code> otherwise
    */
   public final boolean isAccountNonLocked()
   {
      return flagAccountNonLocked;
   }

   /**
    * Sets the user account lock status.
    * 
    * @param pIsAccountNonLocked
    *           status of the user account lock.
    */
   public final void setAccountNonLocked(final boolean pIsAccountNonLocked)
   {
      this.flagAccountNonLocked = pIsAccountNonLocked;
   }

   /**
    * Indicates whether the user account password is expired or active. with expired password an user account cannot be
    * authenticated.
    * 
    * @return <code>true</code> if the user account password is not expired, <code>false</code> otherwise
    */
   public final boolean isCredentialsNonExpired()
   {
      return flagCredentialsNonExpired;
   }

   /**
    * Sets the user account password status.
    * 
    * @param pIsCredentialsNonExpired
    *           status of the user account password.
    */
   public final void setCredentialsNonExpired(final boolean pIsCredentialsNonExpired)
   {
      this.flagCredentialsNonExpired = pIsCredentialsNonExpired;
   }

   /**
    * Gets the associated roles for the user.
    * 
    * @return user roles.
    */
   public final List<AppRoleDetails> getAppRoleDetails()
   {
      return appRoleDetails;
   }

   /**
    * Sets the associated roles for the user.
    * 
    * @param pRoleDetails
    *           the role details.
    */
   public final void setCpdiRoleDetails(final List<AppRoleDetails> pRoleDetails)
   {
      this.appRoleDetails = pRoleDetails;
   }

   /**
    * @return the status
    */
   public boolean getStatus()
   {
      return status;
   }

   /**
    * @param status
    *           the status to set
    */
   public void setStatus(int status)
   {
      this.status = (status == 1) ? true : false;
   }

}
