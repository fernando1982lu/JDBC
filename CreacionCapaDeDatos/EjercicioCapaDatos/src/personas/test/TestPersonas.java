package personas.test;

import java.sql.SQLException;
import java.util.List;
import murcia.fernando.personas.dto.PersonaDTO;
import murcia.fernando.personas.jdbc.PersonaDao;
import murcia.fernando.personas.jdbc.PersonaDaoJDBC;

/**
 *
 * @author fernando.murcia
 */
public class TestPersonas {
    
    public static void main(String[] args) throws SQLException {
        //Utilizamos el tipo interface como referencia a una clase concreta
        PersonaDao personaDao = new PersonaDaoJDBC();
        //Creamos un nuevo registro
        //Hacemos uso de la clase persona DTO la cual se usa
        //para transferiri la informacion entre las capas
        //no es necesario especificar la llave primaria
        //ya que en este caso es de tipo autonumerico y la BD se encarga
        //de asignarle un nuevo valor
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Gerardo");
        persona.setApellido("Gallegos");
        // Utilizamos la capa DAO para persistir el objeto DTO
        try{
            personaDao.insert(persona);
             
            //eliminamos un registro, el id 3
            personaDao.delete( new PersonaDTO(1));
            
            //actualizamos un registro
            PersonaDTO personaTmp = new PersonaDTO();
            personaTmp.setId_persona(11);//actualizamos el registro 2
            personaTmp.setNombre("Mario");
            personaTmp.setApellido("lopez02");
            personaDao.update(personaTmp);
            
            //Seleccionamos todos los registros
            List<PersonaDTO> personas = personaDao.select();
            for(PersonaDTO personaDTO : personas){
                System.out.print(personaDTO);
                System.out.println();
            }
        }catch(SQLException e){
            System.out.println("Excepcion en la caja de prueba");
            e.printStackTrace();
        }
    }
    
}
