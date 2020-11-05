package co.unicauca.microkernel.app;

import co.unicauca.microkernel.servidor.infra.RestauranteServerSocket;
import java.io.UnsupportedEncodingException;;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) throws UnsupportedEncodingException {
     
        //Inicializar el plugin manager con la ruta base de la aplicación.
        try {
            
            //EL SERVIDOR NO REQUIERE DE INTERFAZ, ESTO PUEDE QUEDAR ASI
            //se crea el socket
            RestauranteServerSocket server = new RestauranteServerSocket();
            //se inicia
            server.start();

        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }

    }


}
