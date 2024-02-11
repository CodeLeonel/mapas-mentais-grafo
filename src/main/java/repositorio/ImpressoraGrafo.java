package repositorio;

import java.util.List;

import application.JaGraph;
import modelo.Nodo;

public class ImpressoraGrafo {

	private StringBuilder graphBuilder = new StringBuilder();
	private String prefixoArquivo;

	public ImpressoraGrafo(String prefixoArquivo) {
		this.prefixoArquivo = prefixoArquivo;
	}

	public void imprimirGrafos(List<Nodo> nodoList) {

		int numeroGrafo = 0;

		int numeroSessao = 0;
		
		for (Nodo nodo : nodoList) {
			
			numeroSessao++;
			
			graphBuilder.append("\n").append("\n");
			
			nodo = primeirosNodos(nodo, nomearArquivo(numeroSessao,numeroGrafo));
			
			graphBuilder.setLength(0);
			
			for(Nodo grafo : nodo.getFilhos()) {
				
				graphBuilder.append("\n").append("\n");
				
				numeroGrafo++;
				
				graphBuilder.append(percorrerArvore(grafo));

				imprimir(nomearArquivo(numeroSessao,numeroGrafo));
				
				graphBuilder.setLength(0);
				
			}
			
			numeroGrafo = 0;
			
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

			graphBuilder.insert(1, "overlap=scale").append("\n");
			graphBuilder.insert(0, "digraph G {").append("\n");
			graphBuilder.append("}").append("\n");
			
			String comandosDot = graphBuilder.toString();
			
			String caminhoArquivo = caminhoArquivo(adendoArquivo);
			
			JaGraph.renderPDFile(comandosDot, "neato", caminhoArquivo);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	private Nodo primeirosNodos(Nodo nodo, String nomeArquivo) {
		
		graphBuilder.append("\n").append("\n");
		
		graphBuilder.append(nodo.toString()).append("\n");
		
		for(Nodo filho : nodo.getFilhos()) {
			
			graphBuilder.append(filho.toString()).append("\n");
			
		}
		
		graphBuilder.append(nodo.arestasFilhos(2)).append("\n");
		
		imprimir(nomeArquivo);
		
		return nodo;
		
	}
	
	private String nomearArquivo(int numeroSessao, int numeroGrafo) {
		
		return "sessao" + numeroSessao + "grafo" + numeroGrafo;
		
	}
	
	private String caminhoArquivo(String adendoArquivo) {
		
		return "grafos/" + prefixoArquivo + adendoArquivo;
		
	}

	

}
