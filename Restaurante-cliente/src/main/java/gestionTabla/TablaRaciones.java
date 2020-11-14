/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionTabla;


import co.unicauca.microkernel.common.entities.RacionDia;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaRaciones {

    public void ver_tabla(JTable tabla, ArrayList<RacionDia> raciones) {
        tabla.setDefaultRenderer(Object.class, new Render());

        //lista de titulos
        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("ID");
        titulosList.add("NOMBRE");
        titulosList.add("DIA");
        titulosList.add("TIPO");
        titulosList.add("PRECIO");
        titulosList.add(" ");
        titulosList.add(" ");

        //copiar titulos
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data =obtenerMatrizDatos(titulosList,raciones);
        
        DefaultTableModel d = new DefaultTableModel(data, titulos)  {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setModel(d);

        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, ArrayList<RacionDia> raciones) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        int tamaño = titulosList.size();
        Object informacion[][] = new Object[raciones.size()][tamaño];
        //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
        for (int x = 0; x < informacion.length; x++) {
            JButton btnModificar = new JButton("modificar");
            btnModificar.setName("modificar");
            JButton btnEliminar = new JButton("eliminar");
            btnEliminar.setName("eliminar");
            
            informacion[x][StructRaciones.ID] = raciones.get(x).getRacId() + "";
            informacion[x][StructRaciones.NOMBRE] = raciones.get(x).getNombre() + "";
            informacion[x][StructRaciones.TIPO] = raciones.get(x).getTipo() + "";
            informacion[x][StructRaciones.PRECIO] = raciones.get(x).getPrecio() + "";
            informacion[x][StructRaciones.DIA] = raciones.get(x).getMenuId() + "";
            informacion[x][StructRaciones.MODIFICAR] = btnModificar;
            informacion[x][StructRaciones.ELIMINAR] = btnEliminar;
        }
        return informacion;
    }
    

}
