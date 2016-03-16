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
<%--
*<form:form action="item/list.do?search=${var}" >
*	<form:input path="${var}" />
*	<input type="submit" name="search"
*		value="<spring:message code="item.search" />" />&nbsp; 
*</form:form>
 --%>
<h1><spring:message	code="spam.add" /></h1>
    <form action="spamword/administrator/add.do" method="post">
      <input type="text" name="spamText" /><br/>
      <input type="reset"/>
      <input type="submit" name="add"/>
    </form>

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="spamwords" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	
	<!-- Attributes -->

	<spring:message code="spam.word" var="word" />
	<display:column sortable="true" title="${word}"> <jstl:out value="${row}"/> </display:column>
	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="spamword/administrator/delete.do?wordId=${row}">
				<spring:message	code="spam.delete" />
			</a>
		</display:column>
	</security:authorize>

	
</display:table>
