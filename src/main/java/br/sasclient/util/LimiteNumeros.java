package br.sasclient.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteNumeros extends PlainDocument{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7070006916129213393L;
    private int quantidadeMax;
	public LimiteNumeros(int max) {
		super();
		if(max<=0)
			throw new IllegalArgumentException("Especifique a quantidade");
		quantidadeMax=max;
	}
	
	
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
		if(str == null||getLength()==quantidadeMax)
			return;
		int totalquantia = (getLength()+str.length());
		if(totalquantia<=quantidadeMax){
			super.insertString(offset, str.replace("[^0-9]", ""), attr);
			return;
		}
		String nova = str.substring(0, getLength()-quantidadeMax);
		super.insertString(offset, nova, attr);
	}
}
