package ejerintrojdbc;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author fernando.murcia
 */
public class EjerIntroJdbc {

    
    public static void main(String[] args) throws SQLException {
        // Cadena de conexión a MySql, el parametro use SSL es opcional
        String url = "jdbc:mysql://localhost:3306/ejemplomysql?useSSL=false";
        // Cargamos el drive de MySql
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Creamos el objeto conexion
            Connection conexion = (Connection) DriverManager.getConnection(url, "root", "admin");
            //Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            //Creamos el query
            String sql = "Select id_persona, nombre, apellido from persona";
            ResultSet result = instruccion.executeQuery(sql);
            while (result.next()) {
                System.out.println("id: " + result.getInt(1));
                System.out.println("Nombre : " + result.getString(2));
                System.out.println("Apellido : " + result.getString(3));
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
}
