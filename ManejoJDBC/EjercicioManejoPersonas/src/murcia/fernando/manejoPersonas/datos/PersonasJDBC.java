package murcia.fernando.manejoPersonas.datos;

import java.sql.*;
import java.util.*;
import murcia.fernando.manejoPersonas.domain.Persona;

/**
 *
 * @author fernando.murcia
 */
public class PersonasJDBC {
    
    /* Nos apoyamos de la llave primaria autoincrementable de MySql
       por lo que se omite el campo de id_persona, se utiliza un 
       prepareStatement, por lo que podemos utilizar parametros (signos de ?)
       los cuales posteriormente seran sustituidos por el parametro respectivo
    */
    
    private final String SQL_INSERT
            = "INSERT INTO persona (nombre, apellido) values(?, ?)";
    
    private final String SQL_UPDATE
            = "UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
    
    private final String SQL_DELETE
            = "DELETE FROM persona WHERE id_persona = ?";
    
    private final String SQL_SELECT
            = "SELECT id_persona, nombre, apellido FROM persona ORDER BY id_persona";
    private int id_persona;
    
    /**
     * Metodo que inserta un registro en la tabla de persona
     * @param nombre
     * @param apellido
     */
    
    public int insert(String nombre, String apellido) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza para este ejercicio
        int rows = 0; //Registros afectados
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1; // Controlador de Columnas
            stmt.setString(index++, nombre); //param 1 => ?
            stmt.setString(index++, apellido); //param 1 => ?
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate(); //N° de registros afectados
            System.out.println("Registros afectados: " + rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
    }
    /**
     * Metodo que actualiza un registro existente
     * @param Id_persona es la llave primaria
     * @param nombre Nuevo valor
     * @param apellido nuevo valor
     * @return int N° de registros modificados
     */
    public int update(int id_persona, String nombre, String apellido){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            stmt.setInt(index, id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    /**
     * Metodo que elimina un registro existente
     * @param id_persona es la llave primaria
     * @return int N° registros afectados
     */
    public int delete(int id_personas){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Metodo que regresa el contenido de la tabla de personas
     */
    public List<Persona> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                /*System.out.print(" " + id_persona);
                 System.out.print(" " + nombre);
                 System.out.print(" " + apellido);
                 System.out.println();
                 */
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }
}

