package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_d_Alumnos;
import com.proyecto_universidad_java.repository.models.d_Alumnos;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_d_AlumnosMysqlImpl implements Repository_d_Alumnos {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    public List<m_Personas> toList() {
        Repository_m_PersonasMysqlImpl repositoryPersonMysqlImpl = new Repository_m_PersonasMysqlImpl();
        return repositoryPersonMysqlImpl.toListStudents();
    }

    public List<d_Alumnos> listar() {
        List<d_Alumnos> alumnos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM estudiante_carrera");){
            while (rs.next()) {
                alumnos.add(crearAlumno(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    public d_Alumnos porCodigo(int codigo) {
            d_Alumnos Alumnos = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM estudiante_carrera WHERE id_estudiante=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Alumnos = crearAlumno(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Alumnos;
        }    

    public void crear(d_Alumnos alumnos){

        String sql = "INSERT INTO estudiante_carrera(id_persona, id_programa) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alumnos.getId_persona());
            stmt.setInt(2, alumnos.getId_programa());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(d_Alumnos alumnos){
        String sql = "UPDATE estudiante_carrera SET id_persona=?, id_programa=? WHERE id_estudiante=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alumnos.getId_persona());
            stmt.setInt(2, alumnos.getId_programa());
            stmt.setInt(3, alumnos.getId_estudiante());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM estudiante_carrera WHERE id_estudiante=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private d_Alumnos crearAlumno(ResultSet rs) throws SQLException {
        return new d_Alumnos(rs.getInt("id_estudiante"),rs.getInt("id_persona"),rs.getInt("id_programa"));
    }
}
