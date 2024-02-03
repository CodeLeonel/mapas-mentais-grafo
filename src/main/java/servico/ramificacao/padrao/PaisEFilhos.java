package servico.ramificacao.padrao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.PreNodo;
import servico.ramificacao.padrao.interfaces.IPadraoRamificacao;

// author: Legião Urbana

public class PaisEFilhos implements IPadraoRamificacao {

	@Override
	public PreNodo encontrar(PreNodo preNodo) {
		
		Pattern pattern = Pattern.compile("(:\\s[A-Z]{5})");
		Matcher matcher = pattern.matcher(preNodo.getNome());
		
		if(preNodo.getNome().contains(":") && !matcher.find()) {
			
			String[] paiEFilhos = preNodo.getNome().split(":\s",2);
			
			if(paiEFilhos.length == 2) {
				preNodo.setNome(paiEFilhos[0]);
				
				String[] filhos = paiEFilhos[1].split("(,\\s|\\se\\s|;\\s)(?![^()]*\\))");
				
				for(String nomefilho : filhos) {
					
					String rotuloTeste = "Filho: "+nomefilho;
					
					preNodo.getFilhos().add(new PreNodo(preNodo,nomefilho,rotuloTeste));
					
				}
				
			}
			
		}
		
		return preNodo;
		
	}
	
	
}
