package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_m_Personas;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.proyecto_universidad_java.services.Service_m_Personas;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_m_PersonasImpl implements Service_m_Personas {
    private final Repository_m_Personas crudRepository_m_Personas;

    public Service_m_PersonasImpl(Repository_m_Personas crudRepository_m_Personas) {
        this.crudRepository_m_Personas = crudRepository_m_Personas;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<m_Personas> listar() {
        return this.crudRepository_m_Personas.listar();
    }

    public m_Personas porCodigo(int codigo) {
        return this.crudRepository_m_Personas.porCodigo(codigo);
        }    

    public void crear(m_Personas obj){
        this.crudRepository_m_Personas.crear(obj);
    }

    public void editar(m_Personas obj){
        this.crudRepository_m_Personas.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_m_Personas.eliminar(codigo);        
    }
}