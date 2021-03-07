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
		
		
		BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_4BYTE_ABGR);
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				int a = 255; //alpha
		        int r; //red
		        int g; //green
		        int b; //blue
		        if (i == 0 || i == img.getWidth()-1 || j == 0 || j == img.getHeight()-1) {
		        	r=0;g=0;b=0;
		        }else {
		        	if ((float)i / ((float)img.getWidth()-1) <= (porcentaje / 100)) {
		        		r=255;g=165;b=0;
		        	}else {
		        		r=255;g=255;b=255;
		        	}
		        }
		        int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
				img.setRGB(i, j, p);
			}
		}
		try {
			File f = new File("imageProgressBar.png");
			ImageIO.write(img,"png",f);
		}catch(IOException ex) {
			System.out.println("No se ha podido generar la imagen corréctamente: " + ex.getMessage());
		}
		System.out.println("Imagen generada corréctamente");
	}

}
