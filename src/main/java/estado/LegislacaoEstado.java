package estado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Legislacao;

public class LegislacaoEstado {

	private static final Map<String,Legislacao> legislacoesMap;
	
	static {
		legislacoesMap = new HashMap<>();
	}
	
	private static List<Legislacao> legislacoes = new ArrayList<>();
	
	public static List<Legislacao> getLegilacoes() {
		return legislacoes;
	}
	
	public static void inserir(String codigo, String descricao) {
		
		Legislacao legislacao = new Legislacao(codigo, descricao);
		
		legislacoes.add(legislacao);
		legislacoesMap.put(codigo, legislacao);
		
	}
	
	public static Boolean confere(String codigo) {
		
		return legislacoesMap.containsKey(codigo);
		
	}
	
	
	
}
