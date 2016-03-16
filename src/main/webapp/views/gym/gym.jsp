<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div align="left">${picture}</div>
<div align="center"><font size="5">
${name}
</font>
<br>
${description}
<br>
<spring:message code="administrator.contact" var="contact" />
${postalAddress}
${telephone}
<br>
${fee}
</div>

<a href="${link}"><spring:message code="gym.goToGoogleMap"/></a>

<security:authorize access="hasRole('CUSTOMER')">
<jstl:if test="${haveCreditCard}">
<a href="feePayment/customer/payFee.do?gymId=${gymId}">
<input type="button" name="pay"
		value="<spring:message code="gym.payFee" />"
		onclick="javascript: relativeRedir('feePayment/customer/create.do?gymId=${gymId}');" />
		</a>
		</jstl:if>
<jstl:if test="${!haveCreditCard}">
<a href="creditcard/customer/create.do">
<input type="button" name="pay"
		value="<spring:message code="gym.payFee" />"
		onclick="javascript: relativeRedir('feePayment/customer/create.do?gymId=${gymId}');" />
		</a>
</jstl:if>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<a href="gym/administrator/showService.do?gymId=${gymId}">
<input type="button" name="addService"
		value="<spring:message code="gym.addService" />"
		onclick="javascript: relativeRedir('gym/administrator/showService.do?gymId=${gymId}');" />
		</a>
<a href="gym/administrator/edit.do?gymId=${gymId}">
<input type="button" name="edit"
		value="<spring:message code="gym.edit" />"
		onclick="javascript: relativeRedir('gym/administrator/edit.do?gymId=${gymId}');" />
		</a>
		
</security:authorize>
<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="service" requestURI="${requestURI}" id="row">
	
	<spring:message code="gym.service.name" var="nameHeader" />
	<display:column title="${nameHeader}" sortable="true"><a href="service/serviceDetails.do?serviceId=${row.id}">${row.name}</a></display:column>
	
	<spring:message code="gym.service.description" var="nameHeader" />
	<display:column property="description" title="${nameHeader}" sortable="true" />
	
	<security:authorize access="hasRole('ADMIN')">
	<display:column>
	<a href="gym/administrator/deleteService.do?serviceId=${row.id}&gymId=${gymId}"><spring:message code="gym.delete"/></a>
	</display:column>
	</security:authorize>
	</display:table>
	
<display:table pagesize="6" class="displaytag" keepStatus="true"
	name="comments" requestURI="${requestURI}" id="comments">
	<spring:message code="gym.comment.text" var="nameHeader" />
	<display:column property="text" title="${nameHeader}" sortable="true" />
	<spring:message code="gym.comment.rating" var="nameHeader" />
	<display:column property="starRating" title="${nameHeader}" sortable="true" />
	</display:table>

	<a href="gym/administrator/list.do">
	<input type="button" name="return"
		value="<spring:message code="gym.return" />"
		onclick="javascript: relativeRedir('gym/administrator/list.do');" /></a>