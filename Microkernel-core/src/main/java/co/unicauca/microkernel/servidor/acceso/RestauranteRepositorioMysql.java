package co.unicauca.microkernel.servidor.acceso;


import co.unicauca.microkernel.app.Application;
import co.unicauca.microkernel.business.DeliveryService;
import co.unicauca.microkernel.common.entities.*;
import co.unicauca.microkernel.common.infra.Utilities;
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;
import com.google.gson.Gson;
import java.io.File;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * objeto concreto de un repositorio, en este caso un repositorio de mysql
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
//AUTO_INCREMENT
public class RestauranteRepositorioMysql implements IPlatoRepositorio{
    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositorioMysql(){

    }
    private boolean findRacionDia(int id){
        boolean resultado;
        try{
            this.connect();
            String sql = "select rac_nombre from raciondia where RAC_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            resultado = rs.next();
            ps.close();
            this.disconnect();
            return resultado;
        }catch(SQLException ex){
            System.out.println("revento excepcion encontrar racion_:"+ex.getMessage());
            return false;
        }
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
    
    /**
     * actualiza un item plato especial en la base de datos
     * @param plato informacion del plato espeial a modificar
     * @return retorna "FALLO" si el metodo erra
     */
    @Override
    public String updatePlatoEspecial(PlatoEspecial plato){
        if(!this.findPlatoEspecial(plato.getId_pe())){
            return "FALLO";
        }
        try{
            this.connect();
            String sql = "UPDATE platoespecial SET MENE_ID = ?, PLAE_NOMBRE = ?, PLAE_FOTO = ?, PLAE_DESCRIPCION = ?, PLAE_PRECIO = ? WHERE PLAE_ID = ?";
            //String sql = "UPDATE platoespecial SET "+atributo+" = ? WHERE PLAE_ID = ?";
            System.out.println("SENTENCIA SQL UPDATE PLATO ESPECIAL: "+sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, plato.getMenuEsp());
            pstmt.setString(2, plato.getNombre());
            pstmt.setBytes(3, plato.getImagen());
            pstmt.setString(4, plato.getDescripcion());
            pstmt.setInt(5, plato.getPrecio());
            pstmt.setInt(6, plato.getId_pe());
            pstmt.executeUpdate();
            
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "FALLO";
        }
        return plato.getNombre();
    }
    
    /**
     * actualiza un item de racion en la base de datos.
     * @param racion informacion a modificar
     * @return retorna "FALLO" si erra el metodo, identificador de lo contrario.
     */
    @Override
    public String updateRacion(RacionDia racion){
        if(!this.findRacionDia(racion.getRacId())){
            return "FALLO";
        }
        try{
            this.connect();
            //String sql = "UPDATE platoespecial set "+atributo+" = "+valor+" WHERE PESP_NOMBRE = "+clave;
            String sql = "UPDATE raciondia SET MEND_ID = ?, RAC_NOMBRE = ?, RAC_FOTO = ?, RAC_TIPO = ?, RAC_PRECIO = ? WHERE RAC_ID = ?";
            System.out.println("SENTENCIA SQL UPDATE RACION: "+sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, racion.getMenuId());
            pstmt.setString(2, racion.getNombre());
            pstmt.setBytes(3, racion.getImagen());
            pstmt.setString(4, racion.getTipo().toString());
            pstmt.setInt(5, racion.getPrecio());
            pstmt.setInt(6, racion.getRacId());
            
            pstmt.executeUpdate();
            
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "FALLO";
        }
        return racion.getNombre();
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
            String sql = "INSERT INTO platoespecial (MENE_ID,PLAE_NOMBRE,PLAE_FOTO,PLAE_DESCRIPCION,PLAE_PRECIO) VALUES (?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getMenuEsp());
            pstmt.setString(2, instancia.getNombre());
            pstmt.setBytes(3, instancia.getImagen());
            pstmt.setString(4, instancia.getDescripcion());
            pstmt.setInt(5, (int) instancia.getPrecio());
            //se ejecuta la sentencia sql
            //reversar a update por si algo----------------
            pstmt.execute();
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
    public String saveRacionDia(RacionDia instancia,int idRestaurante) {
      try{
       //    if (findRacion(instancia.getRacId()))
 //           {
//                return "FALLO";
//            }
            System.out.println("entro");
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            /*
                    protocol.addParameter("mend_id", valueOf(instancia.getMenuId()));
        protocol.addParameter("rac_nombre", instancia.getNombre());
        protocol.addParameter("rac_foto", Arrays.toString(instancia.getImagen()));
        protocol.addParameter("rac_tipo", instancia.getTipo().toString());
        protocol.addParameter("rac_precio", valueOf(instancia.getPrecio()));
            */
            //se estructura la sentencia sql en un string
            String sql = "INSERT INTO raciondia(MEND_ID,RES_ID,RAC_NOMBRE,RAC_FOTO,RAC_TIPO,RAC_PRECIO) VALUES (?,?,?,?,?,?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se registra cada elemento, OJO Ddebe cumplir estrictamente el orden y el tipo de dato
            pstmt.setInt(1, instancia.getMenuId());
            pstmt.setInt(2, idRestaurante);
            pstmt.setString(3, instancia.getNombre());
            pstmt.setBytes(4, instancia.getImagen());
            pstmt.setString(5, instancia.getTipo().toString());
            pstmt.setInt(6, instancia.getPrecio());
            //se ejecuta la sentencia sql
            pstmt.execute();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "FALLO";
        }
        //lo ideal es retornor un id
        return instancia.getNombre();
    }

    /**
     * cumunicacion con la base de datos para eliminar una racion del dia
     * @param rac_id id racion que se desea eliminar
     * @return 
     */
    @Override
    public String deleteRacionDia(int rac_id) {
        if(findRacionDia(rac_id)){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("NO EXISTE EL ELEMENTO");
            return "FALLO";
        }
        try{
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "DELETE FROM raciondia WHERE rac_id = (?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se compara el id, OJO Ddebe cumplir estrictamente el orden y el tipo de dato(de las tablas)
            pstmt.setInt(1,rac_id);
            
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al eliminar la racion", ex);
        }
        return ""+rac_id;
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
        return null;
    }
    /**
     * cumunicacion con la base de datos para eliminar un plato especial
     * @param plae_id id plato que se desea eliminar
     * @return 
     */
    @Override
    public String deletePlatoEspecial(int plae_id) {
        if(findPlatoEspecial(plae_id)){
            System.out.println("EXISTE EL ELEMENTO");
        }else{
            System.out.println("NO EXISTE EL ELEMENTO");
            return "FALLO";
        }
        try{
            //primero se establece la conexion
            this.connect(); //validar cuando la conexion no sea exitosa
            //se estructura la sentencia sql en un string
            String sql = "DELETE FROM platoespecial WHERE plae_id = (?)";
            //pstmt mantendra la solicitud sobre la base de datos, se asignam sus columnas
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //se compara el id, OJO Ddebe cumplir estrictamente el orden y el tipo de dato(de las tablas)
            pstmt.setInt(1,plae_id);
            //se ejecuta la sentencia sql
            pstmt.executeUpdate();
            //se cierra
            pstmt.close();
            //se termina la coneccion
            this.disconnect();

            
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al eliminar el plato", ex);
        }
        return ""+plae_id;
        
        
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
        return null;
          
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
            String sql = "SELECT rac_id,rac_tipo,rac_precio,rac_nombre,mend_id,rac_foto FROM raciondia where raciondia.MEND_ID = (SELECT menudia.MEND_ID FROM menudia WHERE menudia.RES_ID = ? and menudia.MEND_DIASEM = ?) and raciondia.RES_ID = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, idRes);
            pstmt.setString(2, dia);
            pstmt.setInt(3, idRes);
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
            String sql = "select plae_id,m.mene_id,plae_nombre,plae_descripcion,plae_precio,plae_foto"
                    + " from (restaurante r inner join menuespecial m on r.res_id=m.res_id)"
                    + " inner join platoespecial p on m.mene_id=p.mene_id where r.res_id = (?)";
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
        System.out.println("Entered the save restaurant");
        try{
            this.connect();
            String sql = "INSERT INTO restaurante (CLI_ID,RES_CODIGO,RES_NOMBRE,RES_FOTO,RES_CARRERA,RES_CALLE) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, res.getIdCliente());
            pstmt.setString(2, res.getCodigo());
            pstmt.setString(3, res.getNombre());
            pstmt.setBytes(4, res.getImagen());
            pstmt.setInt(5, res.getCarrera());
            pstmt.setInt(6, res.getCalle());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al guardar el restaurante", ex);
        }
       return res.getNombre();
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
    
    /**
     * Lista el menu de toda la semana desde la consulta hecha a la base de datos 
     * añade las tuplas encontradas en una lista las raciones de dia
     * y convierte la lista en json para enviarla por el sockect devuelta
     * al cliente
     * @param idRes
     * @return 
     */
    @Override
    public String listMenuDayAll(int idRes) {
        List<RacionDia> list=new ArrayList<>();
        String response=null;
        System.out.println("Entered the list menu day all");
        try{
            this.connect();
            String sql = "SELECT rac_id,rac_tipo,rac_precio,rac_nombre,mend_id,rac_foto FROM raciondia where raciondia.RES_ID = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, idRes);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {      
                RacionDia pla=  new RacionDia(Integer.parseInt(rs.getString(1)), CategoriaEnum.valueOf(rs.getString(2)), Integer.parseInt(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)),rs.getBytes(6));
                list.add(pla);
            }
            response=listMenuToJson(list);
            pstmt.close();
            this.disconnect();
        }catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al listar el menu del dia de toda la semana", ex);
        }
        return response;
    }

    @Override
    public String validarAcceso(Cliente cliente) {
        String resultado = "";
        System.out.println("NOMBRE: "+cliente.getNombre());
        System.out.println("con: "+cliente.getContrasenia());
        try {
            this.connect();
            String sql = "Select c.CLI_TIPO,r.RES_ID,r.RES_NOMBRE from cliente c inner join restaurante r"
                    + " on c.CLI_ID=r.CLI_ID where c.CLI_NOMBRE = '" + cliente.getNombre() + "' and c.CLI_CONTRASENIA = '"
                    + cliente.getContrasenia() + "'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                resultado +=rs1.getString(1)+"-"+rs1.getInt(2)+"-"+rs1.getString(3)+"-";
            }

            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al validar usuario", ex);
        }
        return resultado;
    }

    @Override
    public String listaPedido(int idres) {
        //
        String resultado = "";
        List<Pedido> list=new ArrayList<>();
        try {
            this.connect();
            String sql = "select * from pedido where RES_ID="+idres;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                Pedido ped=new Pedido(rs1.getInt(1), rs1.getInt(2), rs1.getInt(3), EstadoPed.valueOf(rs1.getString(4)), null);
                list.add(ped);
            }
            resultado=listMenuToJson(list);
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositorioMysql.class.getName()).log(Level.SEVERE, "Error al validar usuario", ex);
        }
        return resultado;
    }
    
}
