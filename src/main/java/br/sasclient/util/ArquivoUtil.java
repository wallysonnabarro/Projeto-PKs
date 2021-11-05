package br.sasclient.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import br.sasclient.entity.Usuario;
import br.sasclient.swing.msg.MensagensJD2;

public class ArquivoUtil {

	private static MensagensJD2 mensagensJD;

	public void gravar(Usuario usuario) {
		FileOutputStream arq = null;
		try {
			File file = new File("C:\\connect3\\arquivo.dat");

			if (file.exists()) {
				file.delete();
				file = new File("C:\\connect3\\arquivo.dat");
			}

			arq = new FileOutputStream(file);

			DataOutputStream gravarArq = new DataOutputStream(arq);

			gravarArq.writeUTF(usuario.getUsuario() + "\n");
			gravarArq.writeUTF(usuario.getToken());
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Usuario lerArquivo() {
		File file = new File("C:\\connect3\\arquivo.dat");
		try {
			if (file.exists()) {
				FileInputStream arq = new FileInputStream(file);

				@SuppressWarnings("resource")
				DataInputStream lerArquivo = new DataInputStream(arq);

				Usuario usuario = new Usuario();
				usuario.setUsuario(lerArquivo.readUTF());
				usuario.setToken(lerArquivo.readUTF());

				arq.close();

				return usuario;
			} else {
				mensagensJD = new MensagensJD2("Necessário Logar!", "Acesso Inválido");
				mensagensJD.setVisible(true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File gravarPdf(byte[] bytes) {
		FileOutputStream arq = null;
		File file = null;
		try {
			file = new File("C:\\connect3\\RelatorioPorData"+System.currentTimeMillis()+".pdf");
			arq = new FileOutputStream(file);
			arq.write(bytes);

			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	/*
	 * public static void main(String[] args) { Usuario usuario = new Usuario();
	 * usuario.setUsuario("wallyson"); usuario.setToken("asda89dasasd");
	 * 
	 * gravar(usuario); lerArquivo(); }
	 */

}
