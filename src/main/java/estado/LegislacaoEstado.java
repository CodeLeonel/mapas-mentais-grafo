package estado;

import java.util.ArrayList;
import java.util.List;

import modelo.Legislacao;

public class LegislacaoEstado {

	private static List<Legislacao> legislacoes = new ArrayList<>();
	
	public static List<Legislacao> getLegilacoes() {
		return legislacoes;
	}
	
	public static void inserir(String codigo, String descricao) {
		
		legislacoes.add(new Legislacao(codigo, descricao));
		
	}
	
}
