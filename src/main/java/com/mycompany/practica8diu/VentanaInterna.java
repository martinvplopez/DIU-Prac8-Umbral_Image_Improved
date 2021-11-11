
package com.mycompany.practica8diu;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author marti
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    private Practica8 desktopFrame;
    public VentanaInterna(Practica8 desktopFrame,String title) {
        initComponents();
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setResizable(true);
        this.setTitle(title);
        this.desktopFrame=desktopFrame;
    }

    protected void open(File file){
       lienzoImg2.cargaImagen(file);
    }
    
    public void umbral(File fichero, int thresHold){
        lienzoImg2.umbralizarImagen(fichero, thresHold);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzoImg2 = new com.mycompany.practica8diu.LienzoImg();

        javax.swing.GroupLayout lienzoImg2Layout = new javax.swing.GroupLayout(lienzoImg2);
        lienzoImg2.setLayout(lienzoImg2Layout);
        lienzoImg2Layout.setHorizontalGroup(
            lienzoImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        lienzoImg2Layout.setVerticalGroup(
            lienzoImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lienzoImg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzoImg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.practica8diu.LienzoImg lienzoImg2;
    // End of variables declaration//GEN-END:variables
}
