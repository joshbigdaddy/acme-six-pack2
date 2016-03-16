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
<h1><spring:message	code="bulletin.search" /></h1>
    <form action="bulletin/search.do" method="post">
      Search: <input type="text" name="searchText" /><br/>
      <input type="reset"/>
      <input type="submit" name="search"/>
    </form>




<security:authorize access="hasRole('ADMIN')">
	<div>
		<a href="bulletin/administrator/create.do"> <spring:message
				code="bulletin.create" />
		</a>
	</div>
</security:authorize>


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="bulletins" requestURI="${requestURI}" id="row">
		
<!-- Attributes -->
	<spring:message code="bulletin.moment" var="publishedMoment2" />
	<display:column property="publishedMoment" title="${publishedMoment2}" sortable="true" />
	

	<spring:message code="bulletin.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" sortable="true" />
	
	<spring:message code="bulletin.description" var="titleHeader" />
	<display:column property="description" title="${titleHeader}" sortable="true" />
	
</display:table>
