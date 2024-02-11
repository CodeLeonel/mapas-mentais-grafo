package servico.ramificacao.padrao;

import java.util.regex.Matcher;

import estado.LegislacaoEstado;
import modelo.PreNodo;
import servico.ramificacao.padrao.interfaces.IPadraoRamificacao;
import util.RegEx;
import util.RegexStorage;

public class Legislacoes implements IPadraoRamificacao {

	public PreNodo encontrar(PreNodo preNodo) {
		
		if(ehLegislacao(preNodo)) {
			
			String codigoLegislacao = null;
			String descricaoLegislacao = null;
			
			Matcher matcher = RegEx.padrao(RegexStorage.get("legislacao"), preNodo.getNome());
			
			matcher.find();
			
			codigoLegislacao = preNodo.getNome().substring(matcher.start(), matcher.end());
			
			if(matcher.start() == 0) {
				
				Matcher parenteses = RegEx.padrao("\\s\\(", preNodo.getNome());
				
				if(parenteses.find()) {
					
					String sigla = codigoLegislacao.substring(parenteses.start());
					descricaoLegislacao = codigoLegislacao.substring(0,parenteses.start());
					
					LegislacaoEstado.inserir(sigla, descricaoLegislacao);
					
					preNodo.setNome(sigla);
					
				}
				
			} else {
				
				descricaoLegislacao = preNodo.getNome().substring(0,matcher.start()-1);
				LegislacaoEstado.inserir(codigoLegislacao, descricaoLegislacao);
				
				preNodo.setNome(codigoLegislacao);
			}
			
		}
		
		return preNodo;
		
	}
	
	
	
	private Boolean ehLegislacao(PreNodo preNodo) {
		
		Matcher matcher = RegEx.padrao(RegexStorage.get("legislacao"), preNodo.getNome());
		
		return matcher.find();
	}
	
}
