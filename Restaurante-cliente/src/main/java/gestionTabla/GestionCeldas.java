/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionTabla;

import java.awt.Color;
import static java.awt.Color.WHITE;
import static java.awt.Color.white;
import java.awt.Component;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author EdynsonMJ
 */
public class GestionCeldas extends DefaultTableCellRenderer{
    private String tipo="texto";

	//se definen por defecto los tipos de datos a usar
	private Font normal = new Font( "Verdana", PLAIN,12 );
	private Font bold = new Font( "Verdana", BOLD,12 );
	//etiqueta que almacenará el icono a mostrar
	private JLabel label = new JLabel();
	//iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
	//private ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/recursos/iconos/ico_guardar.png"));
	//private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/recursos/iconos/ico_buscar.png"));
	   
	
	
	public GestionCeldas(){
		
	}

	/**
	 * Constructor explicito con el tipo de dato que tendrá la celda
	 * @param tipo
	 */
	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará a este metodo
		 */
		
		//definimos colores por defecto
        Color colorFondo = null;
        var colorFondoPorDefecto=new Color( 192, 192, 192);
        var colorFondoSeleccion=new Color( 140, 140 , 140);
    	
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	//Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(white);
        }
                
        /*
         * Se definen los tipos de datos que contendrán las celdas basado en la instancia que
         * se hace en la ventana de la tabla al momento de construirla
         */
        if( tipo.equals("texto"))
        {
        	//si es tipo texto define el color de fondo del texto y de la celda así como la alineación
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
            this.setHorizontalAlignment(LEFT);
            this.setText( (String) value );
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground((selected)? colorFondo :WHITE);	
            this.setFont(normal);   
            //this.setFont(bold);
            return this;
        }
         
        //si el tipo es icono entonces valida cual icono asignar a la etiqueta.
        /*if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("PERFIL") )
            {
            	label.setIcon(iconoBuscar);
            }
            else if( String.valueOf(value).equals("EVENTO") )
            {
            	label.setIcon(iconoGuardar);
            }
            label.setHorizontalAlignment( JLabel.LEFT );
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
//            return boton;
            return label;
        }*/
        
        //definie si el tipo de dato el numerico para personalizarlo
        if( tipo.equals("numerico"))
        {           
        	if (focused) {
     			colorFondo=colorFondoSeleccion;
     		}else{
     			colorFondo=colorFondoPorDefecto;
     		}
        	// System.out.println(value);
            this.setHorizontalAlignment(CENTER);
            this.setText( (String) value );            
            this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );    
            this.setBackground((selected)? colorFondo :WHITE);
           // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
            this.setFont(bold);            
            return this;   
        }
		
		return this;
		
		
	}
}
