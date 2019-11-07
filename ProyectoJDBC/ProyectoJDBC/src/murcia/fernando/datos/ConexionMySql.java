package murcia.fernando.datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author fernando.murcia
 */
public class ConexionMySql {
    
    //Creamos el metodo statico getDataSuorce no recibe parametros
    //regresa un tipo dataSource
    public static DataSource getDataSource(){
        //Creamos un objeto de tipo BasicDataSource se asigna a una variable
        //de tipo BasicDataSource
        BasicDataSource ds = new BasicDataSource();
        //Se inicializa la propiedad driver classname
        //Se usa la variable ds y se llama el metodo setDriverClassName
        //Se proporciona el valor del driver de la base de datos MySql
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //Colocamos el nombre del usuario y password por medio de los metodos
        // setusername y setpassword
        ds.setUsername("root");
        ds.setPassword("admin");
        //Colocamos la cadena de conexion a MySql
        ds.setUrl("jdbc:mysql://localhost:3306/liga?useSSl=false");
        //Definimos el tamaño del pool de conexiones
        //Por medio del metodo setInitialSize
        ds.setInitialSize(5);
        //Finalmente retornamos el objeto
        return ds;       
    }
    // Creamos metodo getConexion el cual podria arrojar una Excepcion de 
    // tipo sqlException, es de tipo public static y regresa un objeto de tipo connection
    public static Connection getConexion() throws SQLException{
        //Atravez del metodo getDataSource solicitamos el objeto gatConnection
        return getDataSource().getConnection();
        //Asi tenemos la configuracion del pool de conexiones de MySql
    }
    
}
