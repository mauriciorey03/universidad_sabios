package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_i_Tarifas;
import com.proyecto_universidad_java.repository.models.i_Tarifas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_i_TarifasMysqlImpl implements Repository_i_Tarifas {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<i_Tarifas> listar() {
        List<i_Tarifas> tarifas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM valor_matricula");){
            while (rs.next()) {
                tarifas.add(crearTarifa(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return tarifas;
    }

    public i_Tarifas porCodigo(int codigo) {
            i_Tarifas Tarifa = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM valor_matricula WHERE id_valor_matricula=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Tarifa = crearTarifa(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Tarifa;
        }    

    public void crear(i_Tarifas Tarifa){

        String sql = "INSERT INTO valor_matricula(valor_credito,id_programa,id_periodo) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, Tarifa.getValor_credito());
            stmt.setInt(2, Tarifa.getId_programa());
            stmt.setInt(3, Tarifa.getId_periodo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(i_Tarifas Tarifa){
        String sql = "UPDATE valor_matricula SET valor_credito=?, id_programa=?, id_periodo=? WHERE id_valor_matricula=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, Tarifa.getValor_credito());
            stmt.setInt(2, Tarifa.getId_programa());
            stmt.setInt(3, Tarifa.getId_periodo());
            stmt.setInt(4, Tarifa.getId_valor_matricula());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM valor_matricula WHERE id_valor_matricula=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private i_Tarifas crearTarifa(ResultSet rs) throws SQLException {
        return new i_Tarifas(rs.getInt("id_valor_matricula"),rs.getDouble("valor_credito"),rs.getInt("id_programa"),rs.getInt("id_periodo"));
    }
}
