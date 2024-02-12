package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_q_Horario;
import com.proyecto_universidad_java.repository.models.q_Horario;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_q_HorarioMysqlImpl implements Repository_q_Horario {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<q_Horario> listar() {
        List<q_Horario> horarios = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM horario");){
            while (rs.next()) {
                horarios.add(crearHorario(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return horarios;
    }

    public q_Horario porCodigo(int codigo) {
            q_Horario Horario = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM horario WHERE id_horario=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Horario = crearHorario(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Horario;
        }    

    public void crear(q_Horario horario){

        String sql = "INSERT INTO horario(dia_clase,hora_inicio,hora_final) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horario.getDia_clase());
            stmt.setTime(2, horario.getHora_inicio());
            stmt.setTime(3, horario.getHora_final());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(q_Horario horario){
        String sql = "UPDATE horario SET dia_clase=?, hora_inicio=?, hora_final=? WHERE id_horario=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horario.getDia_clase());
            stmt.setTime(2, horario.getHora_inicio());
            stmt.setTime(3, horario.getHora_final());
            stmt.setInt(4, horario.getId_horario());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM horario WHERE id_horario=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private q_Horario crearHorario(ResultSet rs) throws SQLException {
        return new q_Horario(rs.getInt("id_horario"),rs.getString("dia_clase"),rs.getTime("hora_inicio"),rs.getTime("hora_final"));
    }
}
