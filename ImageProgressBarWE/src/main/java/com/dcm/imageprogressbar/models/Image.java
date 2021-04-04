package com.dcm.imageprogressbar.models;

/**
 * Representa una imagen
 */
public class Image {

    private byte[] image;

    public Image(){

    }

    public Image(byte[] image){
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
