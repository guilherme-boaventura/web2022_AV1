<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.ucsal.grupo_pesquisa.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-\">
		<title>Tabela De Grupos</title>
		<link rel="stylesheet" href="gruposStyle.css">
	</head>
	<body>
	<div class="principal">
		<div class="tabela">
		<table style="width:100%" border="1" align="center">
			<tr style="background-color: #949494;">
			<th>Grupo</th><th>Lider</th>
		</tr>
		<%
		for(GrupoPesquisa lGrupo: GrupoPesquisaDAO.grupos) {
			out.write("<tr>"
					+ "<td>" + lGrupo.getNome() + "</td>"
					+ "<td>" + lGrupo.getLider() + "</td>"
					+ "</tr>");
		}
		%>
		</table>
		</div>
		
		<ul>
		<li>
			<div class="botao">
				<a href="cadastroGrupo.html">Cadastrar Grupo</a>
			</div>
		</li>
		<li>
			<div class="botao">
				<a href="cadastroGrupo.html">Remover Grupo</a>
			</div>
		</li>
		<li>
			<div class="botao">
				<a href="cadastroGrupo.html">Alterar Grupo</a>
			</div>
		</li>
		</ul>
	</div>
	</body>
</html>