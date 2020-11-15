/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.infra.Utilities;
import gestionTabla.TablaEspeciales;
import gestionTabla.TablaRaciones;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 *
 * @author EdynsonMJ
 */
public class FramePrincipalAdmin extends javax.swing.JFrame {

    //listas
    List<RacionDia> raciones;
    List<PlatoEspecial> especiales;
    //tablas
    TablaRaciones tabRaciones;
    TablaEspeciales tabEspeciales;
    //servicio
    IClienteAccess service;
    clienteService servicioRestaurante;

    /**
     * Creates new form FramePrincipalAdmin
     */
    public FramePrincipalAdmin() {

        try {
            //INSTANCIANDO EL SERVICIO, POR FABRICA
            service = getInstance().getClienteService();
            servicioRestaurante = new clienteService(service);
            //INICIALIZANDO TABLAS
            tabRaciones = new TablaRaciones();
            tabEspeciales = new TablaEspeciales();
            //INICIANDO COMPONENENTES
            initComponents();
            //INICIALIZANDO TABLAS Y LLENANDO LISTAS
            raciones = new ArrayList<>();
            especiales = new ArrayList<>();
            this.crearTablaRaciones();
            this.crearTablaEspeciales();

        } catch (Exception ex) {
            getLogger(FramePrincipalAdmin.class.getName()).log(SEVERE, null, ex);
        }
        //this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpPestanias = new javax.swing.JTabbedPane();
        pnlInicio = new javax.swing.JPanel();
        lblImagenInicio = new javax.swing.JLabel();
        pnlInfoUsuario = new javax.swing.JPanel();
        lblImagenUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblNombreRestaurante = new javax.swing.JLabel();
        pnlRaciones = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cbxDia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRaciones = new javax.swing.JTable();
        lblImagenRacion = new javax.swing.JLabel();
        btnAgregarRacion = new javax.swing.JButton();
        pnlEspeciales = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEspeciales = new javax.swing.JTable();
        lblImagenEspecial = new javax.swing.JLabel();
        btnAddEspecial = new javax.swing.JButton();
        pnlPedidos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombreUsuario.setText("Nombre: ");

        lblNombreRestaurante.setText("Restaurante:");

        javax.swing.GroupLayout pnlInfoUsuarioLayout = new javax.swing.GroupLayout(pnlInfoUsuario);
        pnlInfoUsuario.setLayout(pnlInfoUsuarioLayout);
        pnlInfoUsuarioLayout.setHorizontalGroup(
            pnlInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreRestaurante, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoUsuarioLayout.setVerticalGroup(
            pnlInfoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreRestaurante)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(pnlInfoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInfoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImagenInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jtpPestanias.addTab("INICIO", pnlInicio);

        lblFiltro.setText("Filtar por dia:");

        cbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));

        tblRaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DIA", "TIPO", "PRECIO", "ACCION 1", "ACCION 2"
            }
        ));
        tblRaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRaciones);
        if (tblRaciones.getColumnModel().getColumnCount() > 0) {
            tblRaciones.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        btnAgregarRacion.setText("AGREGAR");
        btnAgregarRacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRacionesLayout = new javax.swing.GroupLayout(pnlRaciones);
        pnlRaciones.setLayout(pnlRacionesLayout);
        pnlRacionesLayout.setHorizontalGroup(
            pnlRacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRacionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlRacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRacionesLayout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagenRacion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarRacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        pnlRacionesLayout.setVerticalGroup(
            pnlRacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltro))
                .addGap(18, 18, 18)
                .addGroup(pnlRacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenRacion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarRacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpPestanias.addTab("RACIONES", pnlRaciones);

        tblEspeciales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "PRECIO", "ACCION 1", "ACCION 1"
            }
        ));
        tblEspeciales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEspecialesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEspeciales);
        if (tblEspeciales.getColumnModel().getColumnCount() > 0) {
            tblEspeciales.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        btnAddEspecial.setText("AGREGAR");
        btnAddEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEspecialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEspecialesLayout = new javax.swing.GroupLayout(pnlEspeciales);
        pnlEspeciales.setLayout(pnlEspecialesLayout);
        pnlEspecialesLayout.setHorizontalGroup(
            pnlEspecialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecialesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(lblImagenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddEspecial)
                .addGap(269, 269, 269))
        );
        pnlEspecialesLayout.setVerticalGroup(
            pnlEspecialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEspecialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAddEspecial)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jtpPestanias.addTab("PLATOS ESPECIALES", pnlEspeciales);

        jLabel4.setText("PEDIDOS");

        javax.swing.GroupLayout pnlPedidosLayout = new javax.swing.GroupLayout(pnlPedidos);
        pnlPedidos.setLayout(pnlPedidosLayout);
        pnlPedidosLayout.setHorizontalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidosLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel4)
                .addContainerGap(504, Short.MAX_VALUE))
        );
        pnlPedidosLayout.setVerticalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidosLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel4)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jtpPestanias.addTab("PEDIDOS", pnlPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtpPestanias)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPestanias, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRacionesMouseClicked
        int column = tblRaciones.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblRaciones.getRowHeight();
        byte[] imagen = this.raciones.get(row).getImagen();
        if (imagen != null) {
            this.lblImagenRacion.setIcon(Utilities.crearIcono(imagen, this.lblImagenRacion.getWidth(), this.lblImagenRacion.getHeight()));
        } else {
            this.lblImagenRacion.setIcon(null);
            this.lblImagenRacion.setText("no hay imagen para mostrar");
        }
        //INSTANCIAR IMAGEN

        if (row < tblRaciones.getRowCount() && row >= 0 && column < tblRaciones.getColumnCount() && column >= 0) {
            Object value = tblRaciones.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                var boton = (JButton) value;
                if (boton.getName().equals("modificar")) {
                    RacionDia aux = new RacionDia();
                    aux.setRacId(this.raciones.get(row).getRacId());
                    aux.setNombre(this.raciones.get(row).getNombre());
                    aux.setPrecio(this.raciones.get(row).getPrecio());
                    aux.setTipo(this.raciones.get(row).getTipo());
                    aux.setMenuId(this.raciones.get(row).getMenuId());
                    aux.setImagen(this.raciones.get(row).getImagen());
                    try {
                        ModificarRacion frameRacion = new ModificarRacion(aux, this.servicioRestaurante, this);
                    } catch (Exception ex) {
                        Logger.getLogger(FramePrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (boton.getName().equals("eliminar")) {
                    int fila = tblRaciones.getSelectedRow();
                    int clave = this.raciones.get(fila).getRacId();
                    try {
                        if ((JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quiere eliminar la racion \""
                                + this.raciones.get(fila).getNombre()
                                + "\"?", "Eliminar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.YES_OPTION) {

                            if (this.servicioRestaurante.deleteRacionDia(clave) == "FALLO") {
                                JOptionPane.showMessageDialog(rootPane, "El registro no existe");
                            } else {
                                this.lblImagenRacion.setIcon(null);
                                this.crearTablaRaciones();
                                JOptionPane.showMessageDialog(rootPane, "operacion exitosa");
                            }

                        }
                    } catch (Exception ex) {
                        showConfirmDialog(null, "OPERACION FALLIDA", "Confirmar", OK_CANCEL_OPTION);
                    }
                }
            }
            if (value instanceof JCheckBox) {
                //((JCheckBox)value).doClick();
                var ch = (JCheckBox) value;
                if (ch.isSelected() == true) {
                    ch.setSelected(false);
                }
                if (ch.isSelected() == false) {
                    ch.setSelected(true);
                }

            }
        }
    }//GEN-LAST:event_tblRacionesMouseClicked

    private void tblEspecialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspecialesMouseClicked
        int column = tblEspeciales.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblEspeciales.getRowHeight();
        byte[] imagen = this.especiales.get(row).getImagen();
        if (imagen != null) {
            this.lblImagenEspecial.setIcon(Utilities.crearIcono(imagen, this.lblImagenEspecial.getWidth(), this.lblImagenEspecial.getHeight()));
        } else {
            this.lblImagenEspecial.setIcon(null);
            this.lblImagenEspecial.setText("no hay imagen");
        }
        //fijarImagenEspecial(imagen);

        if (row < tblEspeciales.getRowCount() && row >= 0 && column < tblEspeciales.getColumnCount() && column >= 0) {
            Object value = tblEspeciales.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                var boton = (JButton) value;
                if (boton.getName().equals("modificar")) {
                    if (boton.getName().equals("modificar")) {
                        PlatoEspecial aux = new PlatoEspecial();
                        aux.setId_pe(this.especiales.get(row).getId_pe());
                        aux.setNombre(this.especiales.get(row).getNombre());
                        aux.setPrecio(this.especiales.get(row).getPrecio());
                        aux.setDescripcion(this.especiales.get(row).getDescripcion());
                        aux.setImagen(this.especiales.get(row).getImagen());
                        try {
                            ModificarEspecial frameEspecial = new ModificarEspecial(aux, this.servicioRestaurante, this);
                        } catch (Exception ex) {
                            Logger.getLogger(FramePrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (boton.getName().equals("eliminar")) {
                            int fila = tblEspeciales.getSelectedRow();
                            int clave = this.especiales.get(fila).getId_pe();
                            try {
                                if ((JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que quiere eliminar el plato \""
                                        + this.especiales.get(fila).getNombre()
                                        + "\"?", "Eliminar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == JOptionPane.YES_OPTION) {

                                    if (this.servicioRestaurante.deletePlatoEspecial(clave) == "FALLO") {
                                        JOptionPane.showMessageDialog(rootPane, "El registro no existe");
                                    } else {
                                        this.lblImagenEspecial.setIcon(null);
                                        this.crearTablaEspeciales();
                                        JOptionPane.showMessageDialog(rootPane, "operacion exitosa");
                                    }

                                }
                            } catch (Exception ex) {
                                showConfirmDialog(null, "OPERACION FALLIDA", "Confirmar", OK_CANCEL_OPTION);
                            }

                            //EVENTOS ELIMINAR
                        }
                    }
                    if (value instanceof JCheckBox) {
                        //((JCheckBox)value).doClick();
                        var ch = (JCheckBox) value;
                        if (ch.isSelected() == true) {
                            ch.setSelected(false);
                        }
                        if (ch.isSelected() == false) {
                            ch.setSelected(true);
                        }

                    }
                }
    }//GEN-LAST:event_tblEspecialesMouseClicked
        } 
    }

    private void btnAgregarRacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRacionActionPerformed
        // TODO add your handling code here:
        AgregarRacion aux = new AgregarRacion(this.servicioRestaurante, this);
        aux.setVisible(true);
    }//GEN-LAST:event_btnAgregarRacionActionPerformed

    private void btnAddEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEspecialActionPerformed
        AgregarEspecial add = new AgregarEspecial(this.servicioRestaurante, this);
        add.setVisible(true);
    }//GEN-LAST:event_btnAddEspecialActionPerformed

    private void serviceListarRaciones() throws Exception {
        //el numero debe reemplazarse por el codigo del restaurante proveniente de la base de datos
        this.raciones = servicioRestaurante.listMenuDay(1, "LUNES", "administrador");
    }

    private void serviceListarEspeciales() throws Exception {
        //el numero debe reemplazarse por el codigo del restaurante proveniente de la base de datos
        this.especiales = servicioRestaurante.listMenuSpecial(1, "administrador");
    }

    public void crearTablaRaciones() throws Exception {
        this.tblRaciones.removeAll();
        this.serviceListarRaciones();
        tabRaciones.ver_tabla(tblRaciones, raciones);

    }

    public void crearTablaEspeciales() throws Exception {
        this.tblEspeciales.removeAll();
        this.serviceListarEspeciales();
        tabEspeciales.ver_tabla(tblEspeciales, especiales);
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
            java.util.logging.Logger.getLogger(FramePrincipalAdmin

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipalAdmin

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipalAdmin

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipalAdmin

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipalAdmin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEspecial;
    private javax.swing.JButton btnAgregarRacion;
    private javax.swing.JComboBox<String> cbxDia;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jtpPestanias;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblImagenEspecial;
    private javax.swing.JLabel lblImagenInicio;
    private javax.swing.JLabel lblImagenRacion;
    private javax.swing.JLabel lblImagenUsuario;
    private javax.swing.JLabel lblNombreRestaurante;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPanel pnlEspeciales;
    private javax.swing.JPanel pnlInfoUsuario;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlPedidos;
    private javax.swing.JPanel pnlRaciones;
    private javax.swing.JTable tblEspeciales;
    private javax.swing.JTable tblRaciones;
    // End of variables declaration//GEN-END:variables

}
