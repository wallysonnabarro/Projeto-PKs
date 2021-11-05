package br.com.bo;

import br.sasclient.entity.Reposicoes;

public class ReposicoesBO {

	public String validador(Reposicoes reposicoes) {
		String texto = "";
		if("".equals(reposicoes.getNome())) {
			texto = "Campo Nome é obrigatório!";
		}
		if("".equals(reposicoes.getLocal())) {
			if(!"".equals(texto)) {
				texto = "Campos Nome, Local é obrigatório!";
			} else {
				texto = "Campo Local é obrigatório!";
			}
		}
		if(reposicoes.getData() == null) {
			if("Campo Local é obrigatório!".equals(texto)) {
				texto = "Campos Local e data é obrigatório!\n";
			} else if("Campos Nome, Local é obrigatório!".equals(texto)) {
				texto = " Campos Nome, Local e data é obrigatório!\n";
			} else {
				texto = "Campo data é obrigatório!";
			}
		}
		return texto;
	}
}
