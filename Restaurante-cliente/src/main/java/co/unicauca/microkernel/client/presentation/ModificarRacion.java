/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.domain.clienteService;
import static co.unicauca.microkernel.common.entities.CategoriaEnum.valueOf;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.infra.Utilities;
import static co.unicauca.microkernel.common.infra.Utilities.convertirFoto;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import static java.lang.Integer.parseInt;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EdynsonMJ
 */
public class ModificarRacion extends javax.swing.JFrame {

    private RacionDia racion;
    private clienteService cliente;
    private FramePrincipalAdmin frame;
    /**
     * Creates new form FrameEdynson
     */
    public ModificarRacion(RacionDia racion, clienteService cliente, FramePrincipalAdmin frame) {
        this.cliente = cliente;
        this.frame = frame;
        this.setVisible(true);
        this.racion = racion;
        initComponents();
        this.llenarDatos();
        this.btnActualizar.setEnabled(false);
    }

    private void llenarDatos() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.txtId.setText(racion.getRacId() + "");
        this.txtNombre.setText(racion.getNombre());
        this.txtPrecio.setText(racion.getPrecio() + "");
        this.cbxDia.setSelectedIndex(racion.getMenuId());
        this.cbxTipo.setSelectedItem(racion.getTipo().name());
        if(racion.getImagen()!=null){
            this.lblImagen.setIcon(Utilities.crearIcono(racion.getImagen(), this.lblImagen.getWidth(), this.lblImagen.getHeight()));
        }
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
        lblRacion = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        cbxDia = new javax.swing.JComboBox<>();
        btnFoto = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(51, 51, 51));

        lblRacion.setForeground(new java.awt.Color(255, 255, 255));
        lblRacion.setText("Id racion:");

        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setText("Modificar racion");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio:");

        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo:");

        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("Foto:");

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setCaretColor(new java.awt.Color(255, 0, 0));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(0, 0, 0));
        txtRuta.setForeground(new java.awt.Color(255, 255, 255));
        txtRuta.setCaretColor(new java.awt.Color(255, 0, 0));
        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRutaKeyReleased(evt);
            }
        });

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(0, 0, 0));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setCaretColor(new java.awt.Color(255, 0, 0));

        cbxTipo.setBackground(new java.awt.Color(0, 0, 0));
        cbxTipo.setForeground(new java.awt.Color(255, 255, 255));
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ENTRADA", "BASE", "BEBIDA", "CARNE" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        lblDia.setForeground(new java.awt.Color(255, 255, 255));
        lblDia.setText("Dia:");

        cbxDia.setBackground(new java.awt.Color(0, 0, 0));
        cbxDia.setForeground(new java.awt.Color(255, 255, 255));
        cbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO" }));
        cbxDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDiaItemStateChanged(evt);
            }
        });

        btnFoto.setBackground(new java.awt.Color(0, 0, 0));
        btnFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnFoto.setText("Nueva");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        txtPrecio.setBackground(new java.awt.Color(0, 0, 0));
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setCaretColor(new java.awt.Color(255, 0, 0));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
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
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(btnFoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtRuta)))
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
                                        .addComponent(cbxTipo, 0, 180, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)))
                                .addGap(13, 13, 13))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblRacion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(btnActualizar)
                .addGap(71, 71, 71)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                    .addContainerGap(295, Short.MAX_VALUE)
                    .addComponent(lblTitulo1)
                    .addGap(229, 229, 229)))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRacion)
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
                            .addComponent(lblTipo)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDia)
                            .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitar)
                            .addComponent(btnFoto)
                            .addComponent(lblFoto)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblTitulo1)
                    .addContainerGap(304, Short.MAX_VALUE)))
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
            this.habilitarBtnActualizar();
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        var racion = new RacionDia();
        racion.setRacId(parseInt(this.txtId.getText()));
        racion.setNombre(this.txtNombre.getText());
        racion.setPrecio(parseInt(this.txtPrecio.getText()));
        racion.setMenuId(this.cbxDia.getSelectedIndex());
        if(!(this.txtRuta.getText().isBlank())){
            racion.setImagen(convertirFoto(this.txtRuta.getText()));
        }else{
            racion.setImagen(null);
        }
        racion.setTipo(valueOf(this.cbxTipo.getSelectedItem().toString()));
        try {
            if(cliente.updateRacion(racion)){
                JOptionPane.showConfirmDialog(rootPane, "PLATO ACTUALIZADO", "OK", JOptionPane.CLOSED_OPTION);
                this.frame.crearTablaRaciones();
                this.dispose();
            }else{
                JOptionPane.showConfirmDialog(rootPane, "PLATO NO ACTUALIZADO VERIFICA", "FALLO!!!!", JOptionPane.OK_OPTION);
            }
        } catch (Exception ex) {
            getLogger(ModificarRacion.class.getName()).log(SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void cbxDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDiaItemStateChanged
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_cbxDiaItemStateChanged

    private void txtRutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyReleased
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtRutaKeyReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        this.racion.setImagen(null);
        this.txtRuta.setText("sin imagen");
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_btnQuitarActionPerformed

    //VERIFICAR ESTE METODO
    private void habilitarBtnActualizar() {

        if (txtNombre.getText().isBlank()
                || this.txtPrecio.getText().isBlank()
                || this.cbxTipo.getSelectedIndex() == 0
                || this.cbxDia.getSelectedIndex() == 0) {
            this.btnActualizar.setEnabled(false);
        } else if (txtNombre.getText().equals(racion.getNombre())
                && this.txtPrecio.getText().equals(racion.getPrecio()+"")
                && this.cbxTipo.getSelectedItem().toString().equals(racion.getTipo().toString())
                && this.cbxDia.getSelectedItem().toString().equals(racion.getTipo().toString())
                && this.txtRuta.getText().isBlank()) {
            this.btnActualizar.setEnabled(false);
        } else {
            this.btnActualizar.setEnabled(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cbxDia;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRacion;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
