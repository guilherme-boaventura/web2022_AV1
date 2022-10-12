package br.ucsal.grupo_pesquisa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ucsal.grupo_pesquisa.exceptions.NegocioException;

public class GrupoPesquisaBS {


	private static GrupoPesquisaBS instancia;

	public void criarGrupo(String pNome, String pLider) throws NegocioException {
		GrupoPesquisa lGrupo = new GrupoPesquisa(pNome,pLider);
		GrupoPesquisaBS.getInstancia().persistir(lGrupo);
	}


	public void persistir(GrupoPesquisa pGrupo) throws NegocioException {
		validar(pGrupo);
		GrupoPesquisaDAO.grupos.add(pGrupo);
	}

	public boolean excluir(GrupoPesquisa pGrupo) {
		if(GrupoPesquisaDAO.grupos.contains(pGrupo)) {
			GrupoPesquisaDAO.grupos.remove(pGrupo);
			return true;
		}else {
			return false;
		}
	}

	public void alterar(GrupoPesquisa pGrupoAntigo, GrupoPesquisa pGrupoNovo) {
		for(int i = 0; i < GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).equals(pGrupoAntigo)) {
				Collections.replaceAll(GrupoPesquisaDAO.grupos, pGrupoAntigo, pGrupoNovo);
				break;
			}
		}
	}

	public void validar(GrupoPesquisa pGrupo) throws NegocioException {
		if(pGrupo.getLider().isEmpty() || pGrupo.getNome().isEmpty()){
			throw new NegocioException("Preencha todos os campos");
		}

		if(!obterPorNome(pGrupo.getNome()).isEmpty()) {
			throw new NegocioException("Ja existe um grupo com esse nome.");
		}
	}

	public List<GrupoPesquisa> obterPorNome(String pNome) {
		List<GrupoPesquisa> lRetorno = new ArrayList<GrupoPesquisa>();
		for (int i = 0; i < GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).getNome().equals(pNome)) {
				lRetorno.add(GrupoPesquisaDAO.grupos.get(i));
			}
		}
		return lRetorno;
	}

	public static GrupoPesquisaBS getInstancia() {
		if(instancia == null) {
			instancia = new GrupoPesquisaBS();
		}
		return instancia;
	}

}
