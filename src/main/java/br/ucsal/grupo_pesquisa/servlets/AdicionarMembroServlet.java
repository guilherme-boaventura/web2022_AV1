package br.ucsal.grupo_pesquisa.servlets;

import java.io.IOException;

import br.ucsal.grupo_pesquisa.GrupoPesquisaBS;
import br.ucsal.grupo_pesquisa.exceptions.NegocioException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AdicionarMembroServlet
 */
@WebServlet("/adicionarMembroServlet")
public class AdicionarMembroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarMembroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lGrupo = request.getParameter("grupo");
		String lMembro = request.getParameter("membro");

		try {
			GrupoPesquisaBS.getInstancia().adicionarMembro(lGrupo, lMembro);
			response.sendRedirect("./grupos.jsp");
		} catch (NegocioException e) {
			response.getWriter().write(failAdicaoHtml(e.getMessage()));
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String failAdicaoHtml(String pMensagem) {
		StringBuffer lRetorno = new StringBuffer("<!DOCTYPE html>");

		lRetorno.append("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Adicionar Membro</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"cadastroGrupoFailStyle.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"central\">\r\n"
				+ "		<div style=\"\r\n"
				+ "    text-align: center;\r\n"
				+ "    position: absolute;\r\n"
				+ "    top: -170%;\r\n"
				+ "    right: 50%;\r\n"
				+ "    transform: translateX(50%);\r\n"
				+ "    color: white;\r\n"
				+ "\">\r\n"
				+ "			<h2>ADICIONAR MEMBRO</h2>\r\n"
				+ "		</div>"
				+ "		<form method=\"get\" action=\"adicionarMembroServlet\">\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do grupo\" name=\"grupo\"><br>\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do membro\" name=\"membro\"><br>\r\n"
				+ "			<input id=\"submit\" value=\"Adicionar\" type=\"submit\">\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "	<p>" + pMensagem + "</p>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		return lRetorno.toString();
	}
}
