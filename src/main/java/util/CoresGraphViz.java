package util;

import java.util.HashMap;
import java.util.Map;

public class CoresGraphViz {

	private static Map<Integer,String> cores;
	
	static {
		
		cores = new HashMap<>();
		cores.put(1, "red");
		cores.put(2,"orangered");
		cores.put(3, "orange");
		cores.put(3, "gold");
		cores.put(4, "yellowgreen");
		cores.put(5, "greenyellow");
		cores.put(6, "green1");
		cores.put(7, "deepskyblue");
		cores.put(8, "lightskyblue1");
		
	}
	
	public static String codigoCor(Integer codigo) {
		
		if(cores.containsKey(codigo)) {
			return cores.get(codigo);			
		}
		
		return cores.get(1);
		
	}
	
}
