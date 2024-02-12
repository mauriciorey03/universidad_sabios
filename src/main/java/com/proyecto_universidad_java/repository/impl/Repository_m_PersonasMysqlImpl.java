package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_m_Personas;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_m_PersonasMysqlImpl implements Repository_m_Personas {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<m_Personas> listar() {
        List<m_Personas> personas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM personas");) {
            while (rs.next()) {
                personas.add(crearPersona(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    public m_Personas porCodigo(int codigo) {
        m_Personas Personas = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personas WHERE id_persona=?")) {
            stmt.setInt(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Personas = crearPersona(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Personas;
    }

    public void crear(m_Personas persona) {

        String sql = "INSERT INTO personas(nombre_persona,apellido_persona,telefono,fecha_nacimiento,genero,clase_documento,numero_documento,id_ciudad,id_direccion) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, persona.getNombre_persona());
            stmt.setString(2, persona.getApellido_persona());
            stmt.setInt(3, persona.getTelefono());
            stmt.setDate(4, persona.getFecha_nacimiento());
            stmt.setString(5, persona.getGenero());
            stmt.setString(6, persona.getClase_documento());
            stmt.setInt(7, persona.getNumero_documento());
            stmt.setInt(8, persona.getId_ciudad());
            stmt.setInt(9, persona.getId_direccion());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(m_Personas persona) {
        String sql = "UPDATE personas SET nombre_persona=?, apellido_persona=?, telefono=?, fecha_nacimiento=?, clase_documento=?, numero_documento=?, id_ciudad=?, id_direccion=? WHERE id_personas=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, persona.getNombre_persona());
            stmt.setString(2, persona.getApellido_persona());
            stmt.setInt(3, persona.getTelefono());
            stmt.setDate(4, persona.getFecha_nacimiento());
            stmt.setString(5, persona.getGenero());
            stmt.setString(6, persona.getClase_documento());
            stmt.setInt(7, persona.getNumero_documento());
            stmt.setInt(8, persona.getId_ciudad());
            stmt.setInt(9, persona.getId_direccion());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM personas WHERE id_personas=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private m_Personas crearPersona(ResultSet rs) throws SQLException {
        return new m_Personas(
                rs.getInt("id_persona"),
                rs.getString("nombre_persona"),
                rs.getString("apellido_persona"),
                rs.getInt("telefono"),
                rs.getDate("fecha_nacimiento"),
                rs.getString("genero"),
                rs.getString("clase_documento"),
                rs.getInt("numero_documento"),
                rs.getInt("id_ciudad"),
                rs.getInt("id_direccion"));
    }
}
