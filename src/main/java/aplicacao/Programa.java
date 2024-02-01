package aplicacao;

import java.util.List;

public class Programa {

	public static void main(String[] args) {

		LeitorPDF leitor = new LeitorPDF();

		String texto = leitor.lerArquivo();

		LeitorTexto leitorTexto = new LeitorTexto();

		List<Sessao> sessaoList = leitorTexto.lerTexto(texto, 0, null);

		Padronizador padronizador = new Padronizador();

		sessaoList = padronizador.ajustaSessao(sessaoList);

		Categorizador categorizador = new Categorizador();

		List<PreNodo> preNodoList = categorizador.categorizarSessao(sessaoList);

		ImpressoraPreNodo impressoraPreNodo = new ImpressoraPreNodo();
		
		impressoraPreNodo.imprimirPreNodos(preNodoList);

	}

	

}
