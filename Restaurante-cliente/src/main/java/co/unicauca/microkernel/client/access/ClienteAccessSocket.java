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
                System.out.println("todo normal");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        if (jsonResponse == null) {
            throw new Exception("no se pudo conectar al servidor");
        } else {
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
     *
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
    public String calcularCosto(int idCliente)throws Exception{
        String requestJson = calcularCostoJson(idCliente);
        String valor = this.procesarConexion(requestJson);
        if (valor.equals("FALLO")) {
            return null;
        }
        return valor;
    }

    private String calcularCostoJson(int idCliente){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("comprador");
        protocol.setAction("calcularCosto");
        protocol.addParameter("idCliente", ""+idCliente);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: " + requestJson);
        return requestJson;
    }

    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) throws Exception {
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPlatoEspecialJson(instancia);
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
        String requestJson = updateEspecialJson(plato);
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
    private String updateEspecialJson(PlatoEspecial plato){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateEspecial");
        protocol.addParameter("clave", ""+plato.getId_pe());
        protocol.addParameter("nombre", plato.getNombre());
        protocol.addParameter("precio", ""+plato.getPrecio());
        protocol.addParameter("descripcion", plato.getDescripcion());
        protocol.addParameter("menu", ""+plato.getMenuEsp());
        protocol.addParameter("imagen", Arrays.toString(plato.getImagen()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json enviado: "+requestJson);
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
        String requestJson = updateRacionJson(racion);
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
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("administrador");
        protocol.setAction("updateRacion");
        protocol.addParameter("clave", ""+racion.getRacId());
        protocol.addParameter("nombre", racion.getNombre());
        protocol.addParameter("precio", ""+racion.getPrecio());
        protocol.addParameter("tipo", ""+racion.getTipo());
        protocol.addParameter("dia", ""+racion.getMenuId());
        protocol.addParameter("imagen", Arrays.toString(racion.getImagen()));
        
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
        protocol.addParameter("plae_foto", Arrays.toString(instancia.getImagen()));
        protocol.addParameter("plae_descripcion", instancia.getDescripcion());
        protocol.addParameter("plae_precio", String.valueOf(instancia.getPrecio()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);
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
        String requestJson = crearRacionDiaJson(instancia);
        if ((this.procesarConexion(requestJson).equals("FALLO"))) {
            return null;
        }
        return instancia.getNombre();
    }

    private String crearRacionDiaJson(RacionDia instancia) {
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("postRacionDia");
        protocol.addParameter("rac_id", String.valueOf(instancia.getRacId()));
        protocol.addParameter("mend_id", String.valueOf(instancia.getMenuId()));
        protocol.addParameter("rac_nombre", instancia.getNombre());
        protocol.addParameter("rac_foto", Arrays.toString(instancia.getImagen()));
        protocol.addParameter("rac_tipo", instancia.getTipo().toString());
        protocol.addParameter("rac_precio", String.valueOf(instancia.getPrecio()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);
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
        String respJson = deletePlatoDiaJson(rac_id);
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
        String respJson = deletePlatoEspecialJson(plae_id);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+plae_id;
    }

    private String deletePlatoDiaJson(int rac_id){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deleteRacionDia");
        protocol.addParameter("rac_id", ""+rac_id);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        
        return requestJson;
    }

    private String deletePlatoEspecialJson(int plae_id){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deletePlatoEspecial");
        protocol.addParameter("plae_id", ""+plae_id);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String addPedido(Pedido instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return String.valueOf(instancia.getEstado());

    }
    private String crearPedido(Pedido instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarPedido");
        protocol.addParameter("ped_id", String.valueOf(instancia.getIdPedido()));
        protocol.addParameter("cli_id", String.valueOf(instancia.getCliente()));
        protocol.addParameter("res_id", String.valueOf(instancia.getResId()));
        protocol.addParameter("ped_estado", String.valueOf(instancia.getEstado()));
        protocol.addParameter("ped_fecha_creado", String.valueOf(instancia.getFechaCreado()));
        protocol.addParameter("ped_fecha_pagado", String.valueOf(instancia.getFechaPagado()));
        
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
    @Override
    public String addRacionPedido(RacionPed instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearRacionPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return String.valueOf(instancia.getRacpId());

    }
    private String crearRacionPedido(RacionPed instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarRacionPedido");
        protocol.addParameter("racp_id", String.valueOf(instancia.getRacpId()));
        protocol.addParameter("ped_id", String.valueOf(instancia.getPedId()));
        protocol.addParameter("rac_id", String.valueOf(instancia.getRacId()));
        protocol.addParameter("cantidad", String.valueOf(instancia.getCantidad()));
        

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
        protocol.addParameter("res_calle", String.valueOf(restaurante.getCalle()));
        protocol.addParameter("res_carrera", String.valueOf(restaurante.getCarrera()));


        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;
    }

    @Override
    public String addPlatoEspecialPedido(PlatoEspecialPed instancia) throws Exception{
        String jsonResponse = null;
        //devuelve un string en formato Json que lo que se enviara
        String requestJson = crearPlatoEspecialPedido(instancia);
        if((this.procesarConexion(requestJson).equals("FALLO"))){
            return null;
        }
        return String.valueOf(instancia.getPlaepId());

    }
    private String crearPlatoEspecialPedido(PlatoEspecialPed instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("agregarPlatoEspecialPedido");
        protocol.addParameter("plaep_id", String.valueOf(instancia.getPlaepId()));
        protocol.addParameter("ped_id", String.valueOf(instancia.getPedId()));
        protocol.addParameter("plae_id", String.valueOf(instancia.getPlaeId()));
        protocol.addParameter("cantidad", String.valueOf(instancia.getCantidad()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    @Override
    public String deletePedido(int pedidoId) throws Exception{
        String respJson = deletePedidoJson(pedidoId);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+pedidoId;
    }
    private String deletePedidoJson(int pedidoId){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deletePedido");
        protocol.addParameter("ped_id", ""+pedidoId);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String payedPedido(Pedido pedido) throws Exception{
        String respJson = payedPedidoJson(pedido);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+pedido;
    }
    private String payedPedidoJson(Pedido pedido){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("payedPedido");
        protocol.addParameter("ped_id", String.valueOf(pedido.getIdPedido()));
        protocol.addParameter("cli_id", String.valueOf(pedido.getCliente()));
        
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String cancelPedido(Pedido pedido) throws Exception{
        String respJson = cancelPedidoJson(pedido);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+pedido;
    }
    private String cancelPedidoJson(Pedido pedido){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("cancelPedido");
        protocol.addParameter("ped_id", String.valueOf(pedido.getIdPedido()));
        protocol.addParameter("cli_id", String.valueOf(pedido.getCliente()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String deleteRacionPedido(int idRacionPedido) throws Exception{
        String respJson = deleteRacionPedidoJson(idRacionPedido);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+idRacionPedido;
    }
    private String deleteRacionPedidoJson(int idRacionPedido){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("deleteRacionPedido");
        protocol.addParameter("racp_id", ""+idRacionPedido);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    @Override
    public String deletePlatoEspecialPedido(int idPlatoEspecialPedido) throws Exception{
        String respJson = deletePlatoEspecialPedidoJson(idPlatoEspecialPedido);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+idPlatoEspecialPedido;
    }
    private String deletePlatoEspecialPedidoJson(int idPlatoEspecialPedido){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("deletePlatoEspecialPedido");
        protocol.addParameter("plaep_id", ""+idPlatoEspecialPedido);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;
    }
    /*
    
    @Override
    public boolean updatePedido(Pedido pedido) throws Exception{
        String requestJson = updatePedidoJson(pedido);
        if(procesarConexion(requestJson).equals("FALLO")){
            return false;
        }
        return true;
    }

    public String updatePedidoJson(Pedido instancia){
        Protocol protocol = new Protocol();
        //el orden debe ser respetado
        protocol.setResource("comprador");
        protocol.setAction("updatePedido");
        protocol.addParameter("ped_id", String.valueOf(instancia.getIdPedido()));
        protocol.addParameter("cli_id", String.valueOf(instancia.getCliente()));
        protocol.addParameter("res_id", String.valueOf(instancia.getResId()));
        protocol.addParameter("ped_estado", String.valueOf(instancia.getEstado()));
        protocol.addParameter("ped_fecha_creado", String.valueOf(instancia.getFechaCreado()));
        protocol.addParameter("ped_fecha_pagado", String.valueOf(instancia.getFechaPagado()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;
    }
    @Override
    public boolean updateRacionPedido(RacionPed racionPed) throws Exception{
        String requestJson = updateRacionPedidoJson(racionPed);
        if(procesarConexion(requestJson).equals("FALLO")){
            return false;
        }
        return true;
    }

    public String updateRacionPedidoJson(RacionPed instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("updateRacionPedido");
        protocol.addParameter("racp_id", String.valueOf(instancia.getRacpId()));
        protocol.addParameter("ped_id", String.valueOf(instancia.getPedId()));
        protocol.addParameter("rac_id", String.valueOf(instancia.getRacId()));
        

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    @Override
    public boolean updatePlatoEspecialPedido(PlatoEspecialPed platoEspecialPed) throws Exception{
        String requestJson = updatePlatoEspecialPedidoJson(platoEspecialPed);
        if(procesarConexion(requestJson).equals("FALLO")){
            return false;
        }
        return true;
    }

    public String updatePlatoEspecialPedidoJson(PlatoEspecialPed instancia){
        Protocol protocol = new Protocol();
        protocol.setResource("comprador");
        protocol.setAction("updatePlatoEspecialPedido");
        protocol.addParameter("plaep_id", String.valueOf(instancia.getPlaepId()));
        protocol.addParameter("ped_id", String.valueOf(instancia.getPedId()));
        protocol.addParameter("plae_id", String.valueOf(instancia.getPlaeId()));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }
    @Override
    public String deletePedido(int pedidoId) throws Exception{
        String respJson = deletePedidoJson(pedidoId);
        if(this.procesarConexion(respJson).equals("FALLO")){
            return "FALLO";
        }
        return ""+pedidoId;
    }
    private String deletePedidoJson(int pedidoId){
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("deletePedido");
        protocol.addParameter("ped_id", ""+pedidoId);
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);

        return requestJson;

    }
    
    

    }*/
    
}
