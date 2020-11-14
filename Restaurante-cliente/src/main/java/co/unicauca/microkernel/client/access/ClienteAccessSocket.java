/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;

import co.unicauca.microkernel.client.infra.RestauranteSocket;
import co.unicauca.microkernel.common.entities.*;
import co.unicauca.microkernel.common.infra.JsonError;
import co.unicauca.microkernel.common.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.System.out;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class ClienteAccessSocket implements IClienteAccess {

    /**
     * uso de un socket para comunicarse con el servidor
     */
    private RestauranteSocket mySocket;

    //el costructor crea el socket para poder comunicarse con el servidor
    public ClienteAccessSocket() {
        mySocket = new RestauranteSocket();
    }

    /**
     * establece la conexion con el servidor para una solicitud que se pasa por
     * parametro
     *
     * @param requestJson solicitud al servidor
     * @return verdadero si la solicitud es exitosa, false de lo contrario
     * @throws Exception
     */
    private String procesarConexion(String requestJson) throws Exception {
        String jsonResponse = null;
        try {
            //se establece la conexion
            mySocket.connect();
            //se envia la solicitud y se recibe una respuesta,
            //(CREO)AQUI VALIDAR SI SE DIO CON EXITO LA OPERACION, SEGUN LA REPUESTA DEL SERVIDOR
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
            if (jsonResponse.equals("FALLO")) {
                return "FALLO";
            } else {
                out.println("todo normal");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        if (jsonResponse == null) {
            throw new Exception("no se pudo conectar al servidor");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún erroR, usar mejor login
                out.println("hubo algun tipo de error");
                throw new Exception(this.extractMessages(jsonResponse));
            } else {
                //Devuelve la respuesta del servidor
                return jsonResponse;
            }
        }
    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        var errors = jsonToErrors(jsonResponse);
        var msjs = "";
        for (var error : errors) {
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
        var gson = new Gson();
        var error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    @Override
    public String calcularCosto(int idCliente)throws Exception{
        var requestJson = calcularCostoJson(idCliente);
        var valor = this.procesarConexion(requestJson);
        if (valor.equals("FALLO")) {
            return null;
        }
        return valor;
    }

    private String calcularCostoJson(int idCliente){
        var protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("comprador");
        protocol.setAction("calcularCosto");
        protocol.addParameter("idCliente", ""+idCliente);
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json enviado: " + requestJson);
        return requestJson;
    }

    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) throws Exception {
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = crearPlatoEspecialJson(instancia);
        if ((this.procesarConexion(requestJson).equals("FALLO"))) {
            return null;
        }
        return instancia.getNombre();

    }

    
    /**
     * hace un update sobre la tabla menu especial en la base de datos
     * @param plato informacion del plato a actualizar
     * @return 
     */
    @Override
    public boolean updatePlatoEspecial(PlatoEspecial plato) throws Exception{
        //estring en formato json que se enviara al servidor
        var requestJson = updateEspecialJson(plato);
         if(procesarConexion(requestJson).equals("FALLO")){
            out.println("devolvio fallo");
            return false;
        }
        out.println("devolvio ");
        return true;
    }
    
    /**
     * genera el string en el formato json para ser enviado
     * @param clave 
     * @param atributo
     * @param valor
     * @return 
     */
    private String updateEspecialJson(PlatoEspecial plato){
        var protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateEspecial");
        protocol.addParameter("clave", ""+plato.getId_pe());
        protocol.addParameter("nombre", plato.getNombre());
        protocol.addParameter("precio", ""+plato.getPrecio());
        protocol.addParameter("descripcion", plato.getDescripcion());
        protocol.addParameter("menu", ""+plato.getMenuEsp());
        protocol.addParameter("imagen", Arrays.toString(plato.getImagen()));
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json enviado: "+requestJson);
        return requestJson;
    }
    /**
     * solicitud al servidor para hacer update sobre la tabla racion
     * @param racion informacion a modificar
     * @return true operacion exitosa, false de lo contrario
     * @throws Exception 
     */
     @Override
    public boolean updateRacion(RacionDia racion) throws Exception{
        var requestJson = updateRacionJson(racion);
        if(procesarConexion(requestJson).equals("FALLO")){
            return false;
        }
        return true;
    }
    /**
     * genera un string con el formato para ser enviado, con la informacion del update racion
     * @param racion objeto a convertir
     * @return 
     */
    public String updateRacionJson(RacionDia racion){
        var protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateRacion");
        protocol.addParameter("clave", ""+racion.getRacId());
        protocol.addParameter("nombre", racion.getNombre());
        protocol.addParameter("precio", ""+racion.getPrecio());
        protocol.addParameter("tipo", ""+racion.getTipo());
        protocol.addParameter("dia", ""+racion.getMenuId());
        protocol.addParameter("imagen", Arrays.toString(racion.getImagen()));
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json enviado: "+requestJson);
        return requestJson;
    }
    
    private String crearPlatoEspecialJson(PlatoEspecial instancia){
        var protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postPlatoEspecial");
        protocol.addParameter("plae_id", valueOf(instancia.getId_pe()));
        protocol.addParameter("mene_id", valueOf(instancia.getMenuEsp()));
        protocol.addParameter("plae_nombre", instancia.getNombre());
        protocol.addParameter("plae_foto", Arrays.toString(instancia.getImagen()));
        protocol.addParameter("plae_descripcion", instancia.getDescripcion());
        protocol.addParameter("plae_precio", valueOf(instancia.getPrecio()));

        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: " + requestJson);
        return requestJson;
    }

    /**
     *
     * @param instancia
     * @return
     * @throws Exception
     */
    @Override
    public String saveRacionDia(RacionDia instancia) throws Exception {
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = crearRacionDiaJson(instancia);
        if ((this.procesarConexion(requestJson).equals("FALLO"))) {
            return null;
        }
        return instancia.getNombre();
    }

    private String crearRacionDiaJson(RacionDia instancia) {
        var protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postRacionDia");
        protocol.addParameter("rac_id", valueOf(instancia.getRacId()));
        protocol.addParameter("mend_id", valueOf(instancia.getMenuId()));
        protocol.addParameter("rac_nombre", instancia.getNombre());
        protocol.addParameter("rac_foto", Arrays.toString(instancia.getImagen()));
        protocol.addParameter("rac_tipo", instancia.getTipo().toString());
        protocol.addParameter("rac_precio", valueOf(instancia.getPrecio()));

        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: " + requestJson);
        return requestJson;
    }   


    /**
     *
     * @param rac_id
     * @return
     * @throws Exception
     */
    @Override
    public String deleteRacionDia(int rac_id) throws Exception{
        var respJson = deletePlatoDiaJson(rac_id);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+rac_id;
    }

    /**
     *
     * @param plae_id
     * @return
     * @throws Exception
     */
    @Override
    public String deletePlatoEspecial(int plae_id) throws Exception{
        var respJson = deletePlatoEspecialJson(plae_id);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+plae_id;
    }

    private String deletePlatoDiaJson(int rac_id){
        var protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deleteRacionDia");
        protocol.addParameter("rac_id", ""+rac_id);
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);
        
        return requestJson;
    }

    private String deletePlatoEspecialJson(int plae_id){
        var protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deletePlatoEspecial");
        protocol.addParameter("plae_id", ""+plae_id);
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String addPedido(Pedido instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = crearPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return valueOf(instancia.getEstado());

    }
    private String crearPedido(Pedido instancia){
        var protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarPedido");
        protocol.addParameter("ped_id", valueOf(instancia.getIdPedido()));
        protocol.addParameter("cli_id", valueOf(instancia.getCliente()));
        protocol.addParameter("res_id", valueOf(instancia.getResId()));
        protocol.addParameter("ped_estado", valueOf(instancia.getEstado()));
        protocol.addParameter("ped_fecha", valueOf(instancia.getFecha()));
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);

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
        var accion="listMenuDay";
        String [] parameters={""+idRes,diaSem};
        var requestJson = createlistMenuJson(resource,accion,parameters);
        var response=procesarConexion(requestJson);
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
        var accion="listMenuSpecial";
        String [] parameters={""+idRes};
        var requestJson = createlistMenuJson(resource,accion,parameters);
        var response= procesarConexion(requestJson);
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
        var protocol=new Protocol();
        protocol.setResource(resource);
        protocol.setAction(accion);
        protocol.addParameter("resId", valueOf(parameters[0]));
        if (accion.equals("listMenuDay")) {
            protocol.addParameter("DiaSemana", parameters[1]);
        }
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);

        
        return requestJson;
    }
    @Override
    public String addRacionPedido(RacionPed instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = crearRacionPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return valueOf(instancia.getRacpId());

    }
    private String crearRacionPedido(RacionPed instancia){
        var protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarRacionPedido");
        protocol.addParameter("racp_id", valueOf(instancia.getRacpId()));
        protocol.addParameter("ped_id", valueOf(instancia.getPedId()));
        protocol.addParameter("rac_id", valueOf(instancia.getRacId()));
        

        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);
        return requestJson;
    }

    /**
     * Convierte un json en una lista de tipo plato dia
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<RacionDia> jsonListMenuDay(String jsonListarMenu){
        var gson=new Gson();
        var list = new TypeToken<List<RacionDia>>(){}.getType();
        return gson.fromJson(jsonListarMenu, list);
    }
    
    /**
     * Convierte un json en una lista de tipo plato especial
     * 
     * @param jsonListarMenu
     * @return 
     */
    private List<PlatoEspecial> jsonListMenuSpecial(String jsonListMenu){
        var gson=new Gson();
        var list = new TypeToken<List<PlatoEspecial>>(){}.getType();
        return gson.fromJson(jsonListMenu, list);
    }

    @Override
    public String saveRestaurant(Restaurante restaurant) throws Exception {
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = createRestaurantJson(restaurant);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return restaurant.getNombre();
    }
    private String createRestaurantJson(Restaurante restaurante){
        var protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postRestaurant");
        protocol.addParameter("res_id", valueOf(restaurante.getId()));
        protocol.addParameter("res_codigo", valueOf(restaurante.getCodigo()));
        protocol.addParameter("res_nombre", restaurante.getNombre());
        protocol.addParameter("res_foto", Arrays.toString(restaurante.getImagen()));
        protocol.addParameter("res_direccion", restaurante.getDireccion());

        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);

        return requestJson;
    }

    @Override
    public String addPlatoEspecialPedido(PlatoEspecialPed instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        var requestJson = crearRacionPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return valueOf(instancia.getPlaepId());

    }
    private String crearRacionPedido(PlatoEspecialPed instancia){
        var protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarPlatoEspecialPedido");
        protocol.addParameter("plaep_id", valueOf(instancia.getPlaepId()));
        protocol.addParameter("ped_id", valueOf(instancia.getPedId()));
        protocol.addParameter("plae_id", valueOf(instancia.getPlaeId()));
        
        var gson = new Gson();
        var requestJson = gson.toJson(protocol);
        out.println("json: "+requestJson);
        return requestJson;
    }

}
