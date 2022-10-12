package br.ucsal.grupo_pesquisa.exceptions;

public class NegocioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String pMensagem) {
		super(pMensagem);
	}
}
