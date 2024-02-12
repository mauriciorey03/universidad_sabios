package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_o_Periodo;
import com.proyecto_universidad_java.repository.models.o_Periodo;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_o_PeriodoMysqlImpl implements Repository_o_Periodo {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<o_Periodo> listar() {
        List<o_Periodo> periodos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM periodos");){
            while (rs.next()) {
                periodos.add(crearPeriodo(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return periodos;
    }

    public o_Periodo porCodigo(int codigo) {
            o_Periodo Periodo = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM periodo WHERE id_periodo=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Periodo = crearPeriodo(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Periodo;
        }    

    public void crear(o_Periodo periodo){

        String sql = "INSERT INTO periodo(anio,semestre) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, periodo.getAnio());
            stmt.setString(2, periodo.getSemestre());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(o_Periodo periodo){
        String sql = "UPDATE periodo SET anio=?, semestre=?, WHERE id_periodo=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, periodo.getAnio());
            stmt.setString(2, periodo.getSemestre());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM periodo WHERE id_periodo=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    


    private o_Periodo crearPeriodo(ResultSet rs) throws SQLException {
        return new o_Periodo(rs.getInt("id_periodo"),rs.getInt("anio"),rs.getString("semestre"));
    }
}
