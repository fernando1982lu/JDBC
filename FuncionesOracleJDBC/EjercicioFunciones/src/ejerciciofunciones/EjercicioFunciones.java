package ejerciciofunciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import murcia.fernando.funciones.datos.Conexion;

/**
 *
 * @author fernando.murcia
 */
public class EjercicioFunciones {

    public static void main(String[] args) {
        
        int empleadoId = 100; //Identificador a recuperar salario
        try{
            Connection con = Conexion.getConnection();
            CallableStatement cstmt = null;
            double salarioMensual;
            
            cstmt = con.prepareCall("{ ? = call get_employee_salary(?) }");
            // Una funcion regresa un valor
            // Por lo que lo registramos como el parametro 1
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            // Registramos el segundo parametro
            cstmt.setInt(2, empleadoId);
            cstmt.execute();
            salarioMensual = cstmt.getDouble(1);
            cstmt.close();
            System.out.println("Empleado con Id: " + empleadoId);
            System.out.println("Salario $" + salarioMensual);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
