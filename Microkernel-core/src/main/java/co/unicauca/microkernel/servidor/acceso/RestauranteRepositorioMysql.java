/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.acceso;


import co.unicauca.microkernel.app.Application;
import co.unicauca.microkernel.business.DeliveryService;
import co.unicauca.microkernel.common.entities.*;
import co.unicauca.microkernel.common.infra.Utilities;
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * objeto concreto de un repositorio, en este caso un repositorio de mysql
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class RestauranteRepositorioMysql implements IPlatoRepositorio{
    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositorioMysql(){

    }
    private boolean findPlatoEspecial(int id){
        boolean resultado;
        try{
            this.connect();
            String sql = "select plae_nombre from platoespecial where PLAE_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            resultado = rs.next();
            ps.close();
            this.disconnect();
            return resultado;
        }catch(SQLException ex){
            System.out.println("revento excepcion encontrar plato especial_:"+ex.getMessage());
            return false;
        }
    }
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            //estos datos estan quemados en el archivo propertis, si la base de datos cambia propertis debe modificarse
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username"); //usuario de la base de datos
            String pwd = Utilities.loadProperty("server.db.password");//contraseña de usuario
            //se establece la coneccion con los datos previos
            conn = DriverManager.getConnection(url, username, pwd);
            if(conn == null){
                System.out.println("coneccion fallida a la base de datos");
            }else{
                System.out.println("conecion exitosa a la base de datos");
            }
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }
    private static String getBaseFilePath(){
        try{
        String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters
        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();

            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }

        }

        return path;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public String calcularCosto(int idCliente){
        double cost = 0;
        int total =0;
        int sumaRaciones = 0;
        int sumaPlatosE = 0;
        
            sumaRaciones = this.sumaRaciones(idCliente);
            sumaPlatosE = this.sumaPlatos(idCliente);
            
            total = sumaRaciones+sumaPlatosE;
        try {    
            String basePath = getBaseFilePath();
            DeliveryService deliveryService = new DeliveryService();
            
            DeliveryPluginManager.init(basePath);
            Delivery deliveryEntity = new Delivery(total, 999, "or");
            cost = deliveryService.calculateDeliveryCost(deliveryEntity);
            
            return ""+cost;
        } catch (Exception ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @Override
    public String savePlatoEspecial(PlatoEspecial instancia) {
        try{
 //           if (findPlatoEspecial(instancia.getId_pe()))
 //           {
//                return "FALLO";
//            }
            System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO platoespecial(PLAE_ID,MENE_ID,PLAE_NOMBRE,PLAE_DESCRIPCION,PLAE_PRECIO) VALUES (?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getId_pe());
            pstmt.setInt(2, instancia.getMenuEsp());
            pstmt.setString(3, instancia.getNombre());
            pstmt.setString(4, instancia.getDescripcion());
            pstmt.setInt(5, (int) instancia.getPrecio());
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        //lo ideal es retornor un id
        return instancia.getNombre();
    }
    @Override
    public String addPedido(Pedido instancia){
        try{
        System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO pedido (PED_ID,CLI_ID,RES_ID,PED_FECHA) VALUES (?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setString(1, null);
            pstmt.setInt(2, instancia.getCliente());
            pstmt.setInt(3, instancia.getResId());
            pstmt.setDate(4, java.sql.Date.valueOf(instancia.getFecha().toLocalDate()));
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            
        }
        return null;//lo ideal es retornor un id
        
        
    }
    @Override
    public String addRacionPedido(RacionPed instancia){
        try{
        System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO racionpedido (RACP_ID,PED_ID) VALUES (?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getRacpId());
            pstmt.setInt(2, instancia.getPedId());
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            
        }
        return null;//lo ideal es retornor un id
        
        
    }
    @Override
    public String addPlatoEspecialPedido(PlatoEspecialPed instancia){
        try{
        System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO platoespecialpedido (PLAEP_ID,PED_ID) VALUES (?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getPlaepId());
            pstmt.setInt(2, instancia.getPedId());
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            
        }
        return null;
    }
    public int sumaRaciones(int idCliente){
        int sumaRaciones=0;
        try{
            this.connect();
            String sqlRacion =
            "select sum(racd.RAC_PRECIO)"
            + " from pedido ped INNER JOIN racionpedido racp on ped.PED_ID = racp.PED_ID"
            + " INNER JOIN raciondia racd on racp.RAC_ID = racd.RAC_ID"
            + " where ped.CLI_ID ="+idCliente+" AND ped.PED_ESTADO LIKE 'CREADO'";
            
            PreparedStatement ps1 = conn.prepareStatement(sqlRacion);
            ResultSet rs1 = ps1.executeQuery();
            
            while (rs1.next()){
                sumaRaciones = rs1.getInt(1);
            }
            
            ps1.close();
            this.disconnect();
 
        }catch(SQLException ex){
            System.out.println("algo:"+ex.getMessage());

        }
        return sumaRaciones;
    }
    public int sumaPlatos(int idCliente){
        int sumaPlatos=0;
        try{
            this.connect();
            String sqlRacion = 
            "select sum(pe.PLAE_PRECIO)"
            + " from pedido ped INNER JOIN platoespecialpedido paep on ped.PED_ID = paep.PED_ID"
            + " INNER JOIN platoespecial pe on paep.PLAE_ID = pe.PLAE_ID"
            + " where ped.CLI_ID ="+idCliente+" AND ped.PED_ESTADO LIKE 'CREADO'";

            PreparedStatement ps1 = conn.prepareStatement(sqlRacion);
            ResultSet rs1 = ps1.executeQuery();
            
            while (rs1.next()){
                sumaPlatos = rs1.getInt(1);
            }

            ps1.close();
            this.disconnect();
 
        }catch(SQLException ex){
            System.out.println("algo:"+ex.getMessage());

        }
        return sumaPlatos;
    }
    
}