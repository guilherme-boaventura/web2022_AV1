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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			UsuarioBS.getInstancia().login(lLogin, lSenha);
			response.sendRedirect("./grupos.jsp");
		} catch (NegocioException e) {
			response.getWriter().write(failLoginHtml(e.getMessage()));
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String failLoginHtml(String pMensagem) {
		StringBuffer lRetorno = new StringBuffer("<!DOCTYPE html>");
		
		lRetorno.append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Login</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"indexStyle.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"central\">\r\n"
				+ "		<div class=\"h2\">\r\n"
				+ "			<h2>LOGIN</h2>\r\n"
				+ "		</div>"
				+ "			<form method=\"get\" action=\"loginServlet\">\r\n"
				+ "				<input class=\"txt-input\" type=\"text\" placeholder=\"Insira o nome do usuario\" name=\"login\"><br>\r\n"
				+ "				<input class=\"txt-input\" type=\"password\" placeholder=\"Insira a senha\" name=\"senha\"><br>\r\n"
				+ "				<input class=\"entrar\" value=\"Entrar\" type=\"submit\">\r\n"
				+ "			</form>\r\n"
				+ "			<form method=\"get\" action=\"cadastroUsuario.html\">\r\n"
				+ "				<input class=\"cadastrar\" value=\"Cadastrar\" type=\"submit\">\r\n"
				+ "			</form>\r\n"
				+ "	</div>\r\n"
				+ "	<p>" + pMensagem + "</p>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		return lRetorno.toString();
	}
}
