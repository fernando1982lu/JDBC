package murcia.fernando.personas.jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import murcia.fernando.personas.dto.PersonaDTO;

/**
 * Esta clase implementa la clase PersonaDao es una implementacion con la 
 * tecnología JDBC podría haber otro tipo de implementaciones  con tecnologias
 * como Hibernate, iBatis, SpringJDBC, etc
 * 
 * @author fernando.murcia
 */
public class PersonaDaoJDBC implements PersonaDao {
    
    private Connection userConn;
    
    private final String SQL_INSERT = "INSERT INTO persona(nombre, apellido) VALUES (?, ?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
    private final String SQL_DELETE = "DETELE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT = "SELECT id_persona, nombre, apellido, FROM persona";
    
    public PersonaDaoJDBC(){
        
    }
    public PersonaDaoJDBC(Connection conn) {
        this.userConn = conn;
    }
    
    /**
     * El método insert recibe como argumento un objeto DTO el cual viene 
     * de otra capa, y se extraen sus valores para crear un nuevo registro
     * @param persona
     * @return
     * @throws SQLException 
     */
    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }finally{
            Conexion.close(stmt);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            stmt.setInt(index, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }finally{
            Conexion.close(stmt);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }finally{
            Conexion.close(stmt);
            if (this.userConn == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        try{
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersonaTemp = rs.getInt(1);
                String nombreTemp = rs.getString(2);
                String apellidoTemp = rs.getString(3);
                personaDTO = new PersonaDTO();
                personaDTO.setId_persona(idPersonaTemp);
                personaDTO.setNombre(nombreTemp);
                personaDTO.setApellido(apellidoTemp);
                personas.add(personaDTO);
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.userConn == null){
                Conexion.close( conn);
            }
        }
        return personas;
    }
    
}
