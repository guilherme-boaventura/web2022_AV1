package br.ucsal.grupo_pesquisa.servlets;

import java.io.IOException;

import br.ucsal.grupo_pesquisa.exceptions.NegocioException;
import br.ucsal.grupo_pesquisa.usuario.UsuarioBS;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroUsuarioServlet
 */
@WebServlet("/cadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lLogin = request.getParameter("login");
		String lSenha = request.getParameter("senha");
		
		try {
			UsuarioBS.getInstancia().cadastrar(lLogin, lSenha);
			response.sendRedirect("./index.html");
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
	
	public String failCadastroHtml(String pMensagem) {
		StringBuffer lRetorno = new StringBuffer("<!DOCTYPE html>");

		lRetorno.append("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Cadastro Usuario</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"cadastroGrupoFailStyle.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"central\">\r\n"
				+ "		<div style=\"\r\n"
				+ "    text-align: center;\r\n"
				+ "    position: absolute;\r\n"
				+ "    top: -220%;\r\n"
				+ "    right: 50%;\r\n"
				+ "    transform: translateX(50%);\r\n"
				+ "    color: white;\r\n"
				+ "\">\r\n"
				+ "			<h2>CADASTRO DE USUARIO</h2>\r\n"
				+ "		</div>\r\n"
				+ "		<form method=\"get\" action=\"cadastroUsuarioServlet\">\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do usuario\" name=\"login\"><br>\r\n"
				+ "			<input class=\"txt-input\" type=\"text\" placeholder=\"Insira a senha\" name=\"senha\"><br>\r\n"
				+ "			<input id=\"submit\" value=\"Cadastrar\" type=\"submit\">\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "	<p >" + pMensagem + "</p>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		return lRetorno.toString();
	}

}
