package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_b_Departamentos;
import com.proyecto_universidad_java.repository.models.b_Departamentos;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_b_DepartamentosMysqlImpl implements Repository_b_Departamentos {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<b_Departamentos> listar() {
        List<b_Departamentos> dptos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM facultades");){
            while (rs.next()) {
                dptos.add(crearDepartamento(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return dptos;
    }

    public b_Departamentos porCodigo(int codigo) {
            b_Departamentos Departamento = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facultades WHERE id_facultad=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Departamento = crearDepartamento(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Departamento;
        }    

    public void crear(b_Departamentos dpto){
        
            String sql = "INSERT INTO facultades(nombre_facultad) VALUES(?)";

            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, dpto.getNombre_facultad());
                stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        
    }

    public void editar(b_Departamentos dpto){
        String sql = "UPDATE facultades SET nombre_facultad=? WHERE id_facultad=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dpto.getNombre_facultad());
            stmt.setInt(2, dpto.getId_facultad());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM facultades WHERE id_facultad=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private b_Departamentos crearDepartamento(ResultSet rs) throws SQLException {
        return new b_Departamentos(rs.getInt("id_facultad"),rs.getString("nombre_facultad"));
    }
}
