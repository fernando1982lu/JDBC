package ejerciciomanejopersonas;

import java.util.List;
import murcia.fernando.manejoPersonas.datos.PersonasJDBC;
import murcia.fernando.manejoPersonas.domain.Persona;

/**
 *
 * @author fernando.murcia
 */
public class EjercicioManejoPersonas {

    
    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        //Prueba del metodo insert
        //personasJDBC.insert("Alberto", "Juarez");
        
        //Prueba del metodo update
        //personasJDBC.update(2, "Nombre3", "Apellido3");
		
        //Prueba del metodo delete
        //personasJDBC.delete(1);
      
        //Prueba del metodo select
        //Uso de un objeto persona para encapsular la informacion
        //de un registro de base de datos
        List<Persona> personas = personasJDBC.select();
        for(Persona persona: personas){
            System.out.println(persona);
            System.out.println("");
        }
                
    }
    
}
