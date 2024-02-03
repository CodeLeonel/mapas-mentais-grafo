package util;

import java.util.HashMap;
import java.util.Map;

public class RegexStorage {

	private static final Map<String,String> expressoesRegulares;
	
	static {
		
		expressoesRegulares = new HashMap<>();
		expressoesRegulares.put("nodosFilhos", "\\s\\d\\s|\\s1[0-5]\\s|\\s1[0-5]\\.\\s|\\s\\d\\.\\s");
		expressoesRegulares.put("nodosNetos", "\\s\\d\\.\\d\\s|\\s1[0-5]\\.\\d\\s|\\s\\d\\.1[0-5]\\s|\\s\\d\\.\\d\\.\\s");
		expressoesRegulares.put("nodosBisnetos", "\\s\\d\\.\\d\\.\\d\\s");
		expressoesRegulares.put("familiaSessao",expressoesRegulares.get("nodosFilhos") + "|" +
										   		expressoesRegulares.get("nodosNetos") + "|" + 
										   		expressoesRegulares.get("nodosBisnetos"));
		expressoesRegulares.put("irmaosA", "[,;](?![^()]*\\))");
		expressoesRegulares.put("irmaosB", "\\.(?!(?:\\d))(?![^()]*\\))");
		expressoesRegulares.put("irmaosC", "\\se\\s(?![^()]*\\))");
		expressoesRegulares.put("legislacao1","\\(Decreto.*\\)");
		expressoesRegulares.put("legislacao2","Decreto.*alterações");
		expressoesRegulares.put("legislacao3","Decreto.*\\/\\d+\\.");
		expressoesRegulares.put("legislacao4","\\(Lei.*\\)");
		expressoesRegulares.put("legislacao5","Lei\\sn\\º\\s\\d+\\.\\d+\\/\\d+\\se\\salterações.");
		expressoesRegulares.put("legislacao6","Lei\\sn\\º\\s\\d+\\.\\d+\\/\\d+");
		expressoesRegulares.put("legislacao7","Lei.*\\)");
		expressoesRegulares.put("legislacao8","\\(artigo.*\\)");
		expressoesRegulares.put("legislacao9","artigo.*1988");
		expressoesRegulares.put("legislacaoA","("+ expressoesRegulares.get("legislacao1") + "|" + 
				expressoesRegulares.get("legislacao2") + "|" + 
				expressoesRegulares.get("legislacao3") + ")");
		expressoesRegulares.put("legislacaoB","("+ expressoesRegulares.get("legislacao4") + "|" + 
				expressoesRegulares.get("legislacao5") + "|" + 
				expressoesRegulares.get("legislacao6") + "|" + 
				expressoesRegulares.get("legislacao7") + ")");
		expressoesRegulares.put("legislacaoC","("+ expressoesRegulares.get("legislacao8") + "|" + 
				expressoesRegulares.get("legislacao9") + ")");
		expressoesRegulares.put("legislacao", "("+ expressoesRegulares.get("legislacao1") + "|" + 
												expressoesRegulares.get("legislacao2") + "|" + 
												expressoesRegulares.get("legislacao3") + "|" + 
												expressoesRegulares.get("legislacao4") + "|" + 
												expressoesRegulares.get("legislacao5") + "|" + 
												expressoesRegulares.get("legislacao6") + "|" + 
												expressoesRegulares.get("legislacao7") + "|" + 
												expressoesRegulares.get("legislacao8") + "|" + 
												expressoesRegulares.get("legislacao9") + ")");
	}
	
	public static String nivelNodoFilhos(Integer nivel) {
		
		nivel--;
		
		switch(nivel) {
		
			case 0: 
				return expressoesRegulares.get("nodosFilhos");

			case 1:
				return expressoesRegulares.get("nodosNetos");
				
			case 2:
				return expressoesRegulares.get("nodosBisnetos");
				
			default:
				break;
		
		}
		
		return "-";
	}
	
	public static String get(String chave) {
		
		return expressoesRegulares.get(chave);
		
	}
	
}
