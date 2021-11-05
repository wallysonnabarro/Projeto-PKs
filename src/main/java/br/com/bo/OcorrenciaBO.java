package br.com.bo;

import br.sasclient.entity.Ocorrencia;

public class OcorrenciaBO {

	public String validarRegistrar(Ocorrencia ocorrencia) {
		String retorno = "";
		if (ocorrencia.getNome().equals("")) {
			retorno = retorno + "Falta: Nome";
		}
		if (ocorrencia.getGrupo() == 0) {
			if (retorno == "") {
				retorno = retorno + "Falta: Grupo";
			} else {
				retorno = retorno + "\nFalta: Grupo";
			}
		}
		if (ocorrencia.getCor_fundo().equals("")) {
			if (retorno == "") {
				retorno = retorno + "Falta: Cor de Fundo";
			} else {
				retorno = retorno + "\nFalta: Cor de Fundo";
			}
		}
		if (ocorrencia.getCor_texto().equals("")) {
			if (retorno == "") {
				retorno = retorno + "Falta: Cor de Texo";
			} else {
				retorno = retorno + "\nFalta: Cor de Texo";
			}
		}
		if (ocorrencia.getPrimeiro().equals("  :  :  ")) {
			if (retorno == "") {
				retorno = retorno + "Falta: Temporizador 1";
			} else {
				retorno = retorno + "\nFalta: Temporizador 1";
			}
		}
		if (ocorrencia.getSegundo().equals("  :  :  ")) {
			if (retorno == "") {
				retorno = retorno + "Falta: Temporizador 2";
			} else {
				retorno = retorno + "\nFalta: Temporizador 2";
			}
		}
		return retorno;
	}
}
