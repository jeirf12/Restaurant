/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.infra;

import co.unicauca.microkernel.common.entities.*;
import co.unicauca.microkernel.common.infra.JsonError;
import co.unicauca.microkernel.common.infra.Protocol;
import co.unicauca.microkernel.common.infra.Utilities;
import co.unicauca.microkernel.servidor.acceso.FabricaRepositorio;
import co.unicauca.microkernel.servidor.dominio.servidor.PlatoServicio;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.unicauca.microkernel.servidor.acceso.IPlatoRepositorio;
import java.time.LocalDateTime;

/**
 * esta clase se encarga de establecer y gestionar la conexion entre el servidor
 * y los clientes
 *
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class RestauranteServerSocket implements Runnable {

    /**
     * servicio del plato, continene el mecanismo para comunicar platoD la base
     * de datos y sus operaciones
     */
    private final PlatoServicio service; //se debe iniciializar obligatorioamente
    /**
     * servicio para el socket, "orejita"
     */
    private static ServerSocket ssock;
    /**
     * socket por donde se hace la peticion/respuesta
     */
    private static Socket socket;
    /**
     * permite leer un flujo de datos del socket
     */
    private Scanner input;
    /**
     * permite escibir un flujo de datos en el socket
     */
    private PrintStream output;
    /**
     * Puerto por donde se escucha el server socket
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * constructor obtiene el servidor mediante la fabrica instancia platoD
     * servicio pasando el repositorio obtenido
     */
    public RestauranteServerSocket() {
        //inyeccion de dependencias par hacer la inyeccion
        IPlatoRepositorio repository = FabricaRepositorio.getInstance().getRepository();
        service = new PlatoServicio(repository);
    }

    /**
     * instancia el server socket y abre el puerto respectivo
     */
    private static void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * estpera platoD que el cliente se conecte y devuelve un socket
     */
    private static void waitToClient() {
        try {
            //en este punto el socket espera platoD que accept reciba una conexion
            socket = ssock.accept();
            //informara si hubo conexion
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }

    /**
     * lanza el hilo, un hilo individual atendera platoD el cliente
     */
    private static void throwThread() {
        new Thread(new RestauranteServerSocket()).start();
    }

    /**
     * arranca el servidor y hace la estructura completa
     */
    public void start() {
        openPort();
        while (true) {
            waitToClient();
            throwThread();
        }
    }

    /**
     * hilo que atiende platoD un cliente
     */
    @Override
    public void run() {
        try {
            //crea el flujo de datos, inicializa input y output, entrada y salida de datos
            createStreams();
            //crea el flujo de datos para la lectura del socket
            readStream();
            //cierra flujo
            closeStream();
        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * crea o inicializa los atributos encargados de leer y escribir, flujos con
     * el socket
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * lee el flujo del socket
     */
    private void readStream() {
        if (input.hasNextLine()) {//verifica si hay contenido en el flujo de entrada
            String request = input.nextLine();
            processRequest(request);
        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    //----------------SOLO MODIFICAR DESDE AQUI--------------------------------------
    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud platoD objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        //saca de request la persona que ha hecho la solicitud, en nuestro caso administrador o comprador
        switch (protocolRequest.getResource()) {
            case "administrador":

                //funciona exactamente igual platoD postPlatoDia
                if (protocolRequest.getAction().equals("postPlatoEspecial")) {
                    administradorRegistrarPlatoEspecial(protocolRequest);
                }

                if (protocolRequest.getAction().equals("updateEspecial")) {
                    administradorUpdateEspecial(protocolRequest);
                }

                if (protocolRequest.getAction().equals("updateRacion")) {
                    administradorUpdateRacion(protocolRequest);
                }

                //
                if (protocolRequest.getAction().equals("deleteRacionDia")) {
                    administradordeleteRacionDia(protocolRequest);
                }
                //
                if (protocolRequest.getAction().equals("deletePlatoEspecial")) {
                    administradordeletePlatoEspecial(protocolRequest);
                }
     
                if (protocolRequest.getAction().equals("listMenuDay")) {
                    this.listarMenuDia(protocolRequest);
                }
                if (protocolRequest.getAction().equals("listMenuSpecial")) {
                    this.listarMenuEspecial(protocolRequest);
                }
                if (protocolRequest.getAction().equals("postRestaurant")) {
                    this.administradorRestaurante(protocolRequest);
                }

                if(protocolRequest.getAction().equals("postRacionDia")){
                    administradorRegistrarRacionDia(protocolRequest);   
                }
                
                if (protocolRequest.getAction().equals("listMenuDayAll")) {
                    this.listarMenuDiaTodos(protocolRequest);
                }

                break;

            //comprador solo tendra la opcion de visualizar, es decir un selec sobre la base de datos y enviarlos platoD cliente
            case "comprador":

                if (protocolRequest.getAction().equals("calcularCosto")) {
                    this.administrarCalcularCosto(protocolRequest);
                }

                if (protocolRequest.getAction().equals("listarMenuDia")) {
                    this.listarMenuDia(protocolRequest);
                }
                if (protocolRequest.getAction().equals("listarMenuEspecial")) {
                    this.listarMenuEspecial(protocolRequest);
                }

                if (protocolRequest.getAction().equals("agregarPedido")) {
                    this.administradorAddPedido(protocolRequest);
                }
                if (protocolRequest.getAction().equals("agregarRacionPedido")) {
                    this.administradorAddRacionPedido(protocolRequest);
                }
                if (protocolRequest.getAction().equals("agregarPlatoEspecialPedido")) {
                    this.administradorAddPlatoEspecialPedido(protocolRequest);
                }

                if (protocolRequest.getAction().equals("listMenuDayAll")) {
                    this.listarMenuDiaTodos(protocolRequest);
                }
                
                break;
                
            case "sistema":
             if (protocolRequest.getAction().equals("validarAcceso")) {
                    this.validarAcceso(protocolRequest);
                }
             break;

        }

    }

    /**
     * recibe un protocolo con la informacion necesarioa para modificar el plato
     * del dia en la base de datos.
     *
     * @param protocol protocolo en formato Json
     */
    private void administradorUpdateRacion(Protocol protocol) {
        RacionDia racion = new RacionDia();
        racion.setRacId(Integer.parseInt(protocol.getParameters().get(0).getValue()));
        racion.setNombre(protocol.getParameters().get(1).getValue());
        racion.setPrecio(Integer.parseInt(protocol.getParameters().get(2).getValue()));
        racion.setTipo(CategoriaEnum.valueOf(protocol.getParameters().get(3).getValue()));
        racion.setMenuId(Integer.parseInt(protocol.getParameters().get(4).getValue()));
        racion.setImagen(protocol.getParameters().get(5).getValue().getBytes());

        String response = null;
        response = service.updateRacion(racion);
        output.println(response);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "response: " + response);
    }

    /**
     * recibe un protocolo con la informacion necesarioa para modificar el plato
     * especial en la base de datos.
     *
     * @param protocol
     */
    private void administradorUpdateEspecial(Protocol protocol) {
        PlatoEspecial plato = new PlatoEspecial();
        plato.setId_pe(Integer.parseInt(protocol.getParameters().get(0).getValue()));
        plato.setNombre(protocol.getParameters().get(1).getValue());
        plato.setPrecio(Integer.parseInt(protocol.getParameters().get(2).getValue()));
        plato.setDescripcion(protocol.getParameters().get(3).getValue());
        plato.setMenuEsp(Integer.parseInt(protocol.getParameters().get(4).getValue()));
        plato.setImagen(protocol.getParameters().get(5).getValue().getBytes());
        String response = null;
        response = service.updatePlatoEspecial(plato);
        output.println(response);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "response: " + response);
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Cliente no encontrado. Cédula no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    private void administrarCalcularCosto(Protocol protocolRequest) {
        int idCliente = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());

        String response = null;
        response = service.calcularCosto(idCliente);
        output.println(response);
        Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "response: " + response + " idCliente:" + idCliente);
    }

    private void administradorRegistrarPlatoEspecial(Protocol protocolRequest) {
        //crea la instancia
        PlatoEspecial platoE = new PlatoEspecial();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        platoE.setId_pe(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        platoE.setMenuEsp(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        platoE.setNombre(protocolRequest.getParameters().get(2).getValue());
        platoE.setImagen(protocolRequest.getParameters().get(3).getValue().getBytes());
        platoE.setDescripcion(protocolRequest.getParameters().get(4).getValue());
        platoE.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(5).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.savePlatoEspecial(platoE);
        output.println(response);
    }

    private void administradorAddPedido(Protocol protocolRequest) {
        //crea la instancia
        Pedido pedido = new Pedido();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        pedido.setIdPedido(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        pedido.setCliente(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        pedido.setResId(Integer.parseInt(protocolRequest.getParameters().get(2).getValue()));
        pedido.setEstado(EstadoPed.valueOf(protocolRequest.getParameters().get(3).getValue()));
        pedido.setFecha(LocalDateTime.parse(protocolRequest.getParameters().get(4).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response = null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.addPedido(pedido);
        output.println(response);
    }

    private void administradorAddRacionPedido(Protocol protocolRequest) {
        //crea la instancia
        RacionPed racionPedido = new RacionPed();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        racionPedido.setRacpId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        racionPedido.setPedId(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response = null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.addRacionPedido(racionPedido);
        output.println(response);
    }

    private void administradorAddPlatoEspecialPedido(Protocol protocolRequest) {

        PlatoEspecialPed platoEspecialPed = new PlatoEspecialPed();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        platoEspecialPed.setPlaepId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        platoEspecialPed.setPedId(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response = null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.addPlatoEspecialPedido(platoEspecialPed);
        output.println(response);
    }

    private void administradorRegistrarRacionDia(Protocol protocolRequest) {
        //crea la instancia
        RacionDia racionD = new RacionDia();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        racionD.setRacId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        racionD.setMenuId(Integer.parseInt(protocolRequest.getParameters().get(1).getValue()));
        racionD.setNombre(protocolRequest.getParameters().get(2).getValue());
        racionD.setImagen(protocolRequest.getParameters().get(3).getValue().getBytes());
        racionD.setTipo(CategoriaEnum.valueOf(protocolRequest.getParameters().get(4).getValue()));
        racionD.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(5).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.saveRacionDia(racionD);
        output.println(response);
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }/*NO VEO LA NECESIDAD DE ESTE NO SE USA EN NINGUNA PARTE
    
    private String objectToJSONAlimento(PlatoEspecial customer) {
        Gson gson = new Gson();
        String strObject = gson.toJson(customer);
        return strObject;
    }*/
    private void administradordeleteRacionDia(Protocol protocolRequest) {
        //creo el id de la racion
        int rac_id;
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        rac_id = (Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response = null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.deleteRacionDia(rac_id);
        output.println(response);
    }

    private void administradordeletePlatoEspecial(Protocol protocolRequest) {
        //creo el id de la racion
        int plae_id;
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        plae_id = (Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        String response = null;
        //el servicio comunicara con la base de datos,
        //se pasa el plato creado, y servicio llamara al repositorio
        response = service.deletePlatoEspecial(plae_id);
        output.println(response);
    }

    /**
     * Recibe la peticion del cliente, manda el id del restaurante y manda esta
     * peticion procesada al repositorio del servidor para el menu por dias
     *
     * @param protocolRequest
     */
    private void listarMenuDia(Protocol protocolRequest) {
        int resId = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String diaSem = protocolRequest.getParameters().get(1).getValue();
        String response;
        response = service.listMenuDay(resId, diaSem);
        output.println(response);

    }

    /**
     * Recibe la peticion del cliente, manda el id del restaurante y manda esta
     * peticion procesada al repositorio del servidor para el menu especial
     *
     * @param protocolRequest
     */
    private void listarMenuEspecial(Protocol protocolRequest) {
        int resdId = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response;
        response = service.listMenuSpecial(resdId);
        output.println(response);
    }

    private void administradorRestaurante(Protocol protocolRequest) {
        //crea la instancia
        Restaurante res = new Restaurante();
        //se asignan los atributos de la instancia, segun los valores de los parametros
        //el orden debe ser exacto
        res.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        res.setCodigo(protocolRequest.getParameters().get(1).getValue());
        res.setNombre(protocolRequest.getParameters().get(2).getValue());
        res.setImagen(protocolRequest.getParameters().get(3).getValue().getBytes());
        res.setDireccion(protocolRequest.getParameters().get(4).getValue());
        //hacer validacion para esta, es decir sobre el parseo del dato
        String response = null;
        //el servicio comunicara con la base de datos,
        response = service.saveRestaurant(res);
        output.println(response);

    }

    private void validarAcceso(Protocol protocolRequest) {
        Cliente cli = new Cliente();
        cli.setNombre(protocolRequest.getParameters().get(0).getValue());
        cli.setContrasenia(protocolRequest.getParameters().get(1).getValue());
        String response;
        response = service.validarAcceso(cli);
        output.println(response);

    }

 
    /**
     * Recibe la peticion del cliente, manda el id del restaurante
     * y manda esta peticion procesada al repositorio del servidor
     * para el menu por dias todos
     * 
     * @param protocolRequest 
     */
    private void listarMenuDiaTodos(Protocol protocolRequest){
        int resId =Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String response;
        response=service.listMenuDayAll(resId);
        output.println(response); 
    }
}

