package br.sasclient.util;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataUtil {
	public java.util.Date getDate(String data) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;

		try {
			date = formatter.parse(data);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public String getDataStringMesVigent(int i) {
		String ret = "";

		Calendar c = Calendar.getInstance();
		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH) + 1;

		if (i == 1) {
			ret = ano + "-" + mes + "-" + 00;
		} else {
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
				ret = ano + "-" + mes + "-" + 32;
			} else {
				ret = ano + "-" + mes + "-" + 31;
			}
		}

		return ret;
	}

	public String getDateString(Date data) {
		String r = "";
		if (data == null) {

		} else {
			Calendar date = Calendar.getInstance();
			date.setTime(data);

			int dia = date.get(Calendar.DAY_OF_MONTH) + 1;
			int mes = date.get(Calendar.MONTH) + 1;
			int ano = date.get(Calendar.YEAR);

			r = dia + "-" + mes + "-" + ano;
		}

		return r;
	}
	

	public String convertData(String s) {
		String[] sp = new String[3];
		sp = s.split("-");
		return sp[2] + "-" + sp[1] + "-" + sp[0];
	}

	public java.sql.Timestamp getTimesTempString(String t) {
		java.util.Date date = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			date = formatter.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());

		return time;
	}

	public java.sql.Timestamp getTimesTempStringBd() {

		java.sql.Timestamp dataTime = new java.sql.Timestamp(System.currentTimeMillis());

		return dataTime;
	}

	public java.sql.Time getTimeString(String t) {
		java.util.Date date = null;
		// t = t + ":00";

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		try {
			date = formatter.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Time time = new java.sql.Time(date.getTime());

		return time;
	}

	public String getString(Time t) {
		String string = null;

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", new Locale("pt", "BR"));

		string = formatter.format(t);
		return string;
	}
	
	public String getStringTempo(Time t) {
		String string = null;

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", new Locale("pt", "BR"));

		string = formatter.format(t);
		return string;
	}

	public java.util.Date pegarDataAtual() {
		java.util.Date data = new java.util.Date();
		return data;
	}
	

	public String getDateStringInvertido(java.util.Date data) {
		String r = "";
		if (data == null) {

		} else {
			Calendar date = Calendar.getInstance();
			date.setTime(data);

			int dia = date.get(Calendar.DAY_OF_MONTH) + 1;
			int mes = date.get(Calendar.MONTH) + 1;
			int ano = date.get(Calendar.YEAR);
			int hora = date.get(Calendar.HOUR_OF_DAY);
			int minuto = date.get(Calendar.MINUTE);
			int segundo = date.get(Calendar.SECOND);

			r = ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
		}

		return r;
	}
	
	public String getDateStringInvertidoParaBanco(java.util.Date data) {
		String r = "";
		if (data == null) {
			
		} else {
			Calendar date = Calendar.getInstance();
			date.setTime(data);
			
			int dia = date.get(Calendar.DAY_OF_MONTH);
			int mes = date.get(Calendar.MONTH) + 1;
			int ano = date.get(Calendar.YEAR);
			int hora = date.get(Calendar.HOUR_OF_DAY);
			int minuto = date.get(Calendar.MINUTE);
			int segundo = date.get(Calendar.SECOND);
			
			r = ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
		}
		
		return r;
	}

	public String getDateStringInvertidoParaBancoSemHora(java.util.Date data) {
		String r = "";
		if (data == null) {

		} else {
			Calendar date = Calendar.getInstance();
			date.setTime(data);

			int dia = date.get(Calendar.DAY_OF_MONTH);
			int mes = date.get(Calendar.MONTH) + 1;
			int ano = date.get(Calendar.YEAR);

			r = ano + "-" + mes + "-" + dia;
		}

		return r;
	}
	
	public String getHoraStringParaBancoSemData(java.util.Date data) {
		String r = "";
		if (data == null) {
			
		} else {
			Calendar date = Calendar.getInstance();
			date.setTime(data);

			int hora = date.get(Calendar.HOUR_OF_DAY);
			int minuto = date.get(Calendar.MINUTE);
			int segundo = date.get(Calendar.SECOND);

			r = hora + ":" + minuto + ":" + segundo;
		}
		
		return r;
	}
}
