package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_l_Direcciones;
import com.proyecto_universidad_java.repository.models.l_Direcciones;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_l_DireccionesMysqlImpl implements Repository_l_Direcciones {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<l_Direcciones> listar() {
        List<l_Direcciones> direccions = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM direcciones");){
            while (rs.next()) {
                direccions.add(crearDireccion(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return direccions;
    }

    public l_Direcciones porCodigo(int codigo) {
            l_Direcciones direccion = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM direccion WHERE id=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        direccion = crearDireccion(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return direccion;
        }    

    public void crear(l_Direcciones direccion){

        String sql = "INSERT INTO direccion(direccion_valor) VALUES(?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direccion.getDireccion_valor());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(l_Direcciones direccion){
        String sql = "UPDATE direccion SET direccion_valor=? WHERE id=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direccion.getDireccion_valor());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM direccion WHERE id=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private l_Direcciones crearDireccion(ResultSet rs) throws SQLException {
        return new l_Direcciones(rs.getInt("id"),rs.getString("direccion_valor"));
    }
}
