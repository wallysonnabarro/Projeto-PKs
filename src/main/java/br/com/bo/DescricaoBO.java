package br.com.bo;

import br.sasclient.entity.DescricaoEnty;
import br.sasclient.entity.Descricoes;
import br.sasclient.service.ServiceClient;

public class DescricaoBO {

	public void envioEmThreadDescricoes(Descricoes descricoes, int index) {
		new Thread() {
			public void run() {
				for(DescricaoEnty des: descricoes) {
					des.setCodigo_ocorrencia_ativa(index);
					new ServiceClient().RegistrarDescricao(des);
				}				
			};
		}.start();
	}
}
