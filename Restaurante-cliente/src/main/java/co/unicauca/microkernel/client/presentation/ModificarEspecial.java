/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.infra.Utilities;
import static co.unicauca.microkernel.common.infra.Utilities.convertirFoto;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EdynsonMJ
 */
public class ModificarEspecial extends javax.swing.JFrame {

    /**
     * Creates new form FrameEdynson
     */
    public ModificarEspecial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblPlatoId = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnFoto = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(51, 51, 51));

        lblPlatoId.setForeground(new java.awt.Color(255, 255, 255));
        lblPlatoId.setText("Id plato:");

        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setText("Modificar plato especial");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio:");

        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("descripcion:");

        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("Foto:");

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setCaretColor(new java.awt.Color(255, 0, 0));

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(0, 0, 0));
        txtRuta.setForeground(new java.awt.Color(255, 255, 255));
        txtRuta.setCaretColor(new java.awt.Color(255, 0, 0));

        txtId.setBackground(new java.awt.Color(0, 0, 0));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setCaretColor(new java.awt.Color(255, 0, 0));

        btnFoto.setBackground(new java.awt.Color(0, 0, 0));
        btnFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnFoto.setText("upload");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        txtPrecio.setBackground(new java.awt.Color(0, 0, 0));
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setCaretColor(new java.awt.Color(255, 0, 0));

        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setCaretColor(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescripcion))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblPlatoId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFoto)))
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton1))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 42, Short.MAX_VALUE))
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                    .addContainerGap(199, Short.MAX_VALUE)
                    .addComponent(lblTitulo1)
                    .addGap(229, 229, 229)))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlatoId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFoto)
                            .addComponent(btnFoto)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblTitulo1)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        var j = new JFileChooser();
        var fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);
        
        var s = j.showOpenDialog(this);
        if(s == APPROVE_OPTION){
            var ruta = j.getSelectedFile().getAbsolutePath();
            txtRuta.setText(ruta);
            var imagen = new ImageIcon(ruta);
            this.lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), SCALE_SMOOTH)));
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var plato = new PlatoEspecial();
        plato.setId_pe(parseInt(this.txtId.getText()));
        plato.setNombre(this.txtNombre.getText());
        plato.setDescripcion(this.txtDescripcion.getText());
        plato.setPrecio(parseInt(this.txtPrecio.getText()));
        plato.setImagen(convertirFoto(this.txtRuta.getText()));
        plato.setMenuEsp(1);
        
        var service = getInstance().getClienteService();
        var servicioRestaurante = new clienteService(service);
        
        try {
            servicioRestaurante.updatePlatoEspecial(plato);
        } catch (Exception ex) {
            getLogger(ModificarEspecial.class.getName()).log(SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPlatoId;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
