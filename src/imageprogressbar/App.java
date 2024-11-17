package imageprogressbar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class App {

	public static void main(String[] args) {
		//Comprobación de parámetros
		if (args.length != 3) {
			System.out.println("Uso: Ancho Alto Porcentaje");
			System.exit(0);
		}
		int ancho = 0; int alto = 0; float porcentaje = 0;
		try {
			ancho = Integer.parseInt(args[0]);
		}catch(NumberFormatException ex) {
			System.out.println("Debe indicar un valor entero para el ancho de la imagen");
			System.exit(0);
		}
		try {
			alto = Integer.parseInt(args[1]);
		}catch(NumberFormatException ex) {
			System.out.println("Debe indicar un valor entero para el alto de la imagen");
			System.exit(0);
		}
		try {
			porcentaje = Float.parseFloat(args[2]);
		}catch(NumberFormatException ex) {
			System.out.println("Debe indicar un valor decimal para el porcentaje de progreso");
			System.exit(0);
		}catch(NullPointerException ex) {
			System.out.println("Debe indicar un valor decimal para el porcentaje de progreso");
			System.exit(0);
		}
		
		ImageProgressBar bProgreso = new ImageProgressBar();
		bProgreso.setColors(ImageProgressBar.Color.BLANCO, ImageProgressBar.Color.NEGRO, ImageProgressBar.Color.NARANJA);
		bProgreso.setImage(ancho, alto, BufferedImage.TYPE_4BYTE_ABGR, porcentaje);
		if (bProgreso.getImageFile("imageProgressBarXXX.png")) {
			System.out.println("Imagen generada corréctamente.");
		}else {
			System.out.println("No se ha podido generar la imagen corréctamente.");
		}
	}

}
