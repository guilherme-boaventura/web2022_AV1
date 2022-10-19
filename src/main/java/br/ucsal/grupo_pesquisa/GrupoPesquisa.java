package br.ucsal.grupo_pesquisa;

import java.util.ArrayList;
import java.util.List;

public class GrupoPesquisa {
	
	private String nome;
	private String lider;
	private List<String> membros = new ArrayList<String>();
	
	public GrupoPesquisa() {
	}
	
	public GrupoPesquisa(String pNome, String pLider) {
		this.nome = pNome;
		this.lider = pLider;
	}
	
	public String getLider() {
		return this.lider;
	}
	
	public void setLider(String lider) {
		this.lider = lider;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public List<String> getMembros() {
		return membros;
	}
}
