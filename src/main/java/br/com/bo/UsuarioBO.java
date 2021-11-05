package br.com.bo;

import br.sasclient.entity.Usuario;

public class UsuarioBO {

	public boolean valida(Usuario usuario) {
		boolean ret = true;

		if ("".equals(usuario.getNome())) {
			ret = false;
		}
		if ("".equals(usuario.getSenha())) {
			ret = false;
		}
		if ("".equals(usuario.getUsuario())) {
			ret = false;
		}
		if ("".equals(usuario.getToken())) {
			ret = false;
		}
		return ret;
	}

	public boolean validarLogar(Usuario usuario) {
		boolean ret = true;
		
		if("".equals(usuario.getUsuario())) {
			ret = false;
		}
		if("".equals(usuario.getSenha())) {
			ret = false;
		}
		return ret;
	}

}
