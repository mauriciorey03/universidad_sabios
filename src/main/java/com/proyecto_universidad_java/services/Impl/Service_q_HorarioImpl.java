package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_q_Horario;
import com.proyecto_universidad_java.repository.models.q_Horario;
import com.proyecto_universidad_java.services.Service_q_Horario;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_q_HorarioImpl implements Service_q_Horario {
    private final Repository_q_Horario crudRepository_q_Horario;

    public Service_q_HorarioImpl(Repository_q_Horario crudRepository_q_Horario) {
        this.crudRepository_q_Horario = crudRepository_q_Horario;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<q_Horario> listar() {
        return this.crudRepository_q_Horario.listar();
    }

    public q_Horario porCodigo(int codigo) {
        return this.crudRepository_q_Horario.porCodigo(codigo);
        }    

    public void crear(q_Horario obj){
        this.crudRepository_q_Horario.crear(obj);
    }

    public void editar(q_Horario obj){
        this.crudRepository_q_Horario.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_q_Horario.eliminar(codigo);        
    }
}