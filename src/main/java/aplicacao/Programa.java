package aplicacao;

import java.util.List;

import modelo.Nodo;
import modelo.PreNodo;
import modelo.Sessao;
import repositorio.ImpressoraGrafo;
import repositorio.ImpressoraSessao;
import repositorio.LeitorPDF;
import servico.Categorizador;
import servico.LeitorTexto;
import servico.Padronizador;
import servico.geracao.Gerador;
import servico.ramificacao.Ramificador;
import servico.ramificacao.padrao.FilhosAninhados;
import servico.ramificacao.padrao.Irmaos;
import servico.ramificacao.padrao.Legislacoes;
import servico.ramificacao.padrao.PaisEFilhos;

public class Programa {

	public static void main(String[] args) {

		LeitorPDF leitor = new LeitorPDF();

		String texto = leitor.lerArquivo();

		LeitorTexto leitorTexto = new LeitorTexto();

		List<Sessao> sessaoList = leitorTexto.lerTexto(texto, 0, null);

		Padronizador padronizador = new Padronizador();

		sessaoList = padronizador.ajustaSessao(sessaoList);
		
		ImpressoraSessao impressoraSessao = new ImpressoraSessao();
		
		impressoraSessao.imprimirSessao(sessaoList);

		Categorizador categorizador = new Categorizador();

		List<PreNodo> preNodoList = categorizador.categorizarSessao(sessaoList);

		Ramificador ramificadorA = new Ramificador(new PaisEFilhos());
		
		preNodoList = ramificadorA.analisarPreNodos(preNodoList);
		
		Ramificador ramificadorB = new Ramificador(new Irmaos());
		
		preNodoList = ramificadorB.analisarPreNodos(preNodoList);
		
		Ramificador ramificadorC = new Ramificador(new Legislacoes());
		
		preNodoList = ramificadorC.analisarPreNodos(preNodoList);
		
		Ramificador ramificadorD = new Ramificador(new FilhosAninhados());
		
		preNodoList = ramificadorD.analisarPreNodos(preNodoList);
		
		//ImpressoraPreNodo impressoraPreNodo = new ImpressoraPreNodo();
		
		//impressoraPreNodo.imprimirPreNodos(preNodoList);
		
		//LegislacaoEstado.getLegilacoes().forEach(System.out::println);
		
		Gerador gerador = new Gerador();
		
		List<Nodo> nodoList = gerador.gerarNodos(preNodoList);
		
		ImpressoraGrafo impressoraGrafo = new ImpressoraGrafo("bloco2");
		
		impressoraGrafo.imprimirGrafos(nodoList);

	}

	

}
