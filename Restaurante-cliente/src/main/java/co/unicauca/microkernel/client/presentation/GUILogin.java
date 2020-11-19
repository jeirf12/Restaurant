/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.ClienteService;
import co.unicauca.microkernel.common.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EdynsonMJ
 */
public class GUILogin extends javax.swing.JFrame {

    private IClienteAccess service;
    private ClienteService servicioRestaurante;
    //pnlFondo fondo = new pnlFondo(this.getWidth(),this.getHeight());

    /**
     * Creates new form GUILogin2
     */
    public GUILogin() {
        service = Factory.getInstance().getClienteService();
        servicioRestaurante = new ClienteService(service);
        initComponents();
        this.btnInicio.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreUsu = new javax.swing.JLabel();
        txtNombreUsu = new javax.swing.JTextField();
        lblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        btnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 100, 85));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("INICIO SESION");

        lblNombreUsu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreUsu.setText("NOMBRE DE USUARIO:");

        txtNombreUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreUsuKeyReleased(evt);
            }
        });

        lblContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblContrasenia.setText("CONTRASEÑA:");

        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyReleased(evt);
            }
        });

        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInicio.setText("INGRESAR");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblContrasenia)
                            .addComponent(btnInicio))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreUsu)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addGap(74, 74, 74)
                .addComponent(lblNombreUsu)
                .addGap(18, 18, 18)
                .addComponent(txtNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(lblContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Cliente us = new Cliente();
        us.setNombre(this.txtNombreUsu.getText());
        us.setContrasenia(this.txtContrasenia.getText());
        
        String re = "";
        String[] arrayResult = null;
        List<String> datoRestaurante = new ArrayList<>();
        try {
            re = servicioRestaurante.validarAcceso(us);
            if (!re.isEmpty()) {
                arrayResult = re.split("-");
                int idCliente = Integer.parseInt(arrayResult[1]);
                System.out.println(idCliente);
                for (int i = 1; i < arrayResult.length; i = i + 3) {
                    datoRestaurante.add(arrayResult[i] + "-" + arrayResult[i + 1]);
                }
                for (int i = 1; i < arrayResult.length; i = i + 3) {
                    System.out.println("[");
                }

                datoRestaurante.add(this.txtNombreUsu.getText());
                if (arrayResult[0].equals("ADMINISTRADOR")) {

                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    this.limpiarCampos();
                    FramePrincipalAdmin ingreso = new FramePrincipalAdmin(datoRestaurante,idCliente);
                    ingreso.setVisible(true);
                    ingreso.pack();
                }
                if (arrayResult[0].equals("COMPRADOR")) {
                    this.setVisible(false);
                    this.limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    FramePrincipalCliente ingreso = new FramePrincipalCliente(idCliente);
                    ingreso.setVisible(true);
                    // EdynsonModificarRacion ingresos = new EdynsonModificarRacion();
                    //ingresos.setVisible(true);
                    ingreso.pack();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña no valida, verifique sus datos");
            }
        } catch (Exception ex) {
            Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void limpiarCampos(){
        this.txtNombreUsu.setText("");
        this.txtContrasenia.setText("");
    }
    
    private void txtNombreUsuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuKeyReleased
        habilitarInicio();
    }//GEN-LAST:event_txtNombreUsuKeyReleased

    private void txtContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyReleased
        habilitarInicio();
    }//GEN-LAST:event_txtContraseniaKeyReleased

    private void habilitarInicio(){
        
        if(this.txtNombreUsu.getText().isBlank() || this.txtContrasenia.getText().isBlank()){
            this.btnInicio.setEnabled(false);
        }else{
            this.btnInicio.setEnabled(true);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabelUsuIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtNombreUsu;
    // End of variables declaration//GEN-END:variables

}
