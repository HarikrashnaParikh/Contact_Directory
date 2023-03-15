<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Contact Directory</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add User" class="add-button"
				onclick="window.location.href='showFormForAdd'; return false;" />

			<!--  add a search box -->
            <form:form action="search" method="GET">
                Search User: <input type="text" name="theSearchName"/>
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<!-- add out html table here -->

			<table>
				<tr>
					<th>id</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>is_fav</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">
				<c:forEach var="tempMobile" items="${tempUser.mobiles}">
					<!--  Construct an "update" link with user id (primary key)  -->
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}" />
						<c:param name="mobileNo" value="${tempMobile.phoneNo}" />

					</c:url>
					
					<!--  Construct an "Delete" link with user id (primary key)  -->
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id}" />

					</c:url>
					
					<tr>
						<td>${tempUser.id}</td>
						<td>${tempUser.name}</td>
						<td>${tempMobile.phoneNo}</td>
						<td>${tempUser.is_fav}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this User?'))) return false">Delete</a>
						</td>

					</tr>
					</c:forEach>
				</c:forEach>
			</table>

		</div>
	</div>





</body>
</html>