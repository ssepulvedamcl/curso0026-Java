<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, cl.personaDao.dao.Persona"
%>
<!DOCTYPE html>
<% List<Persona> personas = (List<Persona>)session.getAttribute("personas"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de personas</title>
</head>
<body>
	<table>
		<tr>
			<td>
				Nombre
			</td>
			<td>
				Edad
			</td>
			<td>
				Email
			</td>
		</tr>
		<%for(Persona persona : personas) {%>
		<tr>
			<td>
				<%=persona.getNombre() %>
			</td>
			<td>
				<%=persona.getEdad() %>
			</td>
			<td>
				<%=persona.getEmail() %>
			</td>
			<td>
				<a href="process?comando=eliminar&id=<%=persona.getId() %>">X</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>