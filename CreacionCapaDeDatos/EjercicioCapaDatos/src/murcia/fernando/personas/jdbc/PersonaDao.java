package murcia.fernando.personas.jdbc;

import java.sql.SQLException;
import java.util.List;
import murcia.fernando.personas.dto.PersonaDTO;

/**
 * Esta interface contiene los metodos abstractos con las operaciones 
 * basicas sobre la tabla de personas.
 * CRUD (create, Read, Update, Delete)
 * Se debe crear una clase concreta para implementar el codigo
 * asociado acada método
 * @author fernando.murcia
 */
public interface PersonaDao {
    
    public int insert(PersonaDTO persona) throws SQLException;
    public int update(PersonaDTO persona) throws SQLException;
    public int delete(PersonaDTO persona) throws SQLException;
    public List<PersonaDTO> select() throws SQLException;   
}


