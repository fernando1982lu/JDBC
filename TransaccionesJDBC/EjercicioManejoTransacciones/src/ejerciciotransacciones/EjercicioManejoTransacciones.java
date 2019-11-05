package ejerciciotransacciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import murcia.fernando.transacciones.datos.PersonasJDBC;
import murcia.fernando.transacciones.domain.Persona;
import murcia.fernando.transacciones.datos.Conexion;

/**
 *
 * @author fernando.murcia
 */
public class EjercicioManejoTransacciones {

    
    public static void main(String[] args) throws SQLException{
        PersonasJDBC personasJDBC = new PersonasJDBC();
        
        Connection conn = null;
        
        try{
            conn = Conexion.getConnection();
            //revisamos si la coneccion esta en modo autocommit
            //Por default es autocommit == true
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            PersonasJDBC personas = new PersonasJDBC(conn);
                    
            //Prueba del metodo insert
            personas.insert("Jorgue", "Murcia123456789098765432123456789");

            //Prueba del metodo update
            personas.update(2, "regreso2", "Regreso");

            //Prueba del metodo delete
            //personasJDBC.delete(2);

            //Prueba del metodo select
            //Uso de un objeto persona para encapsular la informacion
            //de un registro de base de datos
            /*List<Persona> personas = personasJDBC.select();
            for(Persona persona: personas){
                System.out.println(persona);
                System.out.println("");
            }*/
            conn.commit();
        }catch(SQLException e){
            //Hacemos rollback en caso de error
            try{
                System.out.println("Entramos a el rollback");
                //Imprimimos la excepcion a la consola
                e.printStackTrace(System.out);
                //hacemos rollbaack
                conn.rollback();
            }catch(SQLException e1){
                e1.printStackTrace(System.out);
            }
        }       
    }
    
}
