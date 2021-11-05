package br.sasclient.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


public class CriptoUtil {
	
	public String criptoStringMd5(String valor) {
		String texto = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			md5.reset();
			md5.update(valor.getBytes());
			
			byte[] digest = md5.digest();
			BigInteger bigInteger = new BigInteger(1, digest);
			texto = bigInteger.toString();
			
			while (texto.length() < 32) {
				texto = "0" + texto;
				
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return texto;
	}
	

	public String criptoStringHexMd5(String valor) {
		String texto = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			md5.reset();
			md5.update(valor.getBytes());
			
			byte[] digest = md5.digest();
			texto = new String(Hex.encodeHex(digest));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return texto;
	}	
	
	/*public static void main(String[] args) {
		System.out.println(criptoStringHexMd5("3"));//senha adm
	}*/
}