package br.ucsal.grupo_pesquisa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrupoPesquisaBS {

	public GrupoPesquisa persistir(GrupoPesquisa pGrupo) {
		GrupoPesquisaDAO.grupos.add(pGrupo);
		return GrupoPesquisaDAO.grupos.get(GrupoPesquisaDAO.grupos.size());
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
		for(int i = 0; i <= GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).equals(pGrupoAntigo)) {
				Collections.replaceAll(GrupoPesquisaDAO.grupos, pGrupoAntigo, pGrupoNovo);
				break;
			}
		}
	}
	
	public List<GrupoPesquisa> ObterPorLider(String pLider) {
		List<GrupoPesquisa> lRetorno = new ArrayList<GrupoPesquisa>();
		for (int i = 0; i < GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).getLider().equals(pLider)) {
				lRetorno.add(GrupoPesquisaDAO.grupos.get(i));
			}
		}
		return lRetorno;
	}
	
	public List<GrupoPesquisa> ObterPorNome(String pNome) {
		List<GrupoPesquisa> lRetorno = new ArrayList<GrupoPesquisa>();
		for (int i = 0; i < GrupoPesquisaDAO.grupos.size(); i++) {
			if(GrupoPesquisaDAO.grupos.get(i).getNome().equals(pNome)) {
				lRetorno.add(GrupoPesquisaDAO.grupos.get(i));
			}
		}
		return lRetorno;
	}

}
