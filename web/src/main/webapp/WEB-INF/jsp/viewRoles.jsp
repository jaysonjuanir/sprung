<%@ page import="com.ervein.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Roles lol</title>
    </head>
    <body>
        
        <table border="solid">
            <thead>
                <tr>
					<th>ID</th>
                    <th>Roles</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="roleNames" value='${requestScope["roles"]}' />
                <c:forEach var="rolename" items="${roleNames}" >
                    <c:set var="tempRoleName" value='${rolename.getRole_type()}' />
                    <c:set var="roleId" value='${rolename.getId()}' />
                    <tr>
						<td><c:out value='${roleId}'/></td>
                    	<td><c:out value='${tempRoleName}'/></td>
                    </tr>
                </c:forEach>
            </tbody>
			<form action="ViewRoles" method="get"  >
				<button type= "submit" name="action" value="test">test this</button>
			</form>
        </table><br/>
	</body>
</html>
