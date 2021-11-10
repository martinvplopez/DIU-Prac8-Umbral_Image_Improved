
package com.mycompany.practica8diu;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 *
 * @author marti
 */
public class VentanaInterna extends javax.swing.JInternalFrame {


    public VentanaInterna() {
        initComponents();
    }

    protected void open(BufferedImage im){
        this.setPreferredSize(new Dimension(im.getWidth(), im.getHeight()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzoImg1 = new com.mycompany.practica8diu.LienzoImg();

        javax.swing.GroupLayout lienzoImg1Layout = new javax.swing.GroupLayout(lienzoImg1);
        lienzoImg1.setLayout(lienzoImg1Layout);
        lienzoImg1Layout.setHorizontalGroup(
            lienzoImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        lienzoImg1Layout.setVerticalGroup(
            lienzoImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzoImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzoImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.practica8diu.LienzoImg lienzoImg1;
    // End of variables declaration//GEN-END:variables
}
