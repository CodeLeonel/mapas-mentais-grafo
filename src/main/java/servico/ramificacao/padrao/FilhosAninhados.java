package servico.ramificacao.padrao;

import java.util.regex.Matcher;

import modelo.PreNodo;
import servico.ramificacao.padrao.interfaces.IPadraoRamificacao;
import util.RegEx;

public class FilhosAninhados implements IPadraoRamificacao {

	@Override
	public PreNodo encontrar(PreNodo preNodo) {

		if (temFilhosAninhados(preNodo)) {

			preNodo = separarPaisEFilhos(preNodo);

		}

		return preNodo;
	}

	private PreNodo separarPaisEFilhos(PreNodo preNodo) {

		String[] paiEFilhos = preNodo.getNome().split("\\(");

		String nomeDoPai = paiEFilhos[0];

		preNodo.setNome(nomeDoPai);

		String[] filhos = paiEFilhos[1].split("(\\se\\s)|(,)");

		for (String filho : filhos) {

			if (filho.contains(")")) {

				filho = filho.replace(")", "");
				filho = filho.replace(".", "");

			}

			String rotuloTeste = "Filho Aninhado: " + filho;

			preNodo.getFilhos().add(new PreNodo(preNodo, filho, rotuloTeste));

		}

		return preNodo;
	}

	private Boolean temFilhosAninhados(PreNodo preNodo) {

		Boolean tem = false;

		Matcher matcher = RegEx.padrao("\\(.*\\)", preNodo.getNome());

		if (matcher.find()) {

			String subString = preNodo.getNome().substring(matcher.start(), matcher.end());

			tem = subString.length() >= 42 && subString.contains(" e ");

		}

		return tem;

	}

}
