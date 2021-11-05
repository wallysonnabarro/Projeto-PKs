package br.sasclient.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapUtil {
	public static void redimensionaImg(File file) {
		//BufferedImage imagem = ImageIO.read(RedimensionarImagem.class.getResourceAsStream("background.jpg"));
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        int new_w = 200, new_h = 200;
        BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = new_img.createGraphics();

        g.drawImage(imagem, 0, 0, new_w, new_h, null);
        try {
			ImageIO.write(new_img, "JPG", new File("c:/nweImg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		
	}
}
