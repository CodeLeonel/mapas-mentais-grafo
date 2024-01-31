package aplicacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		LeitorPDF leitor = new LeitorPDF();
		
		String texto = leitor.lerArquivo();
		
		LeitorTexto leitorTexto = new LeitorTexto();
		
		List<Sessao> sessaoList = leitorTexto.lerTexto(texto, 0, null);
		
		Padronizador padronizador = new Padronizador();
		
		sessaoList = padronizador.ajustaTexto(sessaoList);
		
		try(BufferedWriter bf = new BufferedWriter(new FileWriter("sessoes.txt"))) {
			
			for(Sessao sessao : sessaoList) {
				bf.write(sessao.toString());	
			}
			
		} catch(IOException e ) {
			e.printStackTrace();
		}

	}

}
