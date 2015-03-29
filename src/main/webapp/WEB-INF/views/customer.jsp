<%@include file="imports.jsp" %>
<%@ page session="false"%>
<spring:message htmlEscape="true" code="customer.heading" var="pageTitle"/>
<jsp:include page="../views/header.jsp">
    <jsp:param name="pageTitle" value="${pageTitle}"/>
</jsp:include>

<div id="tabs">
<div class="wrapper row2">
  <div class="rounded">
	
	<div id="customerMenu" style="visibility: hidden;">
		<p class="mainMenuId">CUSTOMER</p>
		<input type="button" value="Open" id="showWindowButton" />
        <p></p>
		<div id="customerDetails" style="font-size: 13px; font-family: Verdana;"></div>
	</div>
	
	<div id="mainDemoContainer">
           <div id="customerWindow" style="visibility: hidden;">
               <div id="customWindowHeader" style="width:98%!important;">
                   <span id="captureContainer" style="float: left">Customer</span>
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
										<input type="text" id="name" name="name" class="text-input required customerReset"/>
										<input id="id" name="id" type="hidden" readonly="readonly" />
									</td>
								</tr>
                       			<tr>
									<td>Address:</td>
									<td><input type="text" id="address" name="address" class="text-input customerReset" /></td>
								</tr>
								<tr>
									<td>Area:</td>
									<td><input type="text" id="area" name="area" class="text-input customerReset"/></td>
								</tr>
								<tr>
									<td>State:</td>
									<td><input type="text" id="state"  name="state" class="text-input customerReset required" /></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" id="email" name="email" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Contact Person 1:</td>
									<td><input type="text" id="contactPerson1" name="contactPerson1" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Contact Person 2:</td>
									<td><input type="text" id="contactPerson2" name="contactPerson2" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Phone:</td>
									<td><input type="text" id="phone" name="phone" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Holding Advice:</td>
									<td><input type="text" id="holdingAdvice" name="holdingAdvice" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Credit Days:</td>
									<td><input type="text" id="creditDays" name="creditDays" class="text-input customerReset required"/></td>
								</tr>
                       		</table>		
                       	</td>
                       	<td> 
                       		<table>
                       			<tr><td colspan="2"/></tr>
								<tr>
									<td>Primay Mobile:</td>
									<td><input type="text" id="priMobile" name="priMobile" class="text-input customerReset"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Secondary Mobile:</td>
									<td><input type="text" id="secMobile"  name="secMobile" class="text-input customerReset required" /></td>
								</tr>
								<tr>
									<td>TIN Number:</td>
									<td><input type="text" id="tinNum" name="tinNum" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>CST Number:</td>
									<td><input type="text" id="cstNum" name="cstNum" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>PAN Number:</td>
									<td><input type="text" id="panNum" name="panNum" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>ECC Number:</td>
									<td><input type="text" id="eCCNum" name="eCCNum" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Max Cylinder:</td>
									<td><input type="text" id="maxCylinder" name="maxCylinder" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>Min Cylinder:</td>
									<td><input type="text" id="minCylinder" name="minCylinder" class="text-input customerReset required"/></td>
								</tr>
								<tr>
									<td>second:</td>
									<td><input type="text" id="second" name="second" class="text-input customerReset required"/></td>
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
<script type="text/javascript" src="<c:url value="/resources/masterjs/customer.js" />"></script>
<jsp:include page="../views/footer.jsp"/>
