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
    private BufferedImage imagen;
    private Mat imagenMat;
    private boolean hasImage;
    
    public LienzoImg(){
        hasImage = false;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        if (hasImage)
            g.drawImage(imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
    }
    
    public void cargaImagen(File file){
        imagenMat = Imgcodecs.imread(file.getAbsolutePath());
        imagen = (BufferedImage) HighGui.toBufferedImage(imagenMat);
        hasImage = true;
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

    void umbralizarImagen(int value) {
        imagen = ImagenUmbralizada(value);
        repaint();
    }
    
    public BufferedImage getImage() {
        return imagen;
    }
    
    public void saveImage(String path){
        Imgcodecs.imwrite(path,imagenMat);
    }
}
