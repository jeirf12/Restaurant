/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;


import co.unicauca.microkernel.client.domain.ClienteService;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.infra.Utilities;
import static co.unicauca.microkernel.common.infra.Utilities.convertirFoto;
import static java.awt.Image.SCALE_SMOOTH;
import static java.lang.Integer.parseInt;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EdynsonMJ
 */
public class ModificarEspecial extends javax.swing.JFrame {

    private PlatoEspecial especial;
    private ClienteService cliente;
    private FramePrincipalAdmin frame;

    /**
     * Creates new form FrameEdynson
     */
    public ModificarEspecial(PlatoEspecial plato, ClienteService cliente, FramePrincipalAdmin frame) {
        this.setVisible(true);
        this.cliente = cliente;
        this.frame = frame;
        this.especial = plato;
        initComponents();
        this.llenarDatos();
        this.txtId.setEditable(false);
        this.btnActualizar.setEnabled(false);
        if(especial.getImagen()==null){
            this.btnQuitar.setEnabled(false);
        }
    }

    private void llenarDatos() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.txtId.setText(especial.getId_pe() + "");
        this.txtNombre.setText(especial.getNombre());
        this.txtPrecio.setText(especial.getPrecio() + "");
        this.txtDescripcion.setText(especial.getDescripcion());
        if(especial.getImagen()!=null){
            this.lblImagen.setIcon(Utilities.crearIcono(especial.getImagen(), this.lblImagen.getWidth(), this.lblImagen.getHeight()));
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
        btnActualizar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(30, 100, 85));

        lblPlatoId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPlatoId.setForeground(new java.awt.Color(255, 255, 255));
        lblPlatoId.setText("Id plato:");

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setText("MODIFICAR PLATO ESPECIAL");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio:");

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("descripcion:");

        lblFoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("Foto:");

        txtNombre.setCaretColor(new java.awt.Color(255, 0, 0));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtRuta.setEditable(false);
        txtRuta.setCaretColor(new java.awt.Color(255, 0, 0));

        txtId.setCaretColor(new java.awt.Color(255, 0, 0));

        btnFoto.setText("nueva foto");
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

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtDescripcion.setCaretColor(new java.awt.Color(255, 0, 0));
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar foto");
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
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar)))
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnActualizar)
                        .addGap(59, 59, 59)
                        .addComponent(btnCancelar))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
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
                            .addComponent(btnFoto)
                            .addComponent(btnQuitar)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
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
            this.habilitarBtnActualizar();
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        var plato = new PlatoEspecial();
        plato.setId_pe(parseInt(this.txtId.getText()));
        plato.setNombre(this.txtNombre.getText());
        plato.setDescripcion(this.txtDescripcion.getText());
        plato.setPrecio(parseInt(this.txtPrecio.getText()));
        if(!(this.txtRuta.getText().isBlank())){
            plato.setImagen(convertirFoto(this.txtRuta.getText()));
        }else{
            plato.setImagen(null);
        }
        plato.setMenuEsp(this.especial.getMenuEsp());
        try {
            if (cliente.updatePlatoEspecial(plato)) {
                JOptionPane.showConfirmDialog(rootPane, "PLATO ACTUALIZADO", "OK", JOptionPane.CLOSED_OPTION);
                frame.crearTablaEspeciales();
                this.dispose();
            } else {
                JOptionPane.showConfirmDialog(rootPane, "PLATO NO ACTUALIZADO VERIFICA", "FALLO!!!!", JOptionPane.OK_OPTION);
            }
        } catch (Exception ex) {
            getLogger(ModificarRacion.class.getName()).log(SEVERE, null, ex);
            JOptionPane.showConfirmDialog(rootPane, "NO SE PUDO COMPLETAR LA OPERACION", "FATAL!!!!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased

        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void habilitarBtnActualizar() {
        if (txtNombre.getText().isBlank()
                || this.txtPrecio.getText().isBlank()
                || this.txtDescripcion.getText().isBlank()) {
            this.btnActualizar.setEnabled(false);
        } else if (this.txtNombre.getText().equals(especial.getNombre())
                && this.txtDescripcion.getText().equals(especial.getDescripcion())
                && this.txtPrecio.getText().equals(especial.getPrecio() + "")
                && this.txtRuta.getText().isBlank()) {
            this.btnActualizar.setEnabled(false);
        } else {
            this.btnActualizar.setEnabled(true);
        }
    }

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased

        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        this.txtRuta.setText("imagen retirada");
        this.especial.setImagen(null);
        this.habilitarBtnActualizar();
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnQuitar;
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
