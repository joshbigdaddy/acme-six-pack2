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
<form:form action="folder/create.do" modelAttribute="folder">
	<jstl:if test="${folder.id != 0}">
	<form:hidden path="id" />
	<form:hidden path="version" />
	</jstl:if>
	<jstl:if test="${restrict==null}">
	<acme:textbox code="folder.name" path="name"/>
	
	</jstl:if>
	<jstl:if test="${restrict!=null}">
	<form:hidden path="name" />
	<h1><spring:message code="folder.noEdit"></spring:message></h1>
	</jstl:if>
	
	<form:hidden path="actor" />	
	<form:hidden path="messages" />
	<jstl:if test="${folder.id == 0}">
	<acme:submit name="save" code="folder.create" />
	</jstl:if>
	<jstl:if test="${folder.id != 0}">
	<jstl:if test="${restrict==null}">
	<acme:submit name="save" code="folder.save"/>
	<acme:submit name="delete" code="folder.delete"/>
	</jstl:if>
	</jstl:if>
	<a href="folder/list.do"><acme:cancel url="folder/list.do" code="folder.cancel"/></a>
	
</form:form>
	
	