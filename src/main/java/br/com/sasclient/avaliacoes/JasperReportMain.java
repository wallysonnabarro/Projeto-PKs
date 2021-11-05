package br.com.sasclient.avaliacoes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import br.sasclient.entity.RelatorioEnty;
import br.sasclient.service.ServiceClient;
import br.sasclient.util.ArquivoUtil;

public class JasperReportMain {

	public static void main(String[] args) {
		escolha(1);
	}

	public static void escolha(int i) {
		File file = null;
		RelatorioEnty enty = new RelatorioEnty();
		switch (i) {
		case 0:
			enty.setData_final("2020-05-10");
			enty.setData_inicio("2020-05-08");
			enty.setNome("TESTE 1001 REPORT");

			//file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioPorData(enty));
			abrirPDF(file);
			break;
		case 1:
			enty.setNome("TESTE 1001 REPORT");
			file = new ArquivoUtil().gravarPdf(new ServiceClient().GerarRelatorioPorNome(enty));
			abrirPDF(file);
			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}
	}

	private static void abrirPDF(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
