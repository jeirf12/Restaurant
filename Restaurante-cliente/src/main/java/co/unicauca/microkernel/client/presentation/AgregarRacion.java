/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.domain.ClienteService;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.infra.Utilities;
import static java.awt.Image.SCALE_SMOOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EdynsonMJ
 */
public class AgregarRacion extends javax.swing.JFrame {
    private ClienteService cliente;
    private FramePrincipalAdmin frame;
    private RacionDia racion;
    private int idRestaurante;

    /**
     * Creates new form FrameEdynson
     * @param cliente
     * @param frame
     */

    public AgregarRacion(ClienteService cliente, FramePrincipalAdmin frame,int idRestaurante) {
        this.cliente = cliente;
        this.frame = frame;
        this.idRestaurante = idRestaurante;
        this.racion = new RacionDia();
        initComponents();
        this.btnAgregar.setEnabled(false);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        lblTitulo1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        cbxDia = new javax.swing.JComboBox<>();
        btnFoto = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(30, 100, 85));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setText("AGREGAR RACION");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecio.setText("Precio:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setText("Tipo:");

        lblFoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFoto.setText("Foto:");

        txtNombre.setCaretColor(new java.awt.Color(255, 0, 0));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtRuta.setEditable(false);
        txtRuta.setCaretColor(new java.awt.Color(255, 0, 0));
        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRutaKeyReleased(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ENTRADA", "BASE", "BEBIDA", "CARNE" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        lblDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDia.setText("Dia:");

        cbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        cbxDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDiaItemStateChanged(evt);
            }
        });

        btnFoto.setText("Subir");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        txtPrecio.setCaretColor(new java.awt.Color(255, 0, 0));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)))
                                .addGap(30, 30, 30))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)))
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 32, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                    .addContainerGap(202, Short.MAX_VALUE)
                    .addComponent(lblTitulo1)
                    .addGap(229, 229, 229)))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDia)
                            .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFoto)
                    .addComponent(btnFoto)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblTitulo1)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        var j = new JFileChooser();
        var fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);
        var s = j.showOpenDialog(this);
        if (s == APPROVE_OPTION) {
            var ruta = j.getSelectedFile().getAbsolutePath();
            txtRuta.setText(ruta);
            var imagen = new ImageIcon(ruta);
            this.lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), SCALE_SMOOTH)));
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.racion.setNombre(this.txtNombre.getText());
        this.racion.setPrecio(Integer.parseInt(this.txtPrecio.getText()));
        this.racion.setMenuId(this.cbxDia.getSelectedIndex());
        this.racion.setTipo(CategoriaEnum.valueOf(this.cbxTipo.getSelectedItem().toString()));
        if (!(this.txtRuta.getText().isBlank())) {
            this.racion.setImagen(Utilities.convertirFoto(this.txtRuta.getText()));
        }else{
            this.racion.setImagen(null);
        }
        try {
            if (cliente.saveRacionDia(racion,idRestaurante) == null) {
                JOptionPane.showConfirmDialog(rootPane, "ES PROBABLE QUE ESTE NOMBRE YA ESTE REGISTRADO", "ERROR", JOptionPane.CLOSED_OPTION);
            } else {
                JOptionPane.showConfirmDialog(rootPane, "RACION AGREGADO CON EXITO!!!", "OK", JOptionPane.CLOSED_OPTION);
                frame.crearTablaRaciones();
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "ERROR FATAL, NO SE PUDO CUMPLIR LA PETICION, REVISE LOS DATOS DIGITADOS", "ERROR", JOptionPane.CLOSED_OPTION);
            Logger.getLogger(AgregarRacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void habilitarBtnAgregar() {
        if (this.txtNombre.getText().isBlank() || this.txtPrecio.getText().isBlank() || this.cbxDia.getSelectedIndex() == 0 || this.cbxTipo.getSelectedIndex() == 0) {
            this.btnAgregar.setEnabled(false);
        } else {
            this.btnAgregar.setEnabled(true);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        this.habilitarBtnAgregar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        this.habilitarBtnAgregar();
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        this.habilitarBtnAgregar();
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void cbxDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDiaItemStateChanged
        this.habilitarBtnAgregar();
    }//GEN-LAST:event_cbxDiaItemStateChanged

    private void txtRutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyReleased
        this.habilitarBtnAgregar();
    }//GEN-LAST:event_txtRutaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JComboBox<String> cbxDia;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
