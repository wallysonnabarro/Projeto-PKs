package br.sasclient.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteTxt extends PlainDocument{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantidadeMax;
	
	public LimiteTxt(int maxLen){
		super();
		if(maxLen<=0)
			throw new IllegalArgumentException("Especifique a quantidade");
		quantidadeMax=maxLen;
	}
	
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
		if(str == null||getLength()==quantidadeMax)
			return;
		int totalquantia = (getLength()+str.length());
		if(totalquantia<=quantidadeMax){
			super.insertString(offset, str.toUpperCase().replace("[^A-Z]", ""), attr);
			return;
		}
		String nova = str.substring(0, getLength()-quantidadeMax);
		super.insertString(offset, nova, attr);
	}

}
