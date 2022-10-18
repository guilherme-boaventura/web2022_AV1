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
 * Servlet implementation class ExemploServlet
 */
@WebServlet("/cadastroGrupoServlet")
public class CadastroGrupoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroGrupoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lNome = request.getParameter("nome");
		String lLider = request.getParameter("lider");
		try {
			GrupoPesquisaBS.getInstancia().criarGrupo(lNome, lLider);
			response.sendRedirect("./grupos.jsp");
		} catch (NegocioException e) {
			response.getWriter().write(failCadastroHtml(e.getMessage()));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private String failCadastroHtml(String pMensagem) {
		StringBuffer tabelaHtml = new StringBuffer("<!DOCTYPE html>");
		
		tabelaHtml.append("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Cadastro De Grupo</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"cadastroGrupoFailStyle.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"central\">\r\n"
				+ "		<form method=\"get\" action=\"cadastroGrupoServlet\">\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do grupo\" name=\"nome\"><br>\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do lider\" name=\"lider\"><br>\r\n"
				+ "			<input id=\"submit\" value=\"Criar\" type=\"submit\">\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "	<p>" + pMensagem + "</p>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		return tabelaHtml.toString();
	}

}
