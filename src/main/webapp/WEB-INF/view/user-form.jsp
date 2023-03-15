<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save User Contact details</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Contact Directory</h2>
		</div>
		<div id="container">
			<h3>Save COntact</h3>
			<form:form action="saveUser" modelAttribute="user" method="POST">

			<!-- need to associate this data with user id -->
			
			
				<table>
					<tbody>
						<tr>

							<td><label>Name:</label></td>
							<td><form:input path="name" /></td>

							<td><label>Is fav:</label></td>
							<td><form:input path="is_fav" /></td>
							
							
							
							<td><label>Mobile</label></td>
							
								<td><form:input path="mobiles"  /></td>
						
							
																
						</tr>
						<tr>

						<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td> 

						</tr>


					</tbody>


				</table>

			</form:form>
			
		
			
			
			
			
			
			
			
			<div style="both:"></div>
			<p>
				<a href="${pageContext.request.contextPath}/user/list"> Back to
					Contact Directory </a>

			</p>

		</div>
	</div>
</body>
</html>