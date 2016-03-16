<%--
 * header.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" alt="Sample Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<li>
	<a href="gym/list.do"><spring:message code="master.page.gyms" /></a>
	</li>
	<li>
	<a href="userAccount/actor/create.do"><spring:message code="master.page.register" /></a>
	</li>
		<li>
	<a href="service/list.do"><spring:message code="master.page.service" /></a>
	</li>
		<security:authorize access="hasRole('ADMIN')">
		<li>
	<a href="comment/administrator/list.do"><spring:message code="master.page.comment" /></a>
	</li>
	<li>
	<a href="administrator/dashboard.do"><spring:message code="master.page.dashboard" /></a>
	</li>
		<li><a href="feePayment/administrator/list.do"><spring:message code="master.page.administrator.feePayment" /></a></li>
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="spamword/administrator/list.do"><spring:message code="master.page.administrator.spamword" /></a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
		<li>
	<a href="bookService/customer/list.do"><spring:message code="master.page.bookServices" /></a>
	</li>
	<li>
	<a href="socialIdentity/customer/view.do"><spring:message code="master.page.view" /></a>
	</li>
	<li>
	<a href="socialIdentity/customer/edit.do"><spring:message code="master.page.edit" /></a>
	</li>
		<li><a href="feePayment/customer/list.do"><spring:message code="master.page.administrator.feePayment" /></a></li>
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="creditcard/customer/create.do"><spring:message code="master.page.customer.creditcard" /></a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="actor/list.do"><spring:message code="master.page.profile.actor" /></a></li>
					<li><a href="folder/list.do"><spring:message code="master.page.profile.folder" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

