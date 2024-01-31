package aplicacao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Padronizador {

	public List<Sessao> ajustaTexto(List<Sessao> sessaoList) {
		
		for(Sessao sessao : sessaoList) {
			
			String texto = sessao.getTexto();
			
			texto = texto.replaceAll("\\bCONHECIMENTOS ESPECÍFICOS\\b", "");
			
			texto = texto.replaceAll("\\d{2}\\s\\s", " ");
			
			texto = texto.replaceAll("\\s\\s", " ");
			
			texto = adicionaEspacos(texto);
			
			texto = texto.trim();
			
			texto = " " + texto;
			
			sessao.setTexto(texto);
			
		}
		
		return sessaoList;
		
	}
	
	private String adicionaEspacos(String texto) {
		
		Pattern pattern = Pattern.compile("[a-zA-Z]\\.\\d");
		Matcher matcher = pattern.matcher(texto);
		
		while(matcher.find()) {
			
			String padraoErrado = matcher.group();
			String letraEPonto = padraoErrado.substring(0,2);
			String numero = padraoErrado.substring(2);
			String padraoCerto =  letraEPonto + " " + numero;
			texto = texto.replace(padraoErrado, padraoCerto);
		}
		
		return texto;
		
	}
	
}
