package com.mycompany.practica8diu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LienzoImg extends JPanel {

    private Mat imagenMat, matOriginal;
    private BufferedImage imagen;
    
    public LienzoImg(){
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
    }
    
    public void cargaImagen(File file){
        matOriginal = Imgcodecs.imread(file.getAbsolutePath());
        imagenMat = matOriginal.clone();
        imagen= (BufferedImage) HighGui.toBufferedImage(imagenMat);
        repaint();
    }

    private BufferedImage ImagenUmbralizada(int umbral) throws UnsupportedOperationException {
        try {
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

    void umbralizarImagen(File fichero,int value) {
        imagenMat=Imgcodecs.imread(fichero.getAbsolutePath());
        imagen = ImagenUmbralizada(value);
        repaint();
    }
    
    public BufferedImage getImage() {
        return imagen;
    }
    
    public void guardarImage(String path){
        matOriginal=imagenMat.clone();
        Imgcodecs.imwrite(path,imagenMat);
    }
}
