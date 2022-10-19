package br.ucsal.grupo_pesquisa.usuario;

import br.ucsal.grupo_pesquisa.exceptions.NegocioException;

public class UsuarioBS {
	
	private static UsuarioBS instancia;

	public void cadastrar(String pLogin, String pSenha) throws NegocioException {
		Usuario lUser = new Usuario(pLogin, pSenha);
		validar(lUser);
		UsuarioDAO.usuarios.add(lUser);
	}

	private void validar(Usuario pUser) throws NegocioException {
		if(pUser.getLogin().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if(pUser.getSenha().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if(obterPorLogin(pUser.getLogin()) != null) {
			throw new NegocioException("Usuario ja cadastrado.");
		}
	}
	
	public void login(String pLogin, String pSenha) throws NegocioException{
		Usuario lUser = obterPorLogin(pLogin);
		validarLogin(lUser, pLogin, pSenha);
	}
	
	private boolean validarLogin(Usuario pUser, String pLogin, String pSenha) throws NegocioException {
		if(pLogin.isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if(pSenha.isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if(pUser == null) {
			throw new NegocioException("Usuario inexistente.");
		}
		
		if(pUser.getSenha().equals(pSenha)) {
			return true;
		}else {
			throw new NegocioException("Senha incorreta");
		}
	}
	
	public Usuario obterPorLogin(String pLogin) {
		for (int i = 0; i < UsuarioDAO.usuarios.size(); i++) {
			if(UsuarioDAO.usuarios.get(i).getLogin().equals(pLogin)) {
				return UsuarioDAO.usuarios.get(i);
			}
		}
		return null;
	}
	
	public static UsuarioBS getInstancia() {
		if(instancia == null) {
			instancia = new UsuarioBS();
		}
		return instancia;
	}
}
