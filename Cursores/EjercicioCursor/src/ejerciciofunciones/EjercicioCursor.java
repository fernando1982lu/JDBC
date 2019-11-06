package ejerciciofunciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import murcia.fernando.funciones.datos.Conexion;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author fernando.murcia
 */
public class EjercicioCursor {

    public static void main(String[] args) {
        //Utilizamos una clase de oracle para poder procesar el
        //cursor que regresa la funcion de Oracle
        OracleCallableStatement oraCallStmt = null;
        OracleResultSet deptResultSet = null;
        try {
            Connection con = Conexion.getConnection();
            //Tiene dos parametros que posteriormente se definiran
            oraCallStmt = (OracleCallableStatement) con.prepareCall("{? = call ref_cursor_package.get_dept_ref_cursor(?)}");
            //Indicamos el tipo de regreso, el cual es un cursor
            oraCallStmt.registerOutParameter(1, OracleTypes.CURSOR);//Parametro 1
            oraCallStmt.setInt(2, 200);//establecemos departamento_id, parametro 2
            oraCallStmt.execute();
            //Recuperamos el resultSet y lo convertimos a un tipo Oracle
            deptResultSet = (OracleResultSet) oraCallStmt.getCursor(1);
            while (deptResultSet.next()) {
                System.out.print(" Id_departamento: " + deptResultSet.getInt(1));
                System.out.print(", Nombre_departamento: " + deptResultSet.getString(2));
                System.out.print(", Ubicacion_id: " + deptResultSet.getString(3));
                System.out.println();
            }
            oraCallStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
