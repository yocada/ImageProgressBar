package com.dcm.imageprogressbar.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.dcm.imageprogressbar.models.Image;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcm.imageprogressbar.ImageProgressBar;


@RestController
@RequestMapping("imageprogressbar")
public class ImageProgressBarREST {
	
	@GetMapping(value = "test")
	public String test() {
		return "Test OK!";
	}

	//@GetMapping(value = "download", produces = MediaType.IMAGE_PNG_VALUE)
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "get")
	public ResponseEntity<Image> getImage() throws IOException {

		ImageProgressBar bProgreso = new ImageProgressBar();
		bProgreso.setColors(ImageProgressBar.Color.BLANCO, ImageProgressBar.Color.NEGRO, ImageProgressBar.Color.NARANJA);
		bProgreso.setImage(50, 10, BufferedImage.TYPE_4BYTE_ABGR, (float)37.5);

		var buffImage = bProgreso.getImg();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(buffImage, "png", os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());

		var array = IOUtils.toByteArray(is);
		var imagen = new Image(array);
		return ResponseEntity.ok(imagen);
	}
}


