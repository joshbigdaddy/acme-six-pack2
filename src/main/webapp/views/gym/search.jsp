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
<h1><spring:message	code="gym.search" /></h1>
    <form action="gym/search.do" method="post">
      Search: <input type="text" name="searchText" /><br/>
      <input type="reset"/>
      <input type="submit" name="search"/>
    </form>

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="gyms" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="gym/administrator/edit.do?gymId=${row.id}">
				<spring:message	code="gym.edit" />
			</a>
		</display:column>
		</security:authorize>
	
	<!-- Attributes -->

	<spring:message code="gym.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="true" />

	<spring:message code="gym.postalAddress" var="postalAddressHeader" />
	<display:column property="postalAddress" title="${postalAddressHeader}" sortable="true" />
	
	<spring:message code="gym.fee" var="feeHeader" />
	<display:column property="fee" title="${feeHeader}" sortable="true" />
	
	<spring:message code="gym.pictures" var="pictureHeader" />
	<display:column property="picture" title="${pictureHeader}" sortable="true" />
	
	
</display:table>
<div>
</div>

<security:authorize access="hasRole('ADMIN')">
	<div>
		<a href="item/administrator/create.do"> <spring:message
				code="item.create" />
		</a>
	</div>
</security:authorize>
