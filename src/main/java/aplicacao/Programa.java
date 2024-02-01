package aplicacao;

import java.util.List;

import modelo.PreNodo;
import modelo.Sessao;
import repositorio.ImpressoraPreNodo;
import repositorio.LeitorPDF;
import servico.Categorizador;
import servico.LeitorTexto;
import servico.Padronizador;
import servico.ramificacao.Ramificador;

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

		Ramificador ramificador = new Ramificador();
		
		preNodoList = ramificador.analisarPreNodos(preNodoList);
		
		ImpressoraPreNodo impressoraPreNodo = new ImpressoraPreNodo();
		
		impressoraPreNodo.imprimirPreNodos(preNodoList);

	}

	

}
