package servico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.IntervaloPadrao;
import modelo.PreNodo;
import modelo.Sessao;
import util.RegexStorage;

public class Categorizador {

	public List<PreNodo> categorizarSessao(List<Sessao> sessaoList) {

		List<PreNodo> preNodoList = new ArrayList<>();

		for (Sessao sessao : sessaoList) {

			PreNodo preNodo = new PreNodo(sessao.getTema(), sessao.getTexto());

			preNodo = identificarFilhos(preNodo);

			preNodoList.add(preNodo);

		}

		return preNodoList;
	}

	private PreNodo identificarFilhos(PreNodo preNodo) {

		Integer nivel = 1;

		return identificarFilhos(preNodo, preNodo, nivel);

	}

	private PreNodo identificarFilhos(PreNodo paiDeTodos, PreNodo preNodo, Integer nivel) {

		if (nivel <= 3) {

			Pattern pattern = Pattern.compile(RegexStorage.nivelNodoFilhos(nivel));
			Matcher matcher = pattern.matcher(preNodo.getValorPreProcessado());

			Queue<IntervaloPadrao> fila = new LinkedList<>();

			while (matcher.find()) {

				fila.add(new IntervaloPadrao(matcher.start(), matcher.end()));

			}
			
			
			IntervaloPadrao ipEsquerda = null;
			Boolean padroesEncotrados = false;
			
			if(!fila.isEmpty()) {
				padroesEncotrados = true;
				ipEsquerda = fila.poll();
			}
			

			while (!fila.isEmpty()) {

				IntervaloPadrao ipDireita = fila.poll();

				String novoValorPreProcessado = preNodo.getValorPreProcessado().substring(ipEsquerda.getInicio(),
						ipDireita.getInicio());
				PreNodo filho = new PreNodo(preNodo, nomeacao(novoValorPreProcessado), novoValorPreProcessado);
				preNodo.getFilhos().add(filho);
				identificarFilhos(paiDeTodos, filho, nivel + 1);

				ipEsquerda = ipDireita;

			}

			if (fila.isEmpty() && padroesEncotrados) {

				String novoValorPreProcessado = preNodo.getValorPreProcessado().substring(ipEsquerda.getInicio(),
						preNodo.getValorPreProcessado().length());
				PreNodo filho = new PreNodo(preNodo, nomeacao(novoValorPreProcessado), novoValorPreProcessado);
				preNodo.getFilhos().add(filho);
				identificarFilhos(paiDeTodos, filho, nivel + 1);
			}

		}

		return paiDeTodos;

	}

	private String nomeacao(String valor) {

		String nome = valor.split(RegexStorage.get("familiaSessao"))[1].trim();

		return nome;

	}

}
