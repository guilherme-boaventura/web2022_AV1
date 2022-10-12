package br.ucsal.grupo_pesquisa;

public class GrupoPesquisa {
	
	
	private String nome;
	private String lider;
	private String[] docentes;
	private String[] dicentes;
	private String[] tecnicoAdministrativos;
	
	public String getLider() {
		return this.lider;
	}
	
	public void setLider(String lider) {
		this.lider = lider;
	}
	
	public String[] getDocentes() {
		return this.docentes;
	}
	
	public void setDocentes(String[] docentes) {
		this.docentes = docentes;
	}
	
	public String[] getDicentes() {
		return this.dicentes;
	}
	
	public void setDicentes(String[] dicentes) {
		this.dicentes = dicentes;
	}
	
	public String[] getTecnicoAdministrativos() {
		return this.tecnicoAdministrativos;
	}
	
	public void setTecnicoAdministrativos(String[] tecnicoAdministrativos) {
		this.tecnicoAdministrativos = tecnicoAdministrativos;
	}

	
	public String getNome() {
		return this.nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
