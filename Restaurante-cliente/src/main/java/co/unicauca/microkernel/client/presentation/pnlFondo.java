/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author EdynsonMJ
 */
public class pnlFondo extends JPanel{
    private int ancho;
    private int alto;
    private Image fondo;
    public pnlFondo(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
    }
    @Override
    public void paint(Graphics g){
        this.fondo = new ImageIcon(this.getClass().getResource("/fondo1.jpg")).getImage();
        g.drawImage(fondo, 0, 0, ancho, alto, this);
        this.setOpaque(false);
        super.paint(g);
    }
}
