package br.com.bo;

import br.sasclient.entity.Relatorio;

public class RelatorioBO {

	public boolean validarCampos(Relatorio relatorio) {
		boolean retorno = true;

		if ("    -  -  ".equals(relatorio.getInicio())) {
			retorno = false;
		}
		if ("    -  -  ".equals(relatorio.getFim())) {
			retorno = false;
		}

		return retorno;
	}
	
	public boolean validarCampos2(Relatorio relatorio) {
		boolean retorno = true;
		
		if ("".equals(relatorio.getNome())) {
			retorno = false;
		}
		if ("    -  -  ".equals(relatorio.getInicio())) {
			retorno = false;
		}
		if ("    -  -  ".equals(relatorio.getFim())) {
			retorno = false;
		}
		
		return retorno;
	}
}
