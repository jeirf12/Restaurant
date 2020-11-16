/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionTabla;

import co.unicauca.microkernel.common.entities.RacionDia;
import static gestionTabla.StructRaciones.DIA;
import static gestionTabla.StructRaciones.ELIMINAR;
import static gestionTabla.StructRaciones.ID;
import static gestionTabla.StructRaciones.MODIFICAR;
import static gestionTabla.StructRaciones.NOMBRE;
import static gestionTabla.StructRaciones.PRECIO;
import static gestionTabla.StructRaciones.TIPO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.table.DefaultTableModel;

public class TablaRaciones {

    public void ver_tabla(JTable tabla, List<RacionDia> raciones) {
        tabla.setDefaultRenderer(Object.class, new Render());

        //lista de titulos
        var titulosList = new ArrayList<String>();

        titulosList.add("ID");
        titulosList.add("NOMBRE");
        titulosList.add("DIA");
        titulosList.add("TIPO");
        titulosList.add("PRECIO");
        titulosList.add(" ");
        titulosList.add(" ");

        //copiar titulos
        var titulos = new String[titulosList.size()];
        for (var i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        var data =obtenerMatrizDatos(titulosList,raciones);
        
        DefaultTableModel d = new DefaultTableModel(data, titulos)  {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        tabla.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabla.setModel(d);

        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, List<RacionDia> raciones) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        var tamaño = titulosList.size();
        var informacion = new Object[raciones.size()][tamaño];
        //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
        for (var x = 0; x < informacion.length; x++) {
            var btnModificar = new JButton("modificar");
            btnModificar.setName("modificar");
            var btnEliminar = new JButton("eliminar");
            btnEliminar.setName("eliminar");
            
            informacion[x][ID] = raciones.get(x).getRacId() + "";
            informacion[x][NOMBRE] = raciones.get(x).getNombre() + "";
            informacion[x][TIPO] = raciones.get(x).getTipo() + "";
            informacion[x][PRECIO] = raciones.get(x).getPrecio() + "";
            informacion[x][DIA] = raciones.get(x).getMenuId() + "";
            informacion[x][MODIFICAR] = btnModificar;
            informacion[x][ELIMINAR] = btnEliminar;
        }
        return informacion;
    }
    

}
