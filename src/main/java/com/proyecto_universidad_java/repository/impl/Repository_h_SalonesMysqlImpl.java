package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_h_Salones;
import com.proyecto_universidad_java.repository.models.h_Salones;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_h_SalonesMysqlImpl implements Repository_h_Salones {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<h_Salones> listar() {
        List<h_Salones> salones = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM salon");){
            while (rs.next()) {
                salones.add(crearSalon(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return salones;
    }

    public h_Salones porCodigo(int codigo) {
        h_Salones Salon = null;

        try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM salon WHERE id_salon=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Salon = crearSalon(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Salon;
        }    

    public void crear(h_Salones salon){

        String sql = "INSERT INTO salon(valor_salon,capacidad_salon,piso_edificio) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salon.getValor_salon());
            stmt.setInt(2, salon.getCapacidad_salon());
            stmt.setInt(3, salon.getPiso_edificio());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(h_Salones salon){
        String sql = "UPDATE salon SET valor_salon=?, capacidad_salon=?, piso_edificio=? WHERE id_salon=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salon.getValor_salon());
            stmt.setInt(2, salon.getCapacidad_salon());
            stmt.setInt(3, salon.getPiso_edificio());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM salon WHERE id_salon=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private h_Salones crearSalon(ResultSet rs) throws SQLException {
        return new h_Salones(rs.getInt("id_salon"),rs.getString("valor_salon"),rs.getInt("capacidad_salon"),rs.getInt("piso_edificio"));
    }
}
