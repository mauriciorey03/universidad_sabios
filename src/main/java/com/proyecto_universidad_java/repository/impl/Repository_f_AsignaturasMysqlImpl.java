package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_f_Asignaturas;
import com.proyecto_universidad_java.repository.models.f_Asignaturas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_f_AsignaturasMysqlImpl implements Repository_f_Asignaturas {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<f_Asignaturas> listar() {
        List<f_Asignaturas> asignaturas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM materias");){
            while (rs.next()) {
                asignaturas.add(crearAsignatura(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return asignaturas;
    }

    public f_Asignaturas porCodigo(int codigo) {
            f_Asignaturas Asignatura = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM materias WHERE id_materia=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Asignatura = crearAsignatura(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Asignatura;
        }    

    public void crear(f_Asignaturas asignaturas){

        String sql = "INSERT INTO materias(nombre_materia, creditos,cantidad_estudiantes) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, asignaturas.getNombre_materia());
            stmt.setInt(2, asignaturas.getCreditos());
            stmt.setInt(3, asignaturas.getCantidad_estudiantes());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(f_Asignaturas asignaturas){
        String sql = "UPDATE materias SET nombre_materia=?, creditos=?, cantidad_estudiantes=? WHERE id_materia=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, asignaturas.getNombre_materia());
            stmt.setInt(2, asignaturas.getCreditos());
            stmt.setInt(3, asignaturas.getCantidad_estudiantes());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM materias WHERE id_materia=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private f_Asignaturas crearAsignatura(ResultSet rs) throws SQLException {
        return new f_Asignaturas(rs.getInt("id_materia"),rs.getString("nombre_materia"),rs.getInt("creditos"),rs.getInt("cantidad_estudiantes"));
    }
}
