package servico.ramificacao;

import java.util.List;

import modelo.PreNodo;

public class Ramificador {

	public List<PreNodo> analisarPreNodos(List<PreNodo> preNodoList) {

		for (PreNodo preNodo : preNodoList) {

			preNodo = identificarPreNodos(preNodo, preNodo);

		}

		return preNodoList;
	}

	private PreNodo identificarPreNodos(PreNodo paiDeTodos, PreNodo preNodo) {

		String valor = null;

		if (preNodo.getNome().contains(":")) {

			String[] valores = preNodo.getNome().split(":");

			if (valores.length == 2) {
				valor = "Pai [" + valores[0] + ":] Filhos [" + valores[1] + "]";
			} else {
				valor = " ~: [ " + preNodo.getNome() + " ] ";
			}

		} else {

			valor = " [ " + preNodo.getNome() + " ] ^\\:";

			if (preNodo.getNome().contains(";") || preNodo.getNome().contains(",")) {
				valor += " Irmãos? ";
			}

		}

		preNodo.setValorPreProcessado(valor);

		if (!preNodo.getFilhos().isEmpty()) {

			for (PreNodo filho : preNodo.getFilhos()) {

				identificarPreNodos(paiDeTodos, filho);

			}

		}

		return paiDeTodos;

	}

}
