import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cesar
 * Objetivo: Programar las rutinas SQL para hacer la inserción,conculta, eliminacion y actualizacion.
 *           Codigos de conexion entre el lenguaje java y la BDMS MySQL.
 */
public class BaseDatos {
    Connection conexion;
    Statement transaccion;
    ResultSet cursor; //aqui se guardan la informacion de las consultas SELECT
    
    public BaseDatos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_ejemplo1?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            transaccion = conexion.createStatement();
        }catch(SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertar(Chofer chofer){
        String SQL_insertar = "INSERT INTO chofer VALUES (NULL, '"+chofer.nombre+"','"+chofer.domicilio+"','"+chofer.licencia+"','"+chofer.vence+"')";
        
        /*
        SQL_insertar = SQL_insertar.replace("%NOM%", chofer.nombre);
        SQL_insertar = SQL_insertar.replace("%DOM%", chofer.domicilio);
        SQL_insertar = SQL_insertar.replace("%LIC%", chofer.licencia);
        SQL_insertar = SQL_insertar.replace("%VEN%", chofer.vence);
        */
        
        try {
            transaccion.execute(SQL_insertar);
        } catch (SQLException ex) {
            return false;
        }
        
        return true;
        
    }
    
    public ArrayList<String[]> consultarTodos(){
        ArrayList<String[]> resultado = new ArrayList<String[]>();
        
        try {
            cursor = transaccion.executeQuery("SELECT * FROM chofer");
            if (cursor.next()) {
                do{
                    String[] renglon = {cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)};
                    resultado.add(renglon);
                }while(cursor.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
        
    }
    
    public Chofer consultarPorID(int ID){
    
        Chofer choferResultado = new Chofer();
    
        try {
            cursor = transaccion.executeQuery("SELECT * FROM chofer WHERE ID="+ID);
            if (cursor.next()) {
                choferResultado.nombre = cursor.getString(2);
                choferResultado.domicilio = cursor.getString(3);
                choferResultado.licencia = cursor.getString(4);
                choferResultado.vence = cursor.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return choferResultado;
    }
    
    public boolean eliminar(String ID){
        try {
            transaccion.executeQuery("DELETE FROM chofer WHERE ID="+ID);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean actualizar(Chofer chofer){
        String SQL_update = "UPDATE chofer SET NOMBRE ='"+chofer.nombre+"',DOMICILIO='"+chofer.domicilio+"',LICENCIA='"+chofer.licencia+"',VENCE='"+chofer.vence+"' WHERE ID="+chofer.id;
        
        /*
        SQL_update = SQL_update.replace("%NOM%", chofer.nombre);
        SQL_update = SQL_update.replace("%DOM%", chofer.domicilio);
        SQL_update = SQL_update.replace("%LIC%", chofer.licencia);
        SQL_update = SQL_update.replace("%VEN%", chofer.vence);
        */
        
        try {
            transaccion.executeUpdate(SQL_update);
        } catch (SQLException ex) {
            return false;
        }
        
        return true;
    }
    
}
