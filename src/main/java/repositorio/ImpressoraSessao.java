package repositorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Sessao;

public class ImpressoraSessao {

	public void imprimirSessao(List<Sessao> sessaoList) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("./textos/sessoes.txt"))) {
			
			for(Sessao sessao : sessaoList) {
				bw.write(sessao.toString());
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
