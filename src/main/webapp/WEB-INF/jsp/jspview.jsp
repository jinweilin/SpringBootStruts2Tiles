<%@ taglib prefix="s" uri="/struts-tags"%>
<%@	taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content='<tiles:getAsString name="description" ignore="true"/>'>
<meta name="keywords" content='<tiles:getAsString name="keyword" ignore="true"/>'>
<title>JSPVIEW</title>
</head>
<body>
	<h1>User Information</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Gender</th>
		</tr>
			<tr >
				<td align="center"><s:property value="user.id" /></td>
				<td><s:property value="user.firstName" /></td>
				<td><s:property value="user.lastName" /></td>
				<td align="center"><s:property value="user.age" /></td>
				<td><s:if test="user.gender.equals(\"M\")">Male</s:if>
					<s:else>Female</s:else></td>
			</tr>
	</table>
</body>
</html>