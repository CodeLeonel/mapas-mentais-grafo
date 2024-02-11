package servico.ramificacao.padrao;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import estado.PaiAusenteEstado;
import modelo.PreNodo;
import servico.ramificacao.padrao.interfaces.IPadraoRamificacao;
import util.RegEx;
import util.RegexStorage;

public class Irmaos implements IPadraoRamificacao {

	@Override
	public PreNodo encontrar(PreNodo preNodo) {

		if (temIrmao(preNodo)) {

			String codinomePadrao = null;

			if (comSeparador(preNodo)) {

				codinomePadrao = "irmaosA";

			}

			if (!comSeparador(preNodo)) {

				if (comPontos(preNodo)) {

					codinomePadrao = "irmaosB";

				} else {

					codinomePadrao = "irmaosC";
				}

			}

			preNodo = separarIrmaos(preNodo, codinomePadrao);

		}

		return preNodo;
	}

	private PreNodo separarIrmaos(PreNodo preNodo, String codinomePadrao) {

		if(preNodo.getPai() != null) {
			
			PaiAusenteEstado.maisUm();
			
			String rotuloPaiAusente = "Pai Ausente " + PaiAusenteEstado.quantidade();
			
			PreNodo paiAusente = new PreNodo(preNodo.getPai(),"+",rotuloPaiAusente);
			
			List<PreNodo> familia = preNodo.getPai().getFilhos();
			
			familia.remove(preNodo);
			familia.add(paiAusente);
			
			paiAusente.getFilhos().add(preNodo);
			
			preNodo = nomearIrmaos(paiAusente, preNodo, codinomePadrao);
		}
		
		
		return preNodo;
	}
	
	private PreNodo nomearIrmaos(PreNodo paiAusente, PreNodo primogenito, String codinomePadrao) {
	
		String[] nomes = primogenito.getNome().split(RegexStorage.get(codinomePadrao));
		
		primogenito.setNome(nomes[0].trim());
		
		for(int i = 1; i < nomes.length; i++) {
			
			paiAusente.getFilhos().add(new PreNodo(paiAusente,nomes[i].trim(),"Novo irmão: " + nomes[i]));
		}
		
		return primogenito;
		
	}

	private Boolean temIrmao(PreNodo preNodo) {

		return ((!preNodo.getNome().contains(":")) && (preNodo.getNome().length() >= 65))
				&& (comSeparador(preNodo) || comPontos(preNodo) || comConjuncao(preNodo));

	}

	private Boolean comSeparador(PreNodo preNodo) {

		Matcher matcher = RegEx.padrao(RegexStorage.get("irmaosA"), preNodo.getNome());

		return matcher.find();

	}

	private Boolean comPontos(PreNodo preNodo) {

		Matcher matcher = RegEx.padrao(RegexStorage.get("irmaosB"), preNodo.getNome());

		Stream<MatchResult> results = matcher.results();

		return results.count() > 1;

	}
	
	private Boolean comConjuncao(PreNodo preNodo) {

		Matcher matcher = RegEx.padrao(RegexStorage.get("irmaosC"), preNodo.getNome());

		return matcher.find();

	}

}
