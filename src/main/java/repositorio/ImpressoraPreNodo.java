package repositorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.PreNodo;

public class ImpressoraPreNodo {

	public void imprimirPreNodos(List<PreNodo> preNodoList) {
		
		try(BufferedWriter bf = new BufferedWriter(new FileWriter("./textos/preNodos.txt"))) {
			
			bf.write(rotularPreNodos(preNodoList, 1));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private String rotularPreNodos(List<PreNodo> preNodoList, int nivel) {

		StringBuilder stringBuilder = new StringBuilder();

		for (PreNodo preNodo : preNodoList) {

			stringBuilder.append(rotularNivel(nivel) + preNodo + "\n");
			if (!preNodo.getFilhos().isEmpty()) {
				stringBuilder.append(rotularPreNodos(preNodo.getFilhos(), nivel + 1));
			}
			
		}
		
		return stringBuilder.toString();

	}

	private String rotularNivel(int nivel) {

		String rotuloNivel = null;

		switch (nivel) {

		case 1:
			rotuloNivel = "@";
			break;
		case 2:
			rotuloNivel = "*";
			break;
		case 3:
			rotuloNivel = "+";
			break;
		case 4:
			rotuloNivel = "-";
			break;
		default:
			rotuloNivel = "/";
			break;

		}
		
		return rotuloNivel;

	}
	
}
