package br.sasclient.util;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.swing.ImageIcon;

public class Java8Base64Image {
	/*
	 * public static void main(String[] args) { String imagePath =
	 * "C:\\eventogo\\eventogo.jpg"; System.out.
	 * println("=================Encoder Image to Base 64!=================");
	 * String base64ImageString = encoder(imagePath);
	 * System.out.println("Base64ImageString = " + base64ImageString);
	 * 
	 * System.out.
	 * println("=================Decoder Base64ImageString to Image!================="
	 * ); String s = decoder(base64ImageString); System.out.println(s);
	 * 
	 * System.out.println("DONE!");
	 * 
	 * }
	 */
	/**
	 * Codifica para String
	 * 
	 * @param imagePath
	 * @return
	 */
	public String encoder(File file) {
		String base64Image = "";
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}

	/**
	 * decodifica de string e salva em uma pasta
	 * 
	 * @param base64Image
	 * @param pathFile
	 * @return
	 */
	public Image decoder(String base64Image, String nome) {
		criarMkDir();
		String imagePath = "/fotos/" + nome + ".jpg";
		File i = new File(imagePath);
		if (i.exists()) {
			i.delete();
		}
		ImageIcon icon = null;
		Image imageScaled = null;
		try (FileOutputStream imageOutFile = new FileOutputStream(i)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
			icon = new ImageIcon(i.getAbsolutePath());
			Image image = icon.getImage();
			imageScaled = image.getScaledInstance(220, 280, Image.SCALE_DEFAULT);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return imageScaled;
	}

	/**
	 * decodifica de string e salva em uma pasta
	 * 
	 * @param base64Image
	 * @param pathFile
	 * @return
	 */
	public Image decoder80(String base64Image, String nome) {
		criarMkDir();
		String imagePath = "/fotos/" + nome + ".jpg";
		File i = new File(imagePath);
		if (i.exists()) {
			i.delete();
		}
		ImageIcon icon = null;
		Image imageScaled = null;
		try (FileOutputStream imageOutFile = new FileOutputStream(i)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
			icon = new ImageIcon(i.getAbsolutePath());
			Image image = icon.getImage();
			imageScaled = image.getScaledInstance(75, 100, Image.SCALE_DEFAULT);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return imageScaled;
	}

	/**
	 * decodifica de string e salva em uma pasta
	 * 
	 * @param base64Image
	 * @param pathFile
	 * @return
	 */
	public File decoder80File(String base64Image, String nome) {
		criarMkDir();
		String imagePath = "/fotos/" + nome + ".jpg";
		File i = new File(imagePath);
		if (i.exists()) {
			i.delete();
		}
		ImageIcon icon = null;
		try (FileOutputStream imageOutFile = new FileOutputStream(i)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
			icon = new ImageIcon(i.getAbsolutePath());
			Image image = icon.getImage();
			image.getScaledInstance(75, 100, Image.SCALE_DEFAULT);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return i;
	}

	/**
	 * decodifica de string e salva em uma pasta
	 * 
	 * @param base64Image
	 * @param pathFile
	 * @return
	 */
	public Image decoder120Imagen(String base64Image, String nome) {
		criarMkDir();
		String imagePath = "/fotos/" + nome + ".jpg";
		File i = new File(imagePath);
		if (i.exists()) {
			i.delete();
		}
		ImageIcon icon = null;
		Image imageScaled = null;
		try (FileOutputStream imageOutFile = new FileOutputStream(i)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
			icon = new ImageIcon(i.getAbsolutePath());
			Image image = icon.getImage();
			imageScaled = image.getScaledInstance(220, 280, Image.SCALE_DEFAULT);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return imageScaled;
	}

	private void criarMkDir() {
		File myDir = new File("/fotos");
		if (!myDir.exists()) {
			myDir.mkdir();
		}
	}

	/*
	 * public static void main(String[] args) { criarMkDir(); }
	 */
}