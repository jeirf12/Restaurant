/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionTabla;

import co.unicauca.microkernel.common.entities.RacionDia;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author EdynsonMJ
 */
public interface ITabla {
    void ver_tabla(JTable tabla);
    Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, ArrayList<Object> raciones);
}
