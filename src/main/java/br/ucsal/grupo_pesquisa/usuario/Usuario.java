package br.ucsal.grupo_pesquisa.usuario;

public class Usuario {
	
	private String login;
	private String senha;
	
	
	public Usuario(String pLogin, String pSenha) {
		this.login = pLogin;
		this.senha = pSenha;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

}
