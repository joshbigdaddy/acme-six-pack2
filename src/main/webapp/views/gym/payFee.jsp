

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="feePayment/customer/edit.do" modelAttribute="feePayment">
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="gym"/>
	
<form:hidden path="paymentMoment" />
<form:hidden path="activeDay" />
<form:hidden path="inactiveDay" />
<form:hidden path="customer" />


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="gym" requestURI="${requestURI}" id="row">
	<spring:message code="gym.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="true" />
	<spring:message code="gym.fee" var="feeHeader" />
	<display:column property="fee" title="${feeHeader}" sortable="true" />
	<display:column>
	<input type="submit" name="save"
		value="<spring:message code="gym.payFee" />" />&nbsp; 
	</display:column>
</display:table>

	<a href="gym/show.do?gymId=${gymId}">
	<input type="button" name="return"
		value="<spring:message code="gym.return" />"
		onclick="javascript: relativeRedir('gym/list.do');" /></a>
		
		</form:form>