package com.mycompany.practica8diu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class LienzoImg extends JPanel {
    private BufferedImage imagen;
    private BufferedImage imagen2;
    
    public LienzoImg(){
        try {
            imagen = ImageIO.read(new URL("https://m.media-amazon.com/images/I/71P17wt++yL._AC_UX425_.jpg"));
            imagen2 = imagen;
        } catch (IOException ex) {
            Logger.getLogger(LienzoImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(imagen2.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
    }
    
    public void cargaImagen(File file){
        try {
            imagen=ImageIO.read(file);
            imagen2 = imagen;
            repaint();
        } catch (IOException ex) {
            Logger.getLogger(LienzoImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Mat bufferedImageAMat(BufferedImage imagenOriginal) {
        Mat mat = new Mat(imagenOriginal.getHeight(), imagenOriginal.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) imagenOriginal.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }
    
    private static BufferedImage ImagenUmbralizada(BufferedImage imagenOriginal, int umbral) throws UnsupportedOperationException {
        try {
            Mat imagenMat = bufferedImageAMat(imagenOriginal);
            Mat imagenMatGris = new Mat(imagenMat.rows(), imagenMat.cols(), CvType.CV_8U);
            Mat imagenMatUmbral = new Mat(imagenMat.rows(), imagenMat.cols(), CvType.CV_8U);
            Imgproc.cvtColor(imagenMat, imagenMatGris, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(imagenMatGris, imagenMatUmbral, umbral, 255, Imgproc.THRESH_BINARY);
            return (BufferedImage) HighGui.toBufferedImage(imagenMatUmbral);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName() + " " + e.getMessage());
            return null;
        }
    }

    void umbralizarImagen(int value) {
        imagen2 = ImagenUmbralizada(imagen, value);
        repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public BufferedImage getImage() {
        return imagen2;
    }
}
