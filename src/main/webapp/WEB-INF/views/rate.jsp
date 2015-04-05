<%@include file="imports.jsp" %>
<%@ page session="false"%>
<spring:message htmlEscape="true" code="rate.heading" var="pageTitle"/>
<jsp:include page="../views/header.jsp">
    <jsp:param name="pageTitle" value="${pageTitle}"/>
</jsp:include>

<div id="tabs">
<div class="wrapper row2">
  <div class="rounded">
	
	<div id="rateMenu" style="visibility: hidden;">
		<p class="mainMenuId">RATE</p>
		<input type="button" value="Open" id="showWindowButton" />
        <p></p>
		<div id="rateDetails" style="font-size: 13px; font-family: Verdana;"></div>
	</div>
	
	<div id="mainDemoContainer">
           <div id="rateWindow" style="visibility: hidden;">
               <div id="customWindowHeader" style="width:98%!important;">
                   <span id="captureContainer" style="float: left">Rate</span>
               </div>
               <div id="customWindowContent" style="overflow: hidden">
                   <input id="saveType" name="saveType" type="hidden" readonly="readonly"/>
                   <div style="margin: 5px">
                       <table class="register-table">
                       <tr>
                       	<td> 
                       		<table>
                       			<tr>
									<td>Name:</td>
									<td align="left">
										<input type="text" id="name" name="name" class="text-input required rateReset" maxlength="100" placeHolder="Enter Rate Name"/>
										<input id="id" name="id" type="hidden" readonly="readonly" />
									</td>
								</tr>
                       			<tr>
									<td>Address:</td>
									<td><input type="text" id="address" name="address" class="text-input rateReset" maxlength="200" placeHolder="Enter Address"/></td>
								</tr>
								<tr>
									<td>Area:</td>
									<td><input type="text" id="area" name="area" class="text-input rateReset" maxlength="50" placeHolder="Enter Area"/></td>
								</tr>
								<tr>
									<td>State:</td>
									<td><input type="text" id="state"  name="state" class="text-input rateReset required" maxlength="20" placeHolder="Enter State"/></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" id="email" name="email" class="text-input rateReset required" maxlength="50" placeHolder="Enter Email"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Contact Person 1:</td>
									<td><input type="text" id="contactPerson1" name="contactPerson1" class="text-input rateReset required" maxlength="30" placeHolder="Enter Contact Person 1"/></td>
								</tr>
								<tr>
									<td>Contact Person 2:</td>
									<td><input type="text" id="contactPerson2" name="contactPerson2" class="text-input rateReset required" maxlength="30" placeHolder="Enter Contact Person 2"/></td>
								</tr>
								<tr>
									<td>Phone:</td>
									<td><input type="text" id="phone" name="phone" class="text-input rateReset required" maxlength="20" placeHolder="Enter Phone Number"/></td>
								</tr>
								<tr>
									<td>Holding Advice:</td>
									<td><input type="text" id="holdingAdvice" name="holdingAdvice" class="text-input rateReset required" maxlength="1" placeHolder="Enter Holding Advice"/></td>
								</tr>
								<tr>
									<td>Credit Days:</td>
									<td><input type="text" id="creditDays" name="creditDays" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter Credit Days"/></td>
								</tr>
                       		</table>		
                       	</td>
                       	<td> 
                       		<table>
                       			<tr><td colspan="2"/></tr>
								<tr>
									<td>Primary Mobile:</td>
									<td><input type="text" id="priMobile" name="priMobile" class="text-input rateReset" maxlength="20" placeHolder="Enter Primary Mobile Number"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Secondary Mobile:</td>
									<td><input type="text" id="secMobile"  name="secMobile" class="text-input rateReset required" maxlength="20" placeHolder="Enter Secondary Mobile Number"/></td>
								</tr>
								<tr>
									<td>TIN Number:</td>
									<td><input type="text" id="tinNum" name="tinNum" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter TIN Number"/></td>
								</tr>
								<tr>
									<td>CST Number:</td>
									<td><input type="text" id="cstNum" name="cstNum" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter CST Number"/></td>
								</tr>
								<tr>
									<td>PAN Number:</td>
									<td><input type="text" id="panNum" name="panNum" class="text-input rateReset required" maxlength="20" placeHolder="Enter PAN Number"/></td>
								</tr>
								<tr>
									<td>ECC Number:</td>
									<td><input type="text" id="eCCNum" name="eCCNum" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter ECC Number"/></td>
								</tr>
								<tr>
									<td>Max Cylinder:</td>
									<td><input type="text" id="maxCylinder" name="maxCylinder" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter Max Cylinder"/></td>
								</tr>
								<tr>
									<td>Min Cylinder:</td>
									<td><input type="text" id="minCylinder" name="minCylinder" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter Min Cylinder"/></td>
								</tr>
								<tr>
									<td>second:</td>
									<td><input type="text" id="second" name="second" class="text-input rateReset required numeric" maxlength="1" placeHolder="Enter Second"/></td>
								</tr>
                       		</table>
                       	</td>
                       </tr>						
						<tr><td colspan="2"></td></tr>
						<tr>
							<td colspan="2" style="text-align: left;">
								<input type="button" value="Save" style="float:left;margin-bottom: 5px;" id="saveButton" />  
								<input type="button" value="Cancel" id="cancelButton" style="float:left;margin-bottom: 5px;"/>
							</td>
						</tr>
					</table>                        
               	</div>
          		 </div>
      		 </div>
	</div>
</div>
</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/masterjs/rate.js" />"></script>
<jsp:include page="../views/footer.jsp"/>
