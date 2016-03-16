
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="gym/administrator/edit.do" modelAttribute="gym">
<jstl:if test="${gym.id != 0}">
	<form:hidden path="id" />
	<form:hidden path="version" />
</jstl:if>
	
<%--	
<jstl:if test="${gym.id == 0}">
		<input type="submit" name="save"
			value="<spring:message code="gym.create" />"
			onclick="return confirm('<spring:message code="gym.confirm.create" />')" />&nbsp;
	</jstl:if>
--%>	
	<form:label path="name">
		<spring:message code="gym.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />
	<form:label path="description">
		<spring:message code="gym.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
	<form:label path="postalAddress">
		<spring:message code="gym.postalAddress" />:
	</form:label>
	<form:input path="postalAddress" />
	<form:errors cssClass="error" path="postalAddress" />
	<br />
	<form:label path="telephone">
		<spring:message code="gym.telephone" />:
	</form:label>
	<form:input path="telephone" />
	<form:errors cssClass="error" path="telephone" />
	<br />
	<form:label path="fee">
	<spring:message code="gym.fee" />:
	</form:label>
	<form:input path="fee" />
	<form:errors cssClass="error" path="fee" />
	<br />
	<form:label path="picture">
		<spring:message code="gym.picture" />:
	</form:label>
	<form:input path="picture" />
	<form:errors cssClass="error" path="picture" />
	<br />
	<form:hidden path="totalCustomers" />
	
	<form:hidden path="service" />
	
<jstl:if test="${gym.id != 0}">
	<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="" requestURI="${requestURI}" id="comments">
	<spring:message code="gym.comment.userName" var="nameHeader" />
	<display:column property="userName" title="${nameHeader}" sortable="true" />
	<spring:message code="gym.comment.moment" var="nameHeader" />
	<display:column property="moment" title="${nameHeader}" sortable="true" />
	<spring:message code="gym.comment.text" var="nameHeader" />
	<display:column property="text" title="${nameHeader}" sortable="true" />
	<spring:message code="gym.comment.rating" var="nameHeader" />
	<display:column property="rating" title="${nameHeader}" sortable="true" />
	</display:table>

		
</jstl:if>
<br/>

<input type="submit" name="save"
		value="<spring:message code="gym.save" />" />&nbsp; 
		<input type="submit" name="delete"
			value="<spring:message code="gym.delete" />"
			onclick="return confirm('<spring:message code="gym.confirm.delete" />')" />&nbsp;
		
<a href="gym/administrator/list.do">
	<input type="button" name="cancel"
		value="<spring:message code="gym.cancel" />"
		onclick="javascript: relativeRedir('gym/administrator/list.do');" /></a>
		
	<br />


</form:form>
	
	