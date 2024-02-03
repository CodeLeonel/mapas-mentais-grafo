package estado;

public class PaiAusenteEstado {

	private static Integer quantidadePaisAusentes = 0;
	
	public static void maisUm() {
		
		quantidadePaisAusentes++;
		
	}
	
	public static Integer quantidade() {
		
		return quantidadePaisAusentes;
		
	}
	
}
