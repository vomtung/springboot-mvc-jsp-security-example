<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/greeting" var="userActionUrl" />
<p>Enter your name</p>
<form:form method="post" modelAttribute="greeting" action="${userActionUrl}">
	<form:input path="content" type="text" /> <!-- bind to user.name-->
	<input type="submit" value="Submit"/>
</form:form>