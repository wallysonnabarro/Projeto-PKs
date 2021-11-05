package br.com.sasclient.avaliacoes;

public class MainCam {
	 public static void main(String[] args) {
	        TimedWebcam t = new TimedWebcam();
	        t.take(5, 1, "."); // Salva 5 imagens na pasta do projeto a cada 1 segundo.
	    }
}
