/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;
import co.unicauca.microkernel.client.infra.RestauranteSocket;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.infra.JsonError;
import co.unicauca.microkernel.common.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
/**
 *
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class ClienteAccessSocket implements IClienteAccess{
    /**
     * uso de un socket para comunicarse con el servidor
     */
    private RestauranteSocket mySocket;

    //el costructor crea el socket para poder comunicarse con el servidor
    public ClienteAccessSocket() {
        mySocket = new RestauranteSocket();
    }
    /**
     * establece la conexion con el servidor para una solicitud que se pasa por parametro
     * @param requestJson solicitud al servidor
     * @return verdadero si la solicitud es exitosa, false de lo contrario
     * @throws Exception 
     */
    private String procesarConexion(String requestJson)throws Exception{
        String jsonResponse = null;
        try{
            //se establece la conexion
            mySocket.connect();
            //se envia la solicitud y se recibe una respuesta,
            //(CREO)AQUI VALIDAR SI SE DIO CON EXITO LA OPERACION, SEGUN LA REPUESTA DEL SERVIDOR
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
	    if(jsonResponse.equals("FALLO")){
                return "FALLO";
            }else{
                System.out.println("todo normal");
            }
        }catch(IOException ex){
            ex.getMessage();
        }
        if(jsonResponse == null){
            throw new Exception("no se pudo conectar al servidor");
        }else{
            if (jsonResponse.contains("error")) {
                //Devolvió algún erroR, usar mejor login
                System.out.println("hubo algun tipo de error");
                throw new Exception(this.extractMessages(jsonResponse));
            } else {
                //Devuelve la respuesta del servidor
                return jsonResponse;
            }
        }
    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
     
    @Override
    public String calcularCosto(int idCliente, int idPedido)throws Exception{
        String requestJson = calcularCostoJson(idCliente,idPedido);
        String valor = this.procesarConexion(requestJson);
        if(valor.equals("FALLO")){
            return null;
        }
        return "00";
    }
    private String calcularCostoJson(int idCliente, int idPedido){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("comprador");
        protocol.setAction("calcularCosto");
        protocol.addParameter("idCliente", ""+idCliente);
        protocol.addParameter("idPedido", ""+idPedido);

        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
        return requestJson;
    }
    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPlatoEspecialJson(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return instancia.getNombre();

    }
    
    /**
     * hace un update sobre la tabla menu especial en la base de datos
     * @param clave valor con el que se encontraran coincidencias, en este caso el nombre
     * @param atributo columna que se va a modificar
     * @param valor nuevo valor a establecer
     * @return 
     */
    @Override
    public boolean updatePlatoEspecial(int clave, String atributo, String valor) throws Exception{
        //estring en formato json que se enviara al servidor
        String requestJson = updateEspecialJson(clave, atributo, valor);
         if(procesarConexion(requestJson).equals("FALLO")){
            System.out.println("devolvio fallo");
            return false;
        }
        System.out.println("devolvio ");
        return true;
    }
    
    /**
     * genera el string en el formato json para ser enviado
     * @param clave 
     * @param atributo
     * @param valor
     * @return 
     */
    private String updateEspecialJson(int clave, String atributo, String valor){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateEspecial");
        protocol.addParameter("clave", ""+clave);
        protocol.addParameter("atributo", atributo);
        protocol.addParameter("valor", valor);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
        return requestJson;
    }
    /**
     * solicitud al servidor para hacer update sobre la tabla racion
     * @param clave identificador de la racion
     * @param atributo columna a modificar
     * @param valor nuevo valor
     * @return true operacion exitosa, false de lo contrario
     * @throws Exception 
     */
     @Override
    public boolean updateRacion(int clave, String atributo, String valor) throws Exception{
        String requestJson = updateRacionJson(clave, atributo, valor);
        if(procesarConexion(requestJson).equals("FALLO")){
            return false;
        }
        return true;
    }
    /**
     * genera un string con el formato para ser enviado, con la informacion del update racion
     * @param clave
     * @param atributo
     * @param valor
     * @return 
     */
    public String updateRacionJson(int clave, String atributo, String valor){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateRacion");
        protocol.addParameter("clave", ""+clave);
        protocol.addParameter("atributo", atributo);
        protocol.addParameter("valor", valor);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
        return requestJson;
    }
    
    private String crearPlatoEspecialJson(PlatoEspecial instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postPlatoEspecial");
        protocol.addParameter("plae_id", String.valueOf(instancia.getId_pe()));
        protocol.addParameter("mene_id", String.valueOf(instancia.getMenuEsp()));
        protocol.addParameter("plae_nombre", instancia.getNombre());
        protocol.addParameter("plae_descripcion", instancia.getDescripcion());
        protocol.addParameter("plae_precio", String.valueOf(instancia.getPrecio()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }   

}