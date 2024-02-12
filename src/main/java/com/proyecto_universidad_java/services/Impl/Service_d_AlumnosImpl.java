package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_d_Alumnos;
import com.proyecto_universidad_java.repository.models.d_Alumnos;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.proyecto_universidad_java.services.Service_d_Alumnos;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_d_AlumnosImpl implements Service_d_Alumnos {
    private final Repository_d_Alumnos crudRepository_d_Alumnos;

    public Service_d_AlumnosImpl(Repository_d_Alumnos crudRepository_d_Alumnos) {
        this.crudRepository_d_Alumnos = crudRepository_d_Alumnos;
    }

    // private Connection getConnection() throws SQLException {
    // return ConexionBDMysql.getInstance();
    // }

    public List<d_Alumnos> listar() {
        return this.crudRepository_d_Alumnos.listar();
    }

    public List<m_Personas> toList() {
        return this.crudRepository_d_Alumnos.toList();
    }

    public d_Alumnos porCodigo(int codigo) {
        return this.crudRepository_d_Alumnos.porCodigo(codigo);
    }

    public void crear(d_Alumnos obj) {
        this.crudRepository_d_Alumnos.crear(obj);
    }

    public void editar(d_Alumnos obj) {
        this.crudRepository_d_Alumnos.editar(obj);
    }

    public void eliminar(int codigo) {
        this.crudRepository_d_Alumnos.eliminar(codigo);
    }
}