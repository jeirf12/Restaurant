/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.gestionTabla;
import static co.unicauca.microkernel.client.gestionTabla.StructCarritoEspecialesCf.*;
import co.unicauca.microkernel.common.entities.CarritoG;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jafes
 */
public class TablaCarritoEspecialesCf {
 
    public void ver_tabla(JTable tabla, List<CarritoG> carritoE) {
        tabla.setDefaultRenderer(Object.class, new Render());

        //lista de titulos
        var titulosList = new ArrayList<String>();

        titulosList.add("ID");
        titulosList.add("NOMBRE");
        titulosList.add("PRECIO");
        titulosList.add("CANTIDAD");

        //copiar titulos
        var titulos = new String[titulosList.size()];
        for (var i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        var data =obtenerMatrizDatos(titulosList,carritoE);
        
        DefaultTableModel d = new DefaultTableModel(data, titulos)  {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        tabla.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabla.setModel(d);

        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, List<CarritoG> carritoE) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        var tamaño = titulosList.size();
        var informacion = new Object[carritoE.size()][tamaño];
        //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
        for (var x = 0; x < informacion.length; x++) {
            
            informacion[x][ID] = carritoE.get(x).getIdCarrito() + "";
            informacion[x][NOMBRE] = carritoE.get(x).getNombre() + "";
            informacion[x][PRECIO] = carritoE.get(x).getPrecio() + "";
            informacion[x][CANTIDAD] = carritoE.get(x).getCantidad() + "";

        }
        return informacion;
    }
    

}
