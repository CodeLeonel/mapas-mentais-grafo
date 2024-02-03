package repositorio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import modelo.Nodo;

public class ImpressoraGrafo {

	private StringBuilder graphBuilder = new StringBuilder();
	private String prefixoArquivo;

	public ImpressoraGrafo(String prefixoArquivo) {
		this.prefixoArquivo = prefixoArquivo;
	}

	public void imprimirGrafos(List<Nodo> nodoList) {
		
		graphBuilder.append("\n").append("\n");
		
		int numeroGrafo = 0;
		
		for (Nodo nodo : nodoList) {

			numeroGrafo++;
			
			graphBuilder.append("\n").append("\n");
			
			graphBuilder.append(percorrerArvore(nodo));
			
			imprimir("grafo" + numeroGrafo);
			
		}

		

	}

	private String percorrerArvore(Nodo nodo) {

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append(definicaoNodos(nodo));

		strBuilder.append("\n").append("\n");

		strBuilder.append(arestasFilhos(nodo));

		return strBuilder.toString();
	}

	private String definicaoNodos(Nodo nodo) {

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("\n").append(nodo.toString());

		if (nodo.temFilhos()) {

			for (Nodo filho : nodo.getFilhos()) {

				strBuilder.append(definicaoNodos(filho));

			}

		}

		return strBuilder.toString();

	}

	private String arestasFilhos(Nodo nodo) {

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("\n").append(nodo.arestasFilhos(2));

		if (nodo.temFilhos()) {

			for (Nodo filho : nodo.getFilhos()) {

				strBuilder.append(arestasFilhos(filho));

			}

		}

		return strBuilder.toString();

	}

	private void imprimir(String adendoArquivo) {
		try {

			if (prefixoArquivo == null || prefixoArquivo.isEmpty()) {
				prefixoArquivo = "grafo";
			}
			
			
			//graphBuilder.insert(3, "splines=true").append("\n");
			graphBuilder.insert(2, "overlap=scale").append("\n");
			graphBuilder.insert(1, "layout=neato").append("\n");
			graphBuilder.insert(0, "digraph G {").append("\n");

			graphBuilder.append("}").append("\n");
			escreverTextoParaArquivo("./textos/" + prefixoArquivo + adendoArquivo + ".gv", graphBuilder.toString());

			StringBuilder comando = new StringBuilder();
			comando.append("dot -Tpdf "). // output type
					append("./textos/" + prefixoArquivo + adendoArquivo).append(".gv "). // input dot file
					append("-o ").append("./grafos/" + prefixoArquivo + adendoArquivo).append(".pdf"); // output
																												// image

			executarCommando(comando.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void executarCommando(String command) throws Exception {
		System.out.println(command);
		Runtime.getRuntime().exec(command);
	}

	private void escreverTextoParaArquivo(String nomeArquivo, String texto) throws IOException {
		FileOutputStream saidaStream = new FileOutputStream(nomeArquivo);
		saidaStream.write(texto.getBytes());
		saidaStream.close();
	}

}
