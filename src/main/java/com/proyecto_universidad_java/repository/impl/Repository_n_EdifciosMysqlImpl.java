package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_n_Edificios;
import com.proyecto_universidad_java.repository.models.n_Edificios;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_n_EdifciosMysqlImpl implements Repository_n_Edificios {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<n_Edificios> listar() {
        List<n_Edificios> edificios = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM edificios");){
            while (rs.next()) {
                edificios.add(crearEdificio(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return edificios;
    }

    public n_Edificios porCodigo(int codigo) {
            n_Edificios Edificio = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM edificio WHERE id_edificio=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Edificio = crearEdificio(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Edificio;
        }    

    public void crear(n_Edificios edificio){

        String sql = "INSERT INTO edificio(nombre_edificio,pisos_edificio) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, edificio.getNombre_edificio());
            stmt.setInt(2, edificio.getPisos_edificios());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(n_Edificios edificio){
        String sql = "UPDATE edificio SET nombre_edificio=?, pisos_edificio=? WHERE id_edificio=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, edificio.getNombre_edificio());
            stmt.setInt(2, edificio.getPisos_edificios());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM edificio WHERE id_edificio=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private n_Edificios crearEdificio(ResultSet rs) throws SQLException {
        return new n_Edificios(rs.getInt("id_edificio"),rs.getString("nombre_edificio"),rs.getInt("pisos_edificio"));
    }
}
