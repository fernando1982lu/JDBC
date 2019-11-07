package proyectojdbc;

import murcia.fernando.datos.ConexionMySql;
import murcia.fernando.datos.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author fernando.murcia
 */
public class ProyectoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //declaramos una variable llamada conn de tipo connection y se inicializa en null
        Connection conn = null;
        //Declaramos la variable stmt de tipo Preparedstatement
        PreparedStatement stmt = null;
        //Declaramos la variable rs de tipo ResultSet
        ResultSet rs = null;
        //Inicializamos un bloque try catch para la ejecucion del codigo
        try{
            //primero probamos el pool de MySql ejecutando una consulta
            /* Por medio de la clase ConexionMySql solicitamos el metodo getConexion
                y esto nos regresa una conexion a la BD
            */
            conn = ConexionMySql.getConexion();
            System.out.println("Utilizamos el pool de conexiones de MySql");
            //Creamos el objeto de tipo preparedStatement utilizando una consulta
            stmt = conn.prepareStatement("SELECT * FROM equipos");
            //Ejecutamos el query por medio del objeto statemet, nos regresa
            //el resultSet como resultado de la consulta.
            rs = stmt.executeQuery();
            //Mientras tengamos registros mandamos a imprimir las columnas de la tabla
            while(rs.next()){
                
                System.out.println(" " + rs.getInt(1));
                System.out.println(" " + rs.getString(2));
                System.out.println(" " + rs.getString(3));
                System.out.println(" " + rs.getString(4));
                System.out.println(" " + rs.getString(5));
                System.out.println(" " + rs.getString(6));
            }
            //Cerramos la conexion
            conn.close();
            // probamos el pool de oracle por medio de una consulta
            //Por medio de la clase ConexionOracle solicitamos el metodo getConexion
            //el cual nos regresa la conexion a oracle
            conn = ConexionOracle.getConexion();
            System.out.println("Utilizamos el pool de conexiones de Oracle");
            //Creamos el objeto de tipo preparedStatement utilizando una consulta
            //stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100, 101, 102)");
            stmt = conn.prepareStatement("SELECT * FROM job_History ");
            //Ejecutamos el query por medio del objeto statemet, nos regresa
            //el resultSet como resultado de la consulta.
            rs = stmt.executeQuery();
            //Mientras tengamos registros mandamos a imprimir las columnas de la tabla
            while(rs.next()){
                System.out.println(" " + rs.getInt(1));
                System.out.println(" " + rs.getDate(2));
                System.out.println(" " + rs.getDate(3));
                System.out.println(" " + rs.getString(4));
                System.out.println(" " + rs.getInt(5));
                
                
            }
            //Cerramos la conexion
            conn.close();
          //Finalmente agregamos el catch por si existe alguna excepcion y mandamos imprimir 
          //la pila de errores
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
