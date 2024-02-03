package servico.ramificacao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import modelo.PreNodo;
import servico.ramificacao.padrao.interfaces.IPadraoRamificacao;

public class Ramificador {

	private IPadraoRamificacao padraoRamificacao;
	
	public Ramificador(IPadraoRamificacao padraoRamificacao) {
		
		this.padraoRamificacao = padraoRamificacao;
	}
	
	public List<PreNodo> analisarPreNodos(List<PreNodo> preNodoList) {

		for (PreNodo preNodo : preNodoList) {

			preNodo = identificarPreNodos(preNodo, preNodo);

		}

		return preNodoList;
	}

	private PreNodo identificarPreNodos(PreNodo paiDeTodos, PreNodo preNodo) {

		preNodo = this.padraoRamificacao.encontrar(preNodo);

		if (!preNodo.getFilhos().isEmpty()) {
			
			List<PreNodo> filhos = new CopyOnWriteArrayList<>(preNodo.getFilhos());
			
			for (PreNodo filho : filhos) {

				identificarPreNodos(paiDeTodos, filho);

			}

		}

		return paiDeTodos;

	}

}
