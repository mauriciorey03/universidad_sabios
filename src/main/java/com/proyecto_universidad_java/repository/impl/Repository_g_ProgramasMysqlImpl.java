package com.proyecto_universidad_java.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_g_Programas;
import com.proyecto_universidad_java.repository.models.g_Programas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Repository_g_ProgramasMysqlImpl implements Repository_g_Programas {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<g_Programas> listar() {
        List<g_Programas> programas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM carreras");){
            while (rs.next()) {
                programas.add(crearPrograma(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return programas;
    }

    public g_Programas porCodigo(int codigo) {
            g_Programas programas = null;
    
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM carreras WHERE id_programa=?")) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        programas = crearPrograma(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return programas;
        }    

    public void crear(g_Programas alumnos){

        String sql = "INSERT INTO carreras(nombre_programa, categoria) VALUES(?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alumnos.getNombre_programa());
            stmt.setString(2, alumnos.getCategoria());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editar(g_Programas alumnos){
        String sql = "UPDATE carreras SET nombre_programa=?, categoria=? WHERE id_programa=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alumnos.getNombre_programa());
            stmt.setString(2, alumnos.getCategoria());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void eliminar(int codigo){
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM carreras WHERE id_programa=?")) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private g_Programas crearPrograma(ResultSet rs) throws SQLException {
        return new g_Programas(rs.getInt("id_programa"),rs.getString("nombre_programa"),rs.getString("categoria"));
    }
}
