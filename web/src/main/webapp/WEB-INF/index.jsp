<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.person.dto.*"%>
<%@ page import="com.person.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>


<html>
	<head>
		<title>Main Page</title>
	</head>
	<body>
		<div>
			<div class="row">
				<div class="column column-6" align="center">
					<a href="${pageContext.request.contextPath}/PersonServlet">Add Person</a>
					<a href="${pageContext.request.contextPath}/ViewRoles">Roles</a>
					
					<form action="${pageContext.request.contextPath}/MainPage" method="get">
					  <input type="radio" name="sort" value="byId" checked="checked" > By ID<br>
					  <input type="radio" name="sort" value="byDateHired">By Date Hired<br>
					  <input type="radio" name="sort" value="byGWA">By GWA<br>
					  <input type="radio" name="sort" value="byLastName"> By Last Name<br/>
					  <input type="submit" value="sort" />
					</form>
					<table>
					
						<tr>
							<th>View</th>
							<th>ID</th>
							<th>Full Name</th>
							<th>Address</th>
							<th>Gender</th>
							<th>GWA</th>
							<th>Birthday</th>
							<th>Employed</th> <!-- nandito na yung employed, date hired, at roles-->
							<th>Contacts</th>
							<th>Delete</th>
						</tr>
						<c:set var="persons" value='${persons}' />
						<c:forEach var="person" items="${persons}" >
							<c:set var="personId" value='${person.getId()}' />
							<c:set var="personName" value='${person.getName()}' />
							<c:set var="personAddress" value='${person.getAddress()}' />
							<c:set var="personGWA" value='${person.getPerson_GWA()}' />
							
							<c:set var="personGender" value='${person.getGender()}' />
							<c:set var="personBirthday" value='${person.getBirthday()}' />
							<c:set var="dateHired" value='${person.getDate_hired()}' />
							<c:set var="roles" value='${person.getRoles()}' />
							<c:set var="contacts" value='${person.getPerson_contact()}' />
							<c:set var="isEmployed" value='${person.getEmployed()}' />
							<tr>
								<td>
									<form class="buttons" action="${pageContext.request.contextPath}/PersonServlet" method="get">
										<input type="hidden" name="id" value = "${personId}"> 
										<input type="submit" value="Edit" />
									</form>
								</td>
								<td><c:out value="${personId}"/></td>
								<td><c:out value="${personName}"/></td>
								<td><c:out value="${personAddress}"/></td>
								<td><c:out value="${personGender}"/></td>
								<td><c:out value="${personGWA}"/></td>
								<td><fmt:formatDate dateStyle="long" value="${personBirthday}"/></td>
								<td>
								<c:choose>
									<c:when test="${isEmployed}">
									<b>Date Hired: </b>
									<br/>
									<fmt:formatDate dateStyle="long" value="${dateHired}"/><br/>
									<b>Roles:</b>
									<br/>
									<c:forEach var = "role" items = '${roles}'>
										<c:out value = "${role}"/>
										<br/>
									</c:forEach>
									
									</c:when>
									<c:otherwise>
										NOT EMPLOYED!
									</c:otherwise>
								</c:choose>
								</td> <!-- nandito na yung employed, date hired, at roles-->
								<td>
									<c:forEach var = "contact" items = '${contacts}'>
										<b>
										<c:out value = "${contact.getContact_type()}"/>
										</b>
										=
										<c:out value = "${contact.getContact_value()}"/>
										
										<br/>
									</c:forEach>
									<c:if test="${contacts.isEmpty()}">
										NO CONTACTS!
									</c:if>
									<br/>
									
								</td>
								<td>
									<form class="buttons" action="${pageContext.request.contextPath}/PersonServlet" method="post">
										<input type="hidden" name="id" value = "${personId}"> 
										<input type="submit" value="Delete" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				
				
				</div>
			</div>
			
		</div>
		
		<style>
			table {
				border-collapse: collapse;
				width:90%;
			}

			table, th, td {
				border: 1px solid black;
			}
			td{
				text-align:center;
			}
			.buttons{
				align-items: center;
				
			}
		</style>
	</body>
</html>