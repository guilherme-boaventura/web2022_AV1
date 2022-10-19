package br.ucsal.grupo_pesquisa;


import br.ucsal.grupo_pesquisa.exceptions.NegocioException;

public class GrupoPesquisaBS {

	private static GrupoPesquisaBS instancia;

	public void criarGrupo(String pNome, String pLider) throws NegocioException {
		GrupoPesquisa lGrupo = new GrupoPesquisa(pNome,pLider);
		persistir(lGrupo);
		adicionarMembro(lGrupo.getNome(), lGrupo.getLider());
	}

	public void validar(GrupoPesquisa pGrupo) throws NegocioException {
		if(pGrupo.getLider().isEmpty() || pGrupo.getNome().isEmpty()){
			throw new NegocioException("Preencha todos os campos");
		}

		if(obterPorNome(pGrupo.getNome()) != null) {
			throw new NegocioException("Ja existe um grupo com esse nome.");
		}
	}

	public GrupoPesquisa obterPorNome(String pNome) {
		for (int i = 0; i < GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).getNome().equals(pNome)) {
				return GrupoPesquisaDAO.grupos.get(i);
			}
		}
		return null;
	}

	public void adicionarMembro(String pGrupo, String lMembro) throws NegocioException {
		GrupoPesquisa lGp = obterPorNome(pGrupo);
		
		if(lGp==null) {
			throw new NegocioException("Grupo nao encontrado");
		}else {
			lGp.getMembros().add(lMembro);
		}
	}
	
	public static GrupoPesquisaBS getInstancia() {
		if(instancia == null) {
			instancia = new GrupoPesquisaBS();
		}
		return instancia;
	}

	private void persistir(GrupoPesquisa pGrupo) throws NegocioException {
		validar(pGrupo);
		GrupoPesquisaDAO.grupos.add(pGrupo);
	}

}
