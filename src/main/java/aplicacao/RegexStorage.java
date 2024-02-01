package aplicacao;

import java.util.HashMap;
import java.util.Map;

public class RegexStorage {

	private static final Map<String,String> expressoesRegulares;
	
	static {
		
		expressoesRegulares = new HashMap<>();
		expressoesRegulares.put("nodosFilhos", "\\s\\d\\s|\\s1[0-5]\\s|\\s1[0-5]\\.\\s|\\s\\d\\.\\s");
		expressoesRegulares.put("nodosNetos", "\\s\\d\\.\\d\\s|\\s1[0-5]\\.\\d\\s|\\s\\d\\.1[0-5]\\s");
		expressoesRegulares.put("nodosBisnetos", "\\s\\d\\.\\d\\.\\d\\s");
		expressoesRegulares.put("familia", expressoesRegulares.get("nodosFilhos") + "|" +
										   expressoesRegulares.get("nodosNetos") + "|" + 
										   expressoesRegulares.get("nodosBisnetos"));
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
