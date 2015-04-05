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
                       				<td>Customer:</td>
									<td>
										<div id="custId" class="rounded jqx-dropdownlist-content required" style="height:20px;"></div>
									</td>
								</tr>
								<tr>
									<td>Product:</td>
									<td>
										<div id="prodId" class="rounded jqx-dropdownlist-content required" style="height:20px;"></div>
									</td>
								</tr>
								<tr>
									<td>Rate Per Num:</td>
									<td><input type="text" id="ratePerNo"  name="ratePerNo" class="text-input rateReset required" maxlength="20" placeHolder="Enter Rate Per No"/></td>
								</tr>
								<tr>
									<td>Rate Per Ltr:</td>
									<td><input type="text" id="ratePerLtr" name="ratePerLtr" class="text-input rateReset required" maxlength="50" placeHolder="Enter Rate Per Ltr"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Rate Per Cubic Mtr:</td>
									<td><input type="text" id="ratePerCubMtr" name="ratePerCubMtr" class="text-input rateReset required" maxlength="30" placeHolder="Enter Rate Per Cub Mtr"/></td>
								</tr>
								<tr>
									<td>Rate Per Kg:</td>
									<td><input type="text" id="ratePerKg" name="ratePerKg" class="text-input rateReset required" maxlength="30" placeHolder="Enter Rate Per Kg"/></td>
								</tr>
								<tr>
									<td>Excise Rate:</td>
									<td><input type="text" id="exciseRate" name="exciseRate" class="text-input rateReset required" maxlength="20" placeHolder="Enter Excise Rate"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Supplementry Invoice:</td>
									<td><input type="text" id="supplementryInvoice" name="supplementryInvoice" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter Supplementry Invoic"/></td>
								</tr>
								<tr>
									<td>Cess Excise:</td>
									<td><input type="text" id="cessExcise" name="cessExcise" class="text-input rateReset required" maxlength="20" placeHolder="Enter Cess Excise"/></td>
								</tr>								
                       		</table>		
                       	</td>
                       	<td> 
                       		<table>
								<tr>
									<td>Education Cess:</td>
									<td><input type="text" id="eduCess" name="eduCess" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter Edu Cess"/></td>
								</tr>
								<tr>
									<td>Frieght:</td>
									<td><input type="text" id="frieght" name="frieght" class="text-input rateReset" maxlength="20" placeHolder="Enter Frieght"/></td>
								</tr>
								<tr>
									<td>Loading Chrgs:</td>
									<td><input type="text" id="loadingChrgs"  name="loadingChrgs" class="text-input rateReset required" maxlength="20" placeHolder="Enter Loading Chrgs"/></td>
								</tr>
								<tr>
									<td>Unloading Chrgs:</td>
									<td><input type="text" id="unloadingChrgs" name="unloadingChrgs" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter Unloading Chrgs"/></td>
								</tr>
								<tr>
									<td>Without Excise:</td>
									<td><input type="text" id="withoutExcise" name="withoutExcise" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter Without Excise"/></td>
								</tr>
								<tr>
									<td>Srvc Tax Flag:</td>
									<td><input type="text" id="srvcTaxFlag" name="srvcTaxFlag" class="text-input rateReset required" maxlength="20" placeHolder="Enter Srvc Tax Flag"/></td>
								</tr>
								<tr>
									<td>Srvc Tax:</td>
									<td><input type="text" id="srvcTax" name="srvcTax" class="text-input rateReset required numeric" maxlength="20" placeHolder="Enter Srvc Tax"/></td>
								</tr>								
								<tr>
									<td>VAT:</td>
									<td><input type="text" id="vat" name="vat" class="text-input rateReset required numeric" maxlength="4" placeHolder="Enter VAT"/></td>
								</tr>
								<tr>
									<td>Cst With CForm:</td>
									<td><input type="text" id="cstWithCForm" name="cstWithCForm" class="text-input rateReset required numeric" maxlength="1" placeHolder="Enter Cst With CForm"/></td>
								</tr>
								<tr>
									<td nowrap="nowrap">Cst Without CForm:</td>
									<td><input type="text" id="cstWithoutCForm" name="cstWithoutCForm" class="text-input rateReset required numeric" maxlength="1" placeHolder="Enter Cst With Cst Without CForm"/></td>
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
