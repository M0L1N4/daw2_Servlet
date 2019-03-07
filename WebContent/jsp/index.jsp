<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My super servlet</title>
</head>
<body>
<h1>Súper capçalera</h1>
<a href="html/signin.html">Sign in</a>

<form action="login" method="get">
		<table>
			<tr>
				<td>User</td>
				<td><input name="user" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input name="email" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
<br>
	<%--Comentarios: Esto es un comentario en JSP --%>
	
	<%--Esto es un scriptlet JSP --%>
	<% out.println(); %>
	<%out.print("Hola mundo desde JSP"); %>
		<br>
	<%--Esto es una expresión en JSP --%>
	<%="Esto es una expresión" %>
	<br>
	<%--Se declara una directiva para utilizar la clase Date <%@ page import="java.util.Date"  %> --%>
	<%--
	Date d = new Date();
	out.println("Fecha Actual: "+d);
	--%>
		<br>
	<%-- Declaraciones en JSP --%>
	<%! public static int contador=7; %>
	<%  out.println("Valor de la variable contador: "+contador);%>
	<br>
	<%--Navegador y Versión del Sistema Operativo --%>
	<% out.print(request.getHeader("USER-AGENT")); %>

</body>
</html>