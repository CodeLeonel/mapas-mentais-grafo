package aplicacao;

public class Sessao {
	
	private String tema;
	
	private String texto;
	
	public Sessao(String tema) {
		this.tema = tema;
	}

	public String getTema() {
		return tema;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		
		return " ( " + tema + " ) " + "\n" + " [ " + texto + " ] ";
	}
	
}
