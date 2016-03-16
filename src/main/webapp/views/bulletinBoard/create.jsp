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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>
<form:form action="bulletin/administrator/create.do" modelAttribute="bulletinBoard">
	<jstl:if test="${creditCard.id == 0}">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="publishedMoment"/>
	<acme:textbox code="bulletin.title" path="title"/>
	<acme:textbox code="bulletin.description" path="description"/>
	
	<input type="submit" name="create"
			value="<spring:message code="bulletin.create" />"
			onclick="return confirm('<spring:message code="bulletin.confirm.create" />')" />&nbsp;
	</jstl:if>
	<a href=""><acme:cancel url="" code="bulletin.cancel"/></a>
</form:form>
	
	