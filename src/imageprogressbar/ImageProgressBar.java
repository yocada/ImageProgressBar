package imageprogressbar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProgressBar {
	
	enum Color{
		BLANCO,
		NEGRO,
		NARANJA;
		
		int a = 255; //alpha
		int r; //red
        int g; //green
        int b; //blue
		
		public int getPixel() {
			switch(this) {
			case NEGRO:
				r=0;g=0;b=0;
				break;
			case NARANJA:
				r=255;g=165;b=0;
				break;
			default:
				r=255;g=255;b=255; //BLANCO
				break;
			}
			return (a<<24) | (r<<16) | (g<<8) | b; //pixel
		}
	}

	private BufferedImage img;
	private Color colorFondo;
	private Color colorBorde;
	private Color colorProgreso;
	
	public ImageProgressBar() {
		img = null;
	}
	
	public void setColors(Color pFondo, Color pBorde, Color pProgreso) {
		colorFondo = pFondo;
		colorBorde = pBorde;
		colorProgreso = pProgreso;
	}
	
	public void setImage(int pAncho, int pAlto, int pTipo, float pPorcentaje) {
	 img = new BufferedImage(pAncho, pAlto, pTipo);
	 int p;
	 for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
		        if (i == 0 || i == img.getWidth()-1 || j == 0 || j == img.getHeight()-1) {
		        	p = colorBorde.getPixel();
		        }else {
		        	if ((float)i / ((float)img.getWidth()-1) <= (pPorcentaje / 100)) {
		        		p = colorProgreso.getPixel();
		        	}else {
		        		p = colorFondo.getPixel();
		        	}
		        }
				img.setRGB(i, j, p);
			}
		}
	}
	
	public boolean getImageFile(String pFile) {
		if (img == null) return false;
		try {
			File f = new File(pFile);
			ImageIO.write(img,getExtension(pFile),f);
			return true;
		}catch(IOException ex) {
			return false;
		}
	}
	
	private String getExtension(String pFile) {
		int posicionUltimoPunto = pFile.lastIndexOf(".");
		return posicionUltimoPunto > 0 ? pFile.substring(posicionUltimoPunto+1) : "";
	}
}
