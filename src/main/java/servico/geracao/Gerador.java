package servico.geracao;

import java.util.ArrayList;
import java.util.List;

import estado.LegislacaoEstado;
import modelo.Nodo;
import modelo.PreNodo;
import modelo.enums.Shape;
import util.CoresGraphViz;

public class Gerador {

	public List<Nodo> gerarNodos(List<PreNodo> preNodoList) {

		List<Nodo> nodoList = new ArrayList<>();

		for (PreNodo preNodo : preNodoList) {

			Nodo nodo = new Nodo(preNodo.hashCode(), preNodo.getNome());

			nodo = identificarFilhos(nodo, preNodo);
			
			nodoList.add(nodo);

		}

		return nodoList;

	}

	private Nodo identificarFilhos(Nodo nodo, PreNodo preNodo) {

		int nivel = 1;

		nodo = caracterizar(nodo, nivel);

		return identificarFilhos(nodo, nodo, preNodo, nivel + 1);

	}

	private Nodo identificarFilhos(Nodo paiDeTodos, Nodo nodo, PreNodo preNodo, int nivel) {

		if (preNodo.temFilhos()) {

			for (PreNodo filho : preNodo.getFilhos()) {

				Nodo novoNodo = new Nodo(nodo, filho.hashCode(), filho.getNome());

				novoNodo = caracterizar(novoNodo, nivel);

				nodo.getFilhos().add(novoNodo);

				identificarFilhos(paiDeTodos, novoNodo, filho, nivel + 1);
			}

		}

		return paiDeTodos;
	}

	private Nodo caracterizar(Nodo novoNodo, int nivel) {

		novoNodo.setStyle("filled");
		novoNodo.setShape(Shape.ellipse);
		novoNodo.setFillcolor(CoresGraphViz.codigoCor(nivel));
		novoNodo.setColor("black");

		if (novoNodo.getLabel().equals("+")) {

			novoNodo.setShape(Shape.folder);

		} else if (LegislacaoEstado.confere(novoNodo.getLabel())) {

			novoNodo.setShape(Shape.note);
			novoNodo.setFillcolor(CoresGraphViz.codigoCor(8));
			novoNodo.setColor(CoresGraphViz.codigoCor(7));

		}

		return novoNodo;
	}

}
