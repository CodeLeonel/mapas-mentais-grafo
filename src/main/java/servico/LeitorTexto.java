package servico;

import java.util.ArrayList;
import java.util.List;

import modelo.Sessao;

public class LeitorTexto {

	public List<Sessao> lerTexto(String texto, Integer indice, List<Sessao> sessaoList) {

		String[] linhas = texto.split("\n");

		if (sessaoList == null) {
			sessaoList = new ArrayList<>();
		}

		Boolean outra = false;
		Integer indiceSessao = 0;

		for (int i = indice; i < linhas.length; i++) {

			if (linhas[i].contains("CONHECIMENTOS GERAIS") 
					|| linhas[i].contains("EIXO TEMÁTICO")
					|| linhas[i].contains("LÍNGUA PORTUGUESA")
					|| linhas[i].contains("NOÇÕES DE DIREITO")
					|| linhas[i].contains("MATEMÁTICA")
					|| linhas[i].contains("REALIDADE BRASILEIRA")) {

				Sessao sessao = new Sessao(linhas[i].trim());
				StringBuilder stringBuilder = new StringBuilder();

				indiceSessao = i + 1;

				while (!outra && indiceSessao < linhas.length) {

					if (linhas[indiceSessao].contains("EIXO TEMÁTICO") 
							|| linhas[indiceSessao].contains("NOÇÕES DE DIREITO")
							|| linhas[indiceSessao].contains("MATEMÁTICA")
							|| linhas[indiceSessao].contains("REALIDADE BRASILEIRA")) {
						outra = true;
						sessao.setTexto(stringBuilder.toString());
						sessaoList.add(sessao);
						return lerTexto(texto, indiceSessao, sessaoList);
					}
					
					if(linhas[indiceSessao].contains("ANEXO V")) {
						outra = true;
						sessao.setTexto(stringBuilder.toString());
						sessaoList.add(sessao);
						return sessaoList;
					}

					stringBuilder.append(linhas[indiceSessao]);

					indiceSessao = indiceSessao + 1;
				}

			}

		}

		return sessaoList;
	}

}
