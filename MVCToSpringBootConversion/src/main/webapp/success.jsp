<%@page import="java.util.List"%>
<%@page import="com.exponent.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function deletefunct() {
		alert("delete functin called!!!")
		document.mypage.action = "del";
		document.mypage.submit();

	}
</script>
</head>
<body>
	<h1>Login Success!!!</h1>

	<form name="mypage">
		<%
			List<Student> listd = (List<Student>) request.getAttribute("getStd");
		%>
		<table border="2" style="color: Orange">
			<thead>
				<tr>
					<td>Select</td>
					<td>Student Id</td>
					<td>Student Name</td>
					<td>Student Address</td>
					<td>Student Edit</td>
					<td>Student Delete</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<%
						for (Student std : listd) {
					%>
					<td><input type="radio" name="sid" value="<%=std.getSid()%>"></td>
					<td><%=std.getSid()%></td>
					<td><%=std.getSname()%></td>
					<td><%=std.getSaddress()%></td>
					<td><button value="submit" onclick="editfunc()">Edit</button></td>
					<td><button value="submit" onclick="deletefunct()">Delete</button></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>