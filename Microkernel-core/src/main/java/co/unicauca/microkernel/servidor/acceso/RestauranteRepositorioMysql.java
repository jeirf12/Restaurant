/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.acceso;


import co.unicauca.microkernel.app.Application;
import co.unicauca.microkernel.business.DeliveryService;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.Restaurante;
import co.unicauca.microkernel.common.infra.Utilities;
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;
import com.google.gson.Gson;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private static String getBaseFilePath() throws UnsupportedEncodingException {
        
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

    @Override
    public String calcularCosto(int idCliente, int idPedido){
        try{
            this.connect();
            String sql = "select ped_id from pedido where CLI_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            int resultado1 = Integer.valueOf(rs.getString(1));
            ps.close();
            this.disconnect();

            this.connect();
            String sql2 = "select m.RAC_PRECIO from racionpedido r inner join raciondia m on r.racp_id=m.rac_id where r.ped_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, resultado1);
            ResultSet rs2 = ps2.executeQuery();
            int sumaPrecio = Integer.valueOf(rs2.getString(1));
            
            String basePath;
            DeliveryService deliveryService = new DeliveryService();
            try {
                basePath = getBaseFilePath();
                DeliveryPluginManager.init(basePath); 
                
                //Delivery deliveryEntity = new Delivery(sumaPrecio, 999, "mx");
                //double cost = deliveryService.calculateDeliveryCost(deliveryEntity);
                System.out.println("El costo del envío es  + cost");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }catch(SQLException ex){
            System.out.println("revento excepcion encontrar plato_:"+ex.getMessage());
            return "fallo";
        }//conexion plugin
        return null;
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
            String sql = "INSERT INTO platoespecial (PLAE_ID,MENE_ID,PLAE_NOMBRE,PLAE_FOTO,PLAE_DESCRIPCION,PLAE_PRECIO) VALUES (?,?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getId_pe());
            pstmt.setInt(2, instancia.getMenuEsp());
            pstmt.setString(3, instancia.getNombre());
            pstmt.setBytes(4, instancia.getImagen());
            pstmt.setString(5, instancia.getDescripcion());
            pstmt.setInt(6, (int) instancia.getPrecio());
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
    /**
     * Lista el menu por dias desde la consulta hecha a la base de datos 
     * añade las tuplas encontradas en una lista las raciones del dia
     * y convierte la lista en json para enviarla por el sockect devuelta
     * al cliente
     * @param idRes
     * @param dia
     * @return 
     */
    @Override
    public String listMenuDay(int idRes,String dia) {
        List<RacionDia> list=new ArrayList<>();
        String response=null;
        System.out.println("Entered the list menu day");
        try{
            this.connect();
            String sql = "select rac_id,rac_tipo,rac_precio,rac_nombre,m.mend_id,rac_foto "
                    + "from (restaurante r inner join menudia m on r.res_id=m.res_id) "
                    + "inner join raciondia p on m.mend_id=p.mend_id where r.res_id ="+idRes
                    +" and m.mend_diasem = '"+dia+"'";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {      
                RacionDia pla=  new RacionDia(Integer.parseInt(rs.getString(1)), CategoriaEnum.valueOf(rs.getString(2)), Integer.parseInt(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)),rs.getBytes(6));
                list.add(pla);
            }
            response=listMenuToJson(list);
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del dia", ex);
        }
        return response;
    }
    /**
     * Lista el menu especial desde la consulta hecha a la base de datos 
     * añade las tuplas encontradas en una lista de Plato especial
     * y convierte la lista en json para enviarla por el sockect devuelta
     * al cliente
     * @param idRes
     * @return 
     */
    @Override
    public String listMenuSpecial(int idRes) {
        List<PlatoEspecial> list=new ArrayList<>();
        String response=null;
        System.out.println("Entered the list menu Special");
        try{
            this.connect();
            String sql = "select plae_id,m.mene_id,plae_nombre,plae_descripcion,plae_precio,plae_foto from (restaurante r inner join menuespecial m on r.res_id=m.res_id) inner join platoespecial p on m.mesp_id=p.mesp_id where r.res_id = (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idRes);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {   
                
                PlatoEspecial pla = new PlatoEspecial(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)),rs.getBytes(6));
                list.add(pla);
            }
            response=listMenuToJson(list);
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del especial", ex);
        }
       return response;
    }
    
    /**
     * Convierte una lista de tipo plato en un json
     * 
     * @param list
     * @return 
     */
    public String listMenuToJson (List list){
        Gson gson=new Gson();
        String response=gson.toJson(list);
        return response;
    }

    @Override
    public String saveRestaurant(Restaurante res) {
        System.out.println("Entered the list menu Special");
        try{
            this.connect();
            String sql = "INSERT INTO restaurante (RES_ID,RES_CODIGO,RES_NOMBRE,RES_FOTO,RES_DIRECCION) values (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, res.getId());
            pstmt.setString(2, res.getCodigo());
            pstmt.setString(3, res.getNombre());
            pstmt.setBytes(4, res.getImagen());
            pstmt.setString(5, res.getDireccion());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del especial", ex);
        }
       return res.getNombre();
    }

}