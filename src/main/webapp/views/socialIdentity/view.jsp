<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="socialIdentity/customer/view.do"
	modelAttribute="socialIdentity">


	<jstl:if test="${socialIdentity.id == 0}">

		<p>
			<spring:message code="view.create" />
		</p>
		<form:hidden path="id" />
		<form:hidden path="version" />


		<acme:textbox code="socialNetwork" path="socialNetwork" />

		<acme:textbox code="url" path="url" />

		<acme:textbox code="picture" path="picture" />

		<acme:textbox code="nick" path="nick" />

		<acme:submit name="create" code="socialIdentity.create" />

		<acme:cancel url="javascript: relativeRedir('Acme-Six-Packt');"
			code="userAccount.cancel" />

	</jstl:if>

	<jstl:if test="${socialIdentity.id != 0}">

		<p>
			<spring:message code="nick" />
			<jstl:out value="${socialIdentity.nick}" />
		</p>
		<p>
			<spring:message code="socialNetwork" />
			<jstl:out value="${socialIdentity.socialNetwork}" />
		</p>

		<p>
			<spring:message code="url" />
			<a href="${socialIdentity.url }" target="_blank"><jstl:out
					value="${socialIdentity.url}" /></a>
		</p>

		<p>
			<spring:message code="picture" />
			<a href="${socialIdentity.picture }" target="_blank"><jstl:out
					value="${socialIdentity.picture}" /></a>
		</p>

		<a
			href="socialIdentity/customer/edit.do?socialIdentityId=${socialIdentity.id}">
			<spring:message code="socialIdentity.edit" />
		</a>


	</jstl:if>



</form:form>





