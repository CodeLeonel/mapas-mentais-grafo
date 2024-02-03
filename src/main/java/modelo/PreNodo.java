package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreNodo {

	private PreNodo pai;
	
	private String valorPreProcessado;
	
	private String nome;
	
	private List<PreNodo> filhos = new ArrayList<PreNodo>();

	public PreNodo() {
		
	}
	
	public PreNodo(PreNodo pai) {
		
		this.pai = pai;
		
	}
	
	public PreNodo(PreNodo pai, String valor) {
		
		this.pai = pai;
		this.valorPreProcessado = valor;
		
	}
	
	public PreNodo(String nome, String valor) {
		
		this.nome = nome;
		this.valorPreProcessado = valor;
		
	}
	
	public PreNodo(PreNodo pai, String nome, String valor) {
		
		this.pai = pai;
		this.nome = nome;
		this.valorPreProcessado = valor;
		
	}
	
	public PreNodo(String valor) {
	
		this.valorPreProcessado = valor;
	
	}
	
	@Override
	public String toString() {
	
		return " [ " + nome + " ] tamanho= " + nome.length();

	}
	
	public Boolean temFilhos() {

		return !filhos.isEmpty();

	}
	
	public PreNodo getPai() {
		return pai;
	}

	public void setPai(PreNodo pai) {
		this.pai = pai;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValorPreProcessado() {
		return valorPreProcessado;
	}

	public void setValorPreProcessado(String valorPreProcessado) {
		this.valorPreProcessado = valorPreProcessado;
	}

	public List<PreNodo> getFilhos() {
		return filhos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreNodo other = (PreNodo) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
