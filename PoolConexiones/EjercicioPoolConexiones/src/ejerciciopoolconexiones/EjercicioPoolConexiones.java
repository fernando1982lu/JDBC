package ejerciciopoolconexiones;

import capadatos.pool.PoolConexionesMySql;
import capadatos.pool.PoolConexionesOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando.murcia
 */
public class EjercicioPoolConexiones {

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //Probamos el pool de MySql y ejecutamos una consulta
            conn = PoolConexionesMySql.getConexion();
            System.out.println("Utilizamos el pool de conexiones de MySql");
            stmt = conn.prepareStatement("SELECT * FROM persona");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(" " + rs.getInt(1));//id_persona
                System.out.println(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
            conn.close();
            //Probamos el pool de oracle y ejecutamos una consulta
            conn = PoolConexionesOracle.getConexion();
            System.out.println("Utilizamos el pool de conexiones de Oracle");
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100, 101, 102)");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(" " + rs.getInt(1));//empleado_id
                System.out.println(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
            //Cerramos la conexion para regresarla a el pool
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
