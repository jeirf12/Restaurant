/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;
import co.unicauca.microkernel.client.infra.RestauranteSocket;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.Restaurante;
import co.unicauca.microkernel.common.infra.JsonError;
import co.unicauca.microkernel.common.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
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
    /**
     * Envia el id de un restaurante y devuelve la lista llegada desde el servidor 
     * el cual transforma el json recibido desde este
     * en una lista de PLlato dia que conforma un menu por dias
     * 
     * @param idRes
     * @param diaSem
     * @param resource
     * @return
     * @throws Exception 
     */
    @Override
    public List<RacionDia> listMenuDay(int idRes,String diaSem,String resource) throws Exception {
        String accion="listMenuDay";
        String [] parameters={""+idRes,diaSem};
        String requestJson = createlistMenuJson(resource,accion,parameters);
        String response=procesarConexion(requestJson);
        return jsonListMenuDay(response);
    }
    
    /**
     * Envia el id de un restaurante y devuelve la lista llegada desde el servidor 
     * el cual transforma el json recibido desde este
     * en una lista de PlatoEspecial que conforma un menu especial
     * 
     * @param idRes
     * @param resource
     * @return
     * @throws Exception 
     */
    @Override
    public List<PlatoEspecial> listMenuSpecial(int idRes,String resource) throws Exception {
        String accion="listMenuSpecial";
        String [] parameters={""+idRes};
        String requestJson = createlistMenuJson(resource,accion,parameters);
        String response= procesarConexion(requestJson);
        return jsonListMenuSpecial(response);
    }
    /**
     * Crea el plato recibido en un json para el envio por el sockect al servidor
     * 
     * @param resource
     * @param accion
     * @param resId
     * @return 
     */
    private String createlistMenuJson(String resource,String accion,String[] parameters){
        Protocol protocol=new Protocol();
        protocol.setResource(resource);
        protocol.setAction(accion);
        protocol.addParameter("resId", String.valueOf(parameters[0]));
        if (accion.equals("listMenuDay")) {
            protocol.addParameter("DiaSemana", parameters[1]);
        }
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    /**
     * Convierte un json en una lista de tipo plato dia
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<RacionDia> jsonListMenuDay(String jsonListarMenu){
        Gson gson=new Gson();
        Type list = new TypeToken<List<RacionDia>>(){}.getType();
        return gson.fromJson(jsonListarMenu, list);
    }
    
    /**
     * Convierte un json en una lista de tipo plato especial
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<PlatoEspecial> jsonListMenuSpecial(String jsonListMenu){
        Gson gson=new Gson();
        Type list = new TypeToken<List<PlatoEspecial>>(){}.getType();
        return gson.fromJson(jsonListMenu, list);
    }

    @Override
    public String saveRestaurant(Restaurante restaurant) throws Exception {
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = createRestaurantJson(restaurant);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return restaurant.getNombre();
    }
    private String createRestaurantJson(Restaurante restaurante){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postRestaurant");
        protocol.addParameter("res_id", String.valueOf(restaurante.getId()));
        protocol.addParameter("res_codigo", String.valueOf(restaurante.getCodigo()));
        protocol.addParameter("res_nombre", restaurante.getNombre());
        protocol.addParameter("res_foto", Arrays.toString(restaurante.getImagen()));
        protocol.addParameter("res_direccion", restaurante.getDireccion());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
}