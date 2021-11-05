package br.com.bo;

import br.sasclient.entity.Pessoa;

public class PessoaBO {

	public boolean validar(Pessoa pessoa) {
		boolean ret = true;
		if ("   .   .   -  ".equals(pessoa.getCpf())) {
			ret = false;
		}
		if ("  -  -    ".equals(pessoa.getData_inicio())) {
			ret = false;
		}
		if ("".equals(pessoa.getFuncao())) {
			ret = false;
		}
		if ("".equals(pessoa.getNome())) {
			ret = false;
		}
		if ("(  )     -    ".equals(pessoa.getTelefone())) {
			ret = false;
		}
		if ("".equals(pessoa.getFoto()) || pessoa.getFoto() == null) {
			ret = false;
		}
		return ret;
	}

}
