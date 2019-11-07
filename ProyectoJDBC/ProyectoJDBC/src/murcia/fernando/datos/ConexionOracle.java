package murcia.fernando.datos;

import java.sql.*;
import javax.sql.DataSource;
import static murcia.fernando.datos.ConexionMySql.getDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author fernando.murcia
 */

public class ConexionOracle {
    
    //Creamos el metodo statico getDataSuorce no recibe parametros
    //regresa un tipo dataSource
    public static DataSource getDataSource(){
        
        //Creamos un objeto de tipo BasicDataSource se asigna a una variable
        //de tipo BasicDataSource
        BasicDataSource ds = new BasicDataSource();
        //Se inicializa la propiedad driver classname
        //Se usa la variable ds y se llama el metodo setDriverClassName
        //Se proporciona el valor del driver de la base de datos Oracle
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //Colocamos el nombre del usuario y password por medio de los metodos
        // setUsername y setPassword
        ds.setUsername("hr");
        ds.setPassword("hr");
        //Colocamos la cadena de conexion a Oracle
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
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
