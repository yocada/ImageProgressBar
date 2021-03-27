package com.dcm.imageprogressbar.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcm.imageprogressbar.ImageProgressBar;

@RestController
@RequestMapping("imageprogressbar")
public class ImageProgressBarREST {
	
	@GetMapping(value = "test")
	public String test() {
		return "Test OK!";
	}

	@GetMapping(value = "download", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
		//TEST
		//Comprobación de parámetros
//		if (args.length != 3) {
//			System.out.println("Uso: Ancho Alto Porcentaje");
//			System.exit(0);
//		}
//		int ancho = 0; int alto = 0; float porcentaje = 0;
//		try {
//			ancho = Integer.parseInt(args[0]);
//		}catch(NumberFormatException ex) {
//			System.out.println("Debe indicar un valor entero para el ancho de la imagen");
//			System.exit(0);
//		}
//		try {
//			alto = Integer.parseInt(args[1]);
//		}catch(NumberFormatException ex) {
//			System.out.println("Debe indicar un valor entero para el alto de la imagen");
//			System.exit(0);
//		}
//		try {
//			porcentaje = Float.parseFloat(args[2]);
//		}catch(NumberFormatException ex) {
//			System.out.println("Debe indicar un valor decimal para el porcentaje de progreso");
//			System.exit(0);
//		}catch(NullPointerException ex) {
//			System.out.println("Debe indicar un valor decimal para el porcentaje de progreso");
//			System.exit(0);
//		}
		
		ImageProgressBar bProgreso = new ImageProgressBar();
		bProgreso.setColors(ImageProgressBar.Color.BLANCO, ImageProgressBar.Color.NEGRO, ImageProgressBar.Color.NARANJA);
		bProgreso.setImage(50, 10, BufferedImage.TYPE_4BYTE_ABGR, (float)37.5);
//		if (bProgreso.getImageFile("imageProgressBarXXX.png")) {
//			System.out.println("Imagen generada corréctamente.");
//		}else {
//			System.out.println("No se ha podido generar la imagen corréctamente.");
//		}
		var buffImage = bProgreso.getImg();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(buffImage, "png", os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return IOUtils.toByteArray(is);
	}
}
