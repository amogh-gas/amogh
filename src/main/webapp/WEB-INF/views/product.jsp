<%@include file="imports.jsp" %>
<%@ page session="false"%>
<spring:message htmlEscape="true" code="product.heading" var="pageTitle"/>
<jsp:include page="../views/header.jsp">
    <jsp:param name="pageTitle" value="${pageTitle}"/>
</jsp:include>

<div id="tabs">
<div class="wrapper row2">
  <div class="rounded">
	
	<div id="productMenu" style="visibility: hidden;">
		<p class="mainMenuId">PRODUCT</p>
		<input type="button" value="Open" id="showWindowButton" />
        <p></p>
		<div id="productDetails" style="font-size: 13px; font-family: Verdana;"></div>
	</div>
	
	<div id="mainDemoContainer">
           <div id="customWindow" style="visibility: hidden;">
               <div id="customWindowHeader" style="width:98%!important;">
                   <span id="captureContainer" style="float: left">Product </span>
               </div>
               <div id="customWindowContent" style="overflow: hidden">
                   <input id="saveType" name="saveType" type="hidden" readonly="readonly"/>
                   <div style="margin: 5px">
                       <table class="register-table">
						<tr>
							<td>Product Name:</td>
							<td>
								<input type="text" id="name" name="name" class="text-input required productReset"/>
								<input id="id" name="id" type="hidden" readonly="readonly" />
							</td>
						</tr>
						<tr>
							<td>Product Type:</td>
							<td>
								<div id="typeId" class="rounded jqx-dropdownlist-content required" style="height:20px;"></div>
							</td>
						</tr>
						<tr>
							<td>Product Desc:</td>
							<td><input type="text" id="desc" name="desc" class="text-input productReset" /></td>
						</tr>
						<tr>
							<td>Short Desc:</td>
							<td><input type="text" id="shortDesc" name="shortDesc" class="text-input productReset"/></td>
						</tr>
						<tr>
							<td>Unit:</td>
							<td><input type="text" id="unit"  name="unit" class="text-input productReset required" /></td>
						</tr>
						<tr>
							<td>Under:</td>
							<td><input type="text" id="under" name="under" class="text-input productReset required"/></td>
						</tr>
						<tr>
							<td>Tariff Code:</td>
							<td><input type="text" id="tariffCode" name="tariffCode" class="text-input productReset required"/></td>
						</tr>
						<tr><td colspan="2"></td></tr>
						<tr>
							<td colspan="2" style="text-align: center;">
								<input type="button" value="Cancel" id="cancelButton" style="float:right;margin-bottom: 5px;"/>
								<input type="button" value="Save" style="float:right;margin-bottom: 5px;" id="saveButton" />
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
<script type="text/javascript" src="<c:url value="/resources/masterjs/product.js" />"></script>
<jsp:include page="../views/footer.jsp"/>
