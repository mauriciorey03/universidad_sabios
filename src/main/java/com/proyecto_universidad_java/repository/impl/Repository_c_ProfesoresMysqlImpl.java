package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_c_Profesores;
import com.proyecto_universidad_java.repository.models.c_Profesores;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_c_ProfesoresMysqlImpl implements Repository_c_Profesores {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<m_Personas> toList(){
        Repository_m_PersonasMysqlImpl repositoryPersonMysqlImpl = new Repository_m_PersonasMysqlImpl();
        return repositoryPersonMysqlImpl.toListTeachers();
    }

    public List<c_Profesores> listar() {
        List<c_Profesores> profesor = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM profesores");){
            while (rs.next()) {
                profesor.add(crearProfesor(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return profesor;
    }

    public c_Profesores porCodigo(int codigo) {
            c_Profesores profesores = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM profesores WHERE id_profesor=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        profesores = crearProfesor(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return profesores;
        }    

    public void crear(c_Profesores Profesores){

        String sql = "INSERT INTO profesores(id_persona,id_facultad) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Profesores.getId_persona());
            stmt.setInt(2, Profesores.getId_facultad());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(c_Profesores Profesores){
        String sql = "UPDATE profesores SET id_persona=?, id_facultad=? WHERE id_profesor=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Profesores.getId_persona());
            stmt.setInt(2, Profesores.getId_facultad());
            stmt.setInt(3, Profesores.getId_profesor());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM profesores WHERE id_profesor=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private c_Profesores crearProfesor(ResultSet rs) throws SQLException {
        return new c_Profesores(rs.getInt("id_profesor"),rs.getInt("id_persona"),rs.getInt("id_facultad"));
    }
}
