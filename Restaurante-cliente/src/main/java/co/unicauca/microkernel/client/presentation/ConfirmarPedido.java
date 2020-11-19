/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.ClienteService;
import co.unicauca.microkernel.common.entities.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jafes
 */
public class ConfirmarPedido extends javax.swing.JFrame {
    IClienteAccess service;
    ClienteService servicioRestaurante;
    
    public static int domi;
    public static int sum;
    public static int imp;
    public static int tot;

    
    private Pedido pedido;
    
    public ConfirmarPedido(Pedido pedido, ClienteService cliente) throws Exception {
        
        service = getInstance().getClienteService();
        servicioRestaurante = new ClienteService(service);
        
        this.pedido = pedido;

        String suma = servicioRestaurante.sumOrder(pedido.getCliente(), pedido.getIdPedido());
        String impuesto = servicioRestaurante.impuestoRestaurante(pedido.getCliente(), pedido.getIdPedido());
        String domicilio = servicioRestaurante.priceDomicileOrder(pedido.getCliente(), pedido.getIdPedido());
        String TOTAL = servicioRestaurante.total(pedido.getCliente(), pedido.getIdPedido());
        
        System.out.println("impuesto: "+impuesto);
        domi = Integer.parseInt(domicilio);
        sum = Integer.parseInt(suma);
        imp = Integer.parseInt(impuesto);
        tot = Integer.parseInt(TOTAL);
        
        initComponents();
        lblSumaOrdenesR.setText(String.valueOf(sum));
        lblImpuestoPedido.setText(String.valueOf(imp));
        lblPrecioDomicilio.setText(String.valueOf(domi));
        lblTotalR.setText(String.valueOf(tot));
        
        System.out.println("alsd,"+pedido.getIdPedido());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTOTAL = new javax.swing.JLabel();
        lblSumaOrdenes = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblImpuesto = new javax.swing.JLabel();
        btnCancelarPedido = new javax.swing.JButton();
        btnPagarPedido = new javax.swing.JButton();
        lblSumaOrdenesR = new javax.swing.JLabel();
        lblImpuestoPedido = new javax.swing.JLabel();
        lblPrecioDomicilio = new javax.swing.JLabel();
        lblTotalR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTOTAL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTOTAL.setForeground(new java.awt.Color(255, 0, 0));
        lblTOTAL.setText("TOTAL: ");

        lblSumaOrdenes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSumaOrdenes.setText("SUMA ORDENES: ");

        lblDomicilio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDomicilio.setText("DOMICILIO");

        lblImpuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblImpuesto.setText("IMPUESTO PEDIDO: ");

        btnCancelarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelarPedido.setText("CANCELAR PEDIDO");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        btnPagarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPagarPedido.setText("PAGAR PEDIDO");
        btnPagarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarPedidoActionPerformed(evt);
            }
        });

        lblSumaOrdenesR.setText(" ");

        lblImpuestoPedido.setText(" ");

        lblPrecioDomicilio.setText(" ");

        lblTotalR.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDomicilio)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTOTAL)
                                .addGap(8, 8, 8)))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSumaOrdenes)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelarPedido)
                            .addComponent(lblImpuesto))
                        .addGap(50, 50, 50)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPagarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSumaOrdenesR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImpuestoPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrecioDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSumaOrdenes)
                    .addComponent(lblSumaOrdenesR))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImpuesto)
                    .addComponent(lblImpuestoPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDomicilio)
                    .addComponent(lblPrecioDomicilio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTOTAL)
                    .addComponent(lblTotalR))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarPedido)
                    .addComponent(btnPagarPedido))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        try {
            this.servicioRestaurante.cancelPedido(pedido);
            this.setVisible(false);
            FramePrincipalCliente instancia = new FramePrincipalCliente(pedido.getCliente());
            instancia.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void btnPagarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarPedidoActionPerformed
        try {
            this.servicioRestaurante.payedPedido(pedido);
            this.setVisible(false);
            FramePrincipalCliente instancia = new FramePrincipalCliente(pedido.getCliente());
            instancia.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagarPedidoActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnPagarPedido;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblImpuesto;
    private javax.swing.JLabel lblImpuestoPedido;
    private javax.swing.JLabel lblPrecioDomicilio;
    private javax.swing.JLabel lblSumaOrdenes;
    private javax.swing.JLabel lblSumaOrdenesR;
    private javax.swing.JLabel lblTOTAL;
    private javax.swing.JLabel lblTotalR;
    // End of variables declaration//GEN-END:variables
}
