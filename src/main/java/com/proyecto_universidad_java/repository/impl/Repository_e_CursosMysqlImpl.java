package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_e_Cursos;
import com.proyecto_universidad_java.repository.models.e_Cursos;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_e_CursosMysqlImpl implements Repository_e_Cursos {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<e_Cursos> listar() {
        List<e_Cursos> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM curso_materia");){
            while (rs.next()) {
                cursos.add(crearCurso(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return cursos;
    }

    public e_Cursos porCodigo(int codigo) {
            e_Cursos Cursos = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM curso_materia WHERE id_curso=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Cursos = crearCurso(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Cursos;
        }    

    public void crear(e_Cursos cursos){

        String sql = "INSERT INTO curso_materia(nombre_curso,guia_curso) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cursos.getNombre_curso());
            stmt.setString(2, cursos.getGuia_curso());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(e_Cursos cursos){
        String sql = "UPDATE curso_materia SET nombre_curso=?, guia_curso=? WHERE id_curso=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cursos.getNombre_curso());
            stmt.setString(2, cursos.getGuia_curso());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM curso_materia WHERE id_curso=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private e_Cursos crearCurso(ResultSet rs) throws SQLException {
        return new e_Cursos(rs.getInt("id_curso"),rs.getString("nombre_curso"),rs.getString("guia_curso"));
    }
}