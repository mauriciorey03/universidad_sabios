package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_j_Matriculas;
import com.proyecto_universidad_java.repository.models.j_Matriculas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_j_MatriculasMysqlImpl implements Repository_j_Matriculas {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<j_Matriculas> listar() {
        List<j_Matriculas> matriculas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM registro");){
            while (rs.next()) {
                matriculas.add(crearMatriculas(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return matriculas;
    }

    public j_Matriculas porCodigo(int codigo) {
            j_Matriculas Matriculas = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM registro WHERE id_registro=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Matriculas = crearMatriculas(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Matriculas;
        }    

    public void crear(j_Matriculas registro){

        String sql = "INSERT INTO registro(id_estudiante, id_periodo,id_materia) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getId_estudiante());
            stmt.setInt(2, registro.getId_periodo());
            stmt.setInt(3, registro.getId_materia());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(j_Matriculas registro){
        String sql = "UPDATE registro SET id_estudiante=?, id_periodo=?, id_materia=? WHERE id_registro=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getId_estudiante());
            stmt.setInt(2, registro.getId_periodo());
            stmt.setInt(3, registro.getId_materia());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM registro WHERE id=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private j_Matriculas crearMatriculas(ResultSet rs) throws SQLException {
        return new j_Matriculas(rs.getInt("id_registro"),rs.getInt("id_estudiante"),rs.getInt("id_periodo"),rs.getInt("id_materia"));
    }
}
