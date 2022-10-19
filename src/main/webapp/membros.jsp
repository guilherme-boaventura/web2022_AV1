<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.ucsal.grupo_pesquisa.GrupoPesquisaBS" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Membros</title>
<link rel="stylesheet" href="membros.css">
</head>
<body>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: #949494; text-align: center;">
			<th>Membros</th>
		</tr>
		<%
		for(String lMembro: GrupoPesquisaBS.getInstancia().obterPorNome(request.getParameter("grupo")).getMembros()) {
			out.write("<tr style=\" text-align: center;\">"
					+ "<td>" + lMembro + "</td>"
					+ "</tr>");
		}
		%>
	</table>
</body>
</html>